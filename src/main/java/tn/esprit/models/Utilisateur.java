package tn.esprit.models;

import java.util.Date;
import java.util.Objects;

public class Utilisateur {
    private int idUser;
    private String nom;
    private String prenom;
    private String adresseMail;
    private String password;
    private Date dateNaissance;
    private Date dateCreationCompte;


    public Utilisateur() {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseMail = adresseMail;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.dateCreationCompte = dateCreationCompte;
    }


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateCreationCompte() {
        return dateCreationCompte;
    }

    public void setDateCreationCompte(Date dateCreationCompte) {
        this.dateCreationCompte = dateCreationCompte;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUser=" + idUser +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresseMail='" + adresseMail + '\'' +
                ", password='" + password + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", dateCreationCompte=" + dateCreationCompte +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, nom, prenom, adresseMail, password, dateNaissance, dateCreationCompte);
    }
}
