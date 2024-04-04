package tn.esprit.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import tn.esprit.models.Evaluation;
import tn.esprit.services.EvaluationService;

import java.util.List;

public class EvaluationController {

    @FXML
    private TableView<Evaluation> tableView;

    @FXML
    private TableColumn<Evaluation, Float> noteColumn;

    @FXML
    private TableColumn<Evaluation, String> commentaireColumn;

    @FXML
    private TableColumn<Evaluation, String> categorieColumn;

    @FXML
    private TableColumn<Evaluation, String> statutColumn;

    @FXML
    private Button addButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField noteField;

    @FXML
    private TextField commentaireField;

    @FXML
    private TextField categorieField;

    @FXML
    private TextField statutField;

    private final EvaluationService evaluationService;

    public EvaluationController() {
        this.evaluationService = new EvaluationService();
    }

    @FXML
    private void initialize() {
        noteColumn.setCellValueFactory(cellData -> cellData.getValue().noteProperty().asObject());
        commentaireColumn.setCellValueFactory(cellData -> cellData.getValue().commentaireProperty());
        categorieColumn.setCellValueFactory(cellData -> cellData.getValue().categorieProperty());
        statutColumn.setCellValueFactory(cellData -> cellData.getValue().statutProperty());
        loadEvaluations();
    }

    @FXML
    private void handleAddButtonAction() {
        float note = Float.parseFloat(noteField.getText());
        String commentaire = commentaireField.getText();
        String categorie = categorieField.getText();
        String statut = statutField.getText();
        Evaluation evaluation = new Evaluation(note, commentaire, categorie, statut);
        evaluationService.add(evaluation);
        loadEvaluations();
        clearFields();
    }

    @FXML
    private void handleUpdateButtonAction() {
        Evaluation selectedEvaluation = tableView.getSelectionModel().getSelectedItem();
        if (selectedEvaluation != null) {
            selectedEvaluation.setNote(Float.parseFloat(noteField.getText()));
            selectedEvaluation.setCommentaire(commentaireField.getText());
            selectedEvaluation.setCategorie(categorieField.getText());
            selectedEvaluation.setStatut(statutField.getText());
            evaluationService.update(selectedEvaluation);
            loadEvaluations();
            clearFields();
        } else {
            showAlert("Aucune évaluation sélectionnée", "Veuillez sélectionner une évaluation à mettre à jour.");
        }
    }

    @FXML
    private void handleDeleteButtonAction() {
        Evaluation selectedEvaluation = tableView.getSelectionModel().getSelectedItem();
        if (selectedEvaluation != null) {
            evaluationService.delete(selectedEvaluation.getId());
            loadEvaluations();
            clearFields();
        } else {
            showAlert("Aucune évaluation sélectionnée", "Veuillez sélectionner une évaluation à supprimer.");
        }
    }

    private void loadEvaluations() {
        List<Evaluation> evaluations = evaluationService.getAll();
        tableView.getItems().setAll(evaluations);
    }

    private void clearFields() {
        noteField.clear();
        commentaireField.clear();
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
