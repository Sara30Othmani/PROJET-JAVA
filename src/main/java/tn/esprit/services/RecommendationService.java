package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;
import tn.esprit.models.Recommendation;

public class RecommendationService {
    private List<Recommendation> recommendations;

    public RecommendationService() {
        this.recommendations = new ArrayList<>();
    }

    public void ajouterRecommendation(Recommendation recommendation) {
        recommendations.add(recommendation);
    }

    public void supprimerRecommendation(Recommendation recommendation) {
        recommendations.remove(recommendation);
    }

    public List<Recommendation> obtenirToutesRecommandations() {
        return recommendations;
    }
}
