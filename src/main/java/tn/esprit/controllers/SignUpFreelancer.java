package tn.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import tn.esprit.Utils.MaConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpFreelancer {

    @FXML
    private TextArea TFCertifications;

    @FXML
    private TextField TFExpertise;

    @FXML
    private TextField TFHourlyRate;

    @FXML
    private ChoiceBox<String> TFLevelExperience;

    @FXML
    private TextArea TFSkills;

    @FXML
    void initialize() {
        TFLevelExperience.getItems().addAll("Beginner", "Intermediate", "Experienced", "Expert");
    }

    @FXML
    void submitSignFreelancer(ActionEvent event) {
        String domaineExpertise = TFExpertise.getText();
        String tauxHoraire = TFHourlyRate.getText();
        String niveauExperience = TFLevelExperience.getValue();
        String competences = TFSkills.getText();
        String certifications = TFCertifications.getText();

        int idUser = getUserIdFromDatabase(); // Méthode à implémenter pour récupérer l'id de l'utilisateur

        if (idUser != -1) {
            MaConnexion maConnexion = MaConnexion.getInstance();
            Connection connection = maConnexion.getCnx();

            try {
                String sqlFreelancer = "INSERT INTO Freelancer (idUser, competences, domaineExpertise, tauxHoraire, certifications, niveauExperience) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement statementFreelancer = connection.prepareStatement(sqlFreelancer);
                statementFreelancer.setInt(1, idUser);
                statementFreelancer.setString(2, competences);
                statementFreelancer.setString(3, domaineExpertise);
                statementFreelancer.setString(4, tauxHoraire);
                statementFreelancer.setString(5, certifications);
                statementFreelancer.setString(6, niveauExperience);

                int rowsAffectedFreelancer = statementFreelancer.executeUpdate();

                if (rowsAffectedFreelancer > 0) {
                    System.out.println("Freelancer signed up successfully.");
                } else {
                    System.out.println("Failed to sign up freelancer.");
                }

                statementFreelancer.close();
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
}
