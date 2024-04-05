package tn.esprit.models;

public class Role {
    private String Membre;
    private int Id;
    private String nom;
    private String description;

    // Constructeur
    public Role(String nom, String description) {
        this.Membre=Membre;
        this.Id = Id ;
        this.nom = nom;
        this.description = description;
    }
    public String getMembre() {
        return Membre;
    }
    public void setMembre(String Membre) {
        this.Membre = Membre;
    }
    public int getId() {
        return Id;
    }
    public void setId(int Id) {
        this.Id = Id;
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

