package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import tn.esprit.models.Recommendation;
import tn.esprit.services.RecommendationService;

import java.util.List;

public class RecommendationController {

    @FXML
    private TableView<Recommendation> tableView;

    @FXML
    private TableColumn<Recommendation, String> messageColumn;

    @FXML
    private TableColumn<Recommendation, String> categorieColumn;

    @FXML
    private TableColumn<Recommendation, String> statutColumn;

    @FXML
    private Button addButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField messageField;

    @FXML
    private TextField categorieField;

    @FXML
    private TextField statutField;

    private final RecommendationService recommendationService;

    public RecommendationController() {
        this.recommendationService = new RecommendationService();
    }

    @FXML
    private void initialize() {
        messageColumn.setCellValueFactory(cellData -> cellData.getValue().messageProperty());
        categorieColumn.setCellValueFactory(cellData -> cellData.getValue().categorieProperty());
        statutColumn.setCellValueFactory(cellData -> cellData.getValue().statutProperty());
        loadRecommendations();
    }

    @FXML
    private void handleAddButtonAction() {
        String message = messageField.getText();
        String categorie = categorieField.getText();
        String statut = statutField.getText();
        Recommendation recommendation = new Recommendation(message, categorie, statut);
        recommendationService.add(recommendation);
        loadRecommendations();
        clearFields();
    }

    @FXML
    private void handleUpdateButtonAction() {
        Recommendation selectedRecommendation = tableView.getSelectionModel().getSelectedItem();
        if (selectedRecommendation != null) {
            selectedRecommendation.setMessage(messageField.getText());
            selectedRecommendation.setCategorie(categorieField.getText());
            selectedRecommendation.setStatut(statutField.getText());
            recommendationService.update(selectedRecommendation);
            loadRecommendations();
            clearFields();
        } else {
            showAlert("Aucune recommandation sélectionnée", "Veuillez sélectionner une recommandation à mettre à jour.");
        }
    }

    @FXML
    private void handleDeleteButtonAction() {
        Recommendation selectedRecommendation = tableView.getSelectionModel().getSelectedItem();
        if (selectedRecommendation != null) {
            recommendationService.delete(selectedRecommendation.getId());
            loadRecommendations();
            clearFields();
        } else {
            showAlert("Aucune recommandation sélectionnée", "Veuillez sélectionner une recommandation à supprimer.");
        }
    }

    private void loadRecommendations() {
        List<Recommendation> recommendations = recommendationService.getAll();
        tableView.getItems().setAll(recommendations);
    }

    private void clearFields() {
        messageField.clear();
        categorieField.clear();
        statutField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
