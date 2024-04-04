package tn.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tn.esprit.Utils.MaConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInUI {

    @FXML
    private TextField TFEmail;

    @FXML
    private PasswordField TFPassword;

    @FXML
    void LogIn(ActionEvent event) {
        String adresseMail = TFEmail.getText();
        String password = TFPassword.getText();

        if (adresseMail.isEmpty() || password.isEmpty()) {
            System.out.println("Veuillez remplir tous les champs.");
            return;
        }

        if (authenticateUser(adresseMail, password)) {
            System.out.println("Connexion réussie!");
        } else {
            System.out.println("Adresse mail ou mot de passe incorrect.");
        }
    }

    private boolean authenticateUser(String email, String password) {
        MaConnexion maConnexion = MaConnexion.getInstance();
        Connection connection = maConnexion.getCnx();

        try {
            String sql = "SELECT * FROM Utilisateur WHERE adresseMail = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next(); // true si un utilisateur correspondant est trouvé, sinon false

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
