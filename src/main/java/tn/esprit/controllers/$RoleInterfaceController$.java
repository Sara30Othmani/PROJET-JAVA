package tn.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import tn.esprit.Utils.MaConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class $RoleInterfaceController$ {

    @FXML
    private TextField lbname11;

    @FXML
    private TextField lbname111;

    @FXML
    private TextField lbname1111;

    @FXML
    private TextField lbname1112;

    @FXML
    void addRole(ActionEvent event) {
        String membrerole =lbname11.getText();
        String roleName = lbname111.getText();
        String roleId = lbname1111.getText();
        String roleDescription = lbname1112.getText();

        try {
            Connection connection = MaConnexion.getInstance().getCnx();
            String sql = "INSERT INTO role (Id,nom,description,Membre) VALUES (?,?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, roleName);
            statement.setString(2, roleId);
            statement.setString(3, roleDescription);
            statement.setString(4, membrerole);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                showAlert("Succès", "Le rôle a été ajouté avec succès.");
                clearFields();
            }
        } catch (SQLException e) {
            showAlert("Erreur", "Erreur lors de l'ajout du rôle : " + e.getMessage());
        }
    }
    //update role
    //delete role

    @FXML
    void AnnulerRole(ActionEvent event) {
        clearFields();
        showAlert("Info", "Ajout annulé.");
    }

    // Méthode utilitaire pour afficher une boîte de dialogue d'alerte
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Méthode utilitaire pour effacer les champs de l'interface utilisateur après l'ajout
    private void clearFields() {
        lbname111.clear();
        lbname1111.clear();
        lbname1112.clear();
    }
}
