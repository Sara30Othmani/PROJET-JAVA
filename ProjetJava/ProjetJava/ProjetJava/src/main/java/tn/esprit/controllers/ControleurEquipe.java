package tn.esprit.controllers;
import tn.esprit.models.Equipe;
import tn.esprit.services.ServiceEquipe;

import java.util.List;

public class ControleurEquipe {
    private ServiceEquipe serviceEquipe;

    public ControleurEquipe() {
        this.serviceEquipe = new ServiceEquipe();
    }

    // Méthode pour ajouter une équipe
    public void ajouterEquipe(Equipe equipe) {
        serviceEquipe.add(equipe);
    }

    // Méthode pour mettre à jour une équipe
    public void mettreAJourEquipe(Equipe equipe) {
        serviceEquipe.update(equipe);
    }

    // Méthode pour supprimer une équipe
    public void supprimerEquipe(Equipe equipe) {
        serviceEquipe.delete(equipe);
    }

    // Méthode pour obtenir toutes les équipes
    public List<Equipe> obtenirToutesLesEquipes() {
        return serviceEquipe.getAll();
    }
}
