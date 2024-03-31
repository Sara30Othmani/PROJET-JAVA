package tn.esprit.models;

public class Facturation {
    private int id;
    private String details;
    private int prix;
    private Tache tache;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public Facturation(String details, int prix) {
        this.details = details;
        this.prix = prix;
    }

    public Facturation(int id, String details, int prix, Tache tache) {
        this.id = id;
        this.details = details;
        this.prix = prix;
        this.tache = tache;
    }

    public Facturation() {
    }

    public Facturation(String details, int prix, Tache tache) {
        this.details = details;
        this.prix = prix;
        this.tache = tache;
    }

}
