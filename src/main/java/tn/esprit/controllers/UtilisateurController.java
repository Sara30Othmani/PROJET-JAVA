package tn.esprit.controllers;

import tn.esprit.models.Utilisateur;
import tn.esprit.services.FreelancerService;
import tn.esprit.services.UtilisateurService;

import java.util.List;

public class UtilisateurController {
    private UtilisateurService utilisateurService = new UtilisateurService();

    public UtilisateurController() {
        this.utilisateurService = new UtilisateurService();
    }

    public void addUser(Utilisateur utilisateur) {
        utilisateurService.add(utilisateur);
    }

    public List<Utilisateur> getAllUsers() {
        return utilisateurService.getAll();
    }

    public void updateUser(Utilisateur utilisateur) {
        utilisateurService.update(utilisateur);
    }

    public void deleteUser(int idUser) {
        utilisateurService.delete(idUser);
    }
}
