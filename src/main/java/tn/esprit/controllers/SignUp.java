package tn.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tn.esprit.Utils.MaConnexion;

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
    void SignUp(ActionEvent event) {

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

            } else {
                System.out.println("Failed to sign up user.");

            }


            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
