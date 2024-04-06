package recommendation.models;

import tn.esprit.models.Utilisateur;

import java.time.LocalDateTime;

public class Recommendation {
    private String contenu;
    private Utilisateur utilisateur;
    private LocalDateTime dateCreation;

    public Recommendation(String contenu, Utilisateur utilisateur, LocalDateTime dateCreation) {
        this.contenu = contenu;
        this.utilisateur = utilisateur;
        this.dateCreation = dateCreation;
    }

    // Getters et setters pour tous les attributs

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }
}
