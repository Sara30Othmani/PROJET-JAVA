package tn.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LogInUI {

    @FXML
    private TextField TFEmail;

    @FXML
    private PasswordField TFPassword;

    private final String url = "jdbc:mysql://localhost:3306/java";
    private final String login = "root";
    private final String pwd = "root";

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
        try (Connection connection = DriverManager.getConnection(url, login, pwd)) {
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


    public void RedirectSignup(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/SignUp.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void RedirectPassword(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ResetPassword.fxml"));
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
