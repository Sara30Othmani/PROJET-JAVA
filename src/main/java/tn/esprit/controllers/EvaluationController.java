package evaluation.controllers;

import evaluation.models.Evaluation;
import evaluation.services.EvaluationService;
import tn.esprit.models.Utilisateur;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EvaluationController {
    @FXML
    private TextField noteTextField;

    @FXML
    private TextArea commentaireTextArea;

    private EvaluationService evaluationService;

    public EvaluationController() {
        this.evaluationService = new EvaluationService();
    }

    @FXML
    private void ajouterEvaluation() {
        float note = Float.parseFloat(noteTextField.getText());
        String commentaire = commentaireTextArea.getText();

        Utilisateur utilisateur = new Utilisateur();
        String categorie = "Votre catégorie";
        evaluationService.ajouterEvaluation(note, commentaire, utilisateur, categorie);

    }
}
