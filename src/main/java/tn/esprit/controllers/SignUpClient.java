package tn.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.Utils.MaConnexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpClient {

    @FXML
    private TextField TFCompany;

    @FXML
    private TextField TFField;

    @FXML
    void submitSignClient(ActionEvent event) {
        String nomEntreprise = TFCompany.getText();
        String domaineActivite = TFField.getText();

        int idUser = getUserIdFromDatabase();

        if (idUser != -1) {
            MaConnexion maConnexion = MaConnexion.getInstance();
            Connection connection = maConnexion.getCnx();

            try {
                String sqlClient = "INSERT INTO Client (idUser, nomEntreprise, domaineActivite) VALUES (?, ?, ?)";
                PreparedStatement statementClient = connection.prepareStatement(sqlClient);
                statementClient.setInt(1, idUser);
                statementClient.setString(2, nomEntreprise);
                statementClient.setString(3, domaineActivite);

                int rowsAffectedClient = statementClient.executeUpdate();

                if (rowsAffectedClient > 0) {
                    System.out.println("Client signed up successfully.");
                } else {
                    System.out.println("Failed to sign up client.");
                }

                statementClient.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private int getUserIdFromDatabase() {
        MaConnexion maConnexion = MaConnexion.getInstance();
        Connection connection = maConnexion.getCnx();
        int id = -1;

        try {
            String sql = "SELECT idUser FROM Utilisateur ORDER BY idUser DESC LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("idUser");
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public void RedirectLogIn(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogInUI.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}