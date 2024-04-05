package tn.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tn.esprit.Utils.MaConnexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import tn.esprit.services.GoogleTranslate;

public class $EquipeInterfaceController$ {

        @FXML
        private TextField lbname;

        @FXML
        private TextField lbname1;

        @FXML
        private TextField lbname11;
        @FXML
        private TextField lbname12;
        @FXML
        private TextField lbname2;

        @FXML
        private TextField nomequipe;
        @FXML
        private TextField lbname13;
        @FXML
        private TextField lbname21;
        @FXML
        private TextField lbname121;
        @FXML
        private TextField lbname111;
        @FXML
        private Label nom;
        @FXML
        private Label id;
        @FXML
        private Label des;
        @FXML
        private Label mem;
        @FXML
        private Label bud;
        @FXML
        private Label eq;
        @FXML
        private Label eq1;
        @FXML
        private Label eq2;
        @FXML
        private Label eq3;
        @FXML
        private Label eq4;
        @FXML
        private Button affiche;
        @FXML
        private Button supp;
        @FXML
        private Button ajout;
        @FXML
        private Button annule;
        @FXML
        private Button modifier;





        @FXML
        void AddEquipe(ActionEvent event) {
                String equipeName = lbname.getText();
                String idequipe = lbname11.getText();
                String description = lbname2.getText();
                String membre = lbname12.getText();
                String budget = lbname11.getText();
                if (equipeName.isEmpty() || idequipe.isEmpty() || description.isEmpty()) {
                        showAlert("Erreur", "Veuillez remplir tous les champs.");
                        return;
                }

                try {
                        Connection connection = MaConnexion.getInstance().getCnx();
                        String sql = "INSERT INTO equipe (nom,Id, description,membres,budget) VALUES (?,?,?, ?, ?)";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, equipeName);
                        statement.setString(2, idequipe);
                        statement.setString(3, description);
                        statement.setString(4, membre);
                        statement.setString(5, budget);
                        int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0) {
                                showAlert("Succès", "L'équipe a été ajoutée avec succès.");
                                clearFields();
                        }
                } catch (SQLException e) {
                        showAlert("Erreur", "Erreur lors de l'ajout de l'équipe : " + e.getMessage());
                }
        }

        @FXML
        void UpdateEquipe(ActionEvent event) {
                String nom = nomequipe.getText();
                String id = lbname13.getText();
                String description = lbname21.getText();
                String membre = lbname121.getText();
                String budget = lbname111.getText();

                // Vérifiez si les champs sont vides
                if (nom.isEmpty() || id.isEmpty() || description.isEmpty()) {
                        showAlert("Erreur", "Veuillez remplir tous les champs.");
                        return;
                }

                try {
                        Connection connection = MaConnexion.getInstance().getCnx();
                        String sql = "UPDATE equipe SET membres = ?, budget = ?, nom = ?, description = ? WHERE id = ?";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, membre);
                        statement.setString(2, budget);
                        statement.setString(3, nom);
                        statement.setString(4, description);
                        statement.setString(5, id);
                        int rowsUpdated = statement.executeUpdate();
                        if (rowsUpdated > 0) {
                                showAlert("Succès", "L'équipe a été mise à jour avec succès.");
                                clearFields();
                        } else {
                                showAlert("Erreur", "Aucune équipe trouvée avec cet ID.");
                        }
                } catch (SQLException e) {
                        showAlert("Erreur", "Erreur lors de la mise à jour de l'équipe : " + e.getMessage());
                }

        }

        @FXML
        void afficheEquipe(ActionEvent event) {
                // Obtention de l'ID de l'équipe à afficher
                String idEquipe = lbname1.getText();

                // Vérification si l'ID est vide
                if (idEquipe.isEmpty()) {
                        showAlert("Erreur", "Veuillez saisir l'ID de l'équipe à afficher.");
                        return;
                }

                try {
                        Connection connection = MaConnexion.getInstance().getCnx();
                        String sql = "SELECT * FROM equipe WHERE id = ?";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, idEquipe);

                        ResultSet resultSet = statement.executeQuery();

                        // Vérification si l'équipe existe
                        if (resultSet.next()) {
                                // Récupération des données de l'équipe depuis le résultat de la requête
                                String nom = resultSet.getString("nom");
                                String description = resultSet.getString("description");
                                String membres = resultSet.getString("membres");
                                String budget = resultSet.getString("budget");

                                // Construction du message à afficher dans l'alerte
                                String message = "Nom: " + nom + "\n"
                                        + "Description: " + description + "\n"
                                        + "Membres: " + membres + "\n"
                                        + "Budget: " + budget;

                                // Affichage des détails de l'équipe dans une boîte d'alerte
                                showAlert("Détails de l'équipe", message);
                        } else {
                                showAlert("Erreur", "Aucune équipe trouvée avec cet ID.");
                        }
                } catch (SQLException e) {
                        showAlert("Erreur", "Erreur lors de la récupération des détails de l'équipe : " + e.getMessage());
                }
        }



                @FXML
        void AnnulerUpdate(ActionEvent event) {
                clearFields();
                showAlert("Info", "Mise à jour annulée.");
        }

        @FXML
        void AnnulerAjout(ActionEvent event) {
                clearFields();
                showAlert("Info", "Ajout annulé.");
        }

        private void showAlert(String title, String message) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(title);
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.showAndWait();
        }

        private void clearFields() {
                lbname.clear();
                lbname1.clear();
                lbname11.clear();
                lbname2.clear();
        }

        @FXML
        private void traduire(ActionEvent event) {
                try {
                        nom.setText(GoogleTranslate.translate("en",nom.getText()));
                        id.setText(GoogleTranslate.translate("en",id.getText()));
                        des.setText(GoogleTranslate.translate("en",des.getText()));
                        mem.setText(GoogleTranslate.translate("en",mem.getText()));
                        bud.setText(GoogleTranslate.translate("en",bud.getText()));
                        eq.setText(GoogleTranslate.translate("en",eq.getText()));
                        eq1.setText(GoogleTranslate.translate("en",eq1.getText()));
                        eq2.setText(GoogleTranslate.translate("en",eq2.getText()));
                        eq3.setText(GoogleTranslate.translate("en",eq3.getText()));
                        eq4.setText(GoogleTranslate.translate("en",eq4.getText()));
                        annule.setText(GoogleTranslate.translate("en",annule.getText()));
                        affiche.setText(GoogleTranslate.translate("en",affiche.getText()));
                        ajout.setText(GoogleTranslate.translate("en",ajout.getText()));
                        modifier.setText(GoogleTranslate.translate("en",modifier.getText()));
                        supp.setText(GoogleTranslate.translate("en",supp.getText()));
                } catch (IOException ex) {
                        Logger.getLogger($EquipeInterfaceController$.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
}
