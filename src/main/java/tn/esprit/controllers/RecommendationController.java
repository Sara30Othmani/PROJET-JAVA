package recommendation.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import recommendation.services.RecommendationService;
import tn.esprit.models.Utilisateur;

public class RecommendationController {
    @FXML
    private TextArea recommendationTextArea;

    private RecommendationService recommendationService;
    private Utilisateur utilisateurConnecte;

    public RecommendationController(Utilisateur utilisateur) {
        this.utilisateurConnecte = utilisateur;
        this.recommendationService = new RecommendationService();
    }

    @FXML
    private void ajouterRecommendation() {
        String contenu = recommendationTextArea.getText();
        recommendationService.ajouterRecommendation(contenu, utilisateurConnecte);
    }
}
