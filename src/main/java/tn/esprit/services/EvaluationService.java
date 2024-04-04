package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;
import tn.esprit.models.Evaluation;

public class EvaluationService {
    private List<Evaluation> evaluations;

    public EvaluationService() {
        this.evaluations = new ArrayList<>();
    }

    public void ajouterEvaluation(Evaluation evaluation) {
        evaluations.add(evaluation);
    }

    public void supprimerEvaluation(Evaluation evaluation) {
        evaluations.remove(evaluation);
    }

    public List<Evaluation> obtenirToutesEvaluations() {
        return evaluations;
    }
}
