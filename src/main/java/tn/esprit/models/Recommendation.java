package tn.esprit.models;

import java.time.LocalDateTime;

public class Recommendation {
    private String message;
    private Utilisateur utilisateur;
    private LocalDateTime dateCreation;
    private String categorie;
    private String statut;

    public Recommendation(String message, Utilisateur utilisateur, LocalDateTime dateCreation, String categorie, String statut) {
        this.message = message;
        this.utilisateur = utilisateur;
        this.dateCreation = dateCreation;
        this.categorie = categorie;
        this.statut = statut;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
