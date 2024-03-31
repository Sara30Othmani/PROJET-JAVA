package tn.esprit.models;

public class Role {
    private String nom;
    private String description;

    // Constructeur
    public Role(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

