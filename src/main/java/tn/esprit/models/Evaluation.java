package tn.esprit.models;

import java.time.LocalDateTime;

public class Evaluation {
    private float note;
    private String commentaire;
    private Utilisateur utilisateur;
    private LocalDateTime dateCreation;
    private String categorie;
    private String statut;

    public Evaluation(float note, String commentaire, Utilisateur utilisateur, LocalDateTime dateCreation, String categorie, String statut) {
        this.note = note;
        this.commentaire = commentaire;
        this.utilisateur = utilisateur;
        this.dateCreation = dateCreation;
        this.categorie = categorie;
        this.statut = statut;
    }

    // Getters and setters
    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
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
