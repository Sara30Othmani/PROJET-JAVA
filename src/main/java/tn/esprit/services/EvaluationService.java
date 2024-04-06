package evaluation.services;

import evaluation.models.Evaluation;
import tn.esprit.models.Utilisateur;

import java.time.LocalDateTime;
import java.util.List;

public class EvaluationService {
    public void ajouterEvaluation(float note, String commentaire, Utilisateur utilisateur, String categorie) {
        LocalDateTime dateCreation = LocalDateTime.now();
        String statut = "En attente"; // Vous pouvez définir un statut par défaut
        Evaluation evaluation = new Evaluation(note, commentaire, utilisateur, dateCreation, categorie, statut);
        // Logique pour ajouter l'évaluation à votre système de gestion de données
    }

    public List<Evaluation> obtenirEvaluations(Utilisateur utilisateur) {
        // Logique pour obtenir les évaluations associées à un utilisateur donné depuis votre système de gestion de données
        return null; // Remplacer null par la liste réelle des évaluations
    }

    public void modifierStatutEvaluation(Evaluation evaluation, String nouveauStatut) {
        evaluation.setStatut(nouveauStatut);
        // Logique pour mettre à jour le statut de l'évaluation dans votre système de gestion de données
    }
}
