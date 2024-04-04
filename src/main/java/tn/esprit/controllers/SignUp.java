package tn.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import tn.esprit.Utils.MaConnexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignUp {
    @FXML
    private DatePicker TFBirthDate;

    @FXML
    private TextField TFEmailAddress;

    @FXML
    private TextField TFName;

    @FXML
    private PasswordField TFPasswordCreated;

    @FXML
    private CheckBox clientCheckBox;

    @FXML
    private CheckBox freelancerCheckBox;

    @FXML
    private Button submitButton;

    @FXML
    void signUpUser(ActionEvent event) {
        String nom = TFName.getText();
        String adresseMail = TFEmailAddress.getText();
        String dateNaissance = TFBirthDate.getValue().toString();
        String password = TFPasswordCreated.getText();

        MaConnexion maConnexion = MaConnexion.getInstance();

        Connection connection = maConnexion.getCnx();

        try {
            String sql = "INSERT INTO Utilisateur (nom, adresseMail, dateNaissance, password) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nom);
            statement.setString(2, adresseMail);
            statement.setString(3, dateNaissance);
            statement.setString(4, password);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("The user has been signed up successfully.");

                if (freelancerCheckBox.isSelected()) {
                    redirectToSignUpFreelancer(event);
                } else if (clientCheckBox.isSelected()) {
                    redirectToSignUpClient(event);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please select either freelancer or client.");
                    alert.showAndWait();
                }
            } else {
                System.out.println("Failed to sign up user.");
            }

            statement.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void redirectToSignUpFreelancer(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SignUpFreelancer.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void redirectToSignUpClient(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SignUpClient.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
