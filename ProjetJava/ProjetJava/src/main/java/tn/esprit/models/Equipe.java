package tn.esprit.models;

import java.util.ArrayList;
import java.util.List;

public class Equipe {

    private int Id;
    private String nom;
        private String description;
        private List<Freelancer> membres;
        private double budget;

        // Constructeur
        public Equipe(int Id, String nom, String description, double budget, List<Freelancer> membres) {
            this.Id = Id;
            this.nom = nom;
            this.description = description;
            this.budget = budget;
            this.membres = membres;
        }


    public Equipe(int Id  , String nom, String description, double budget, ArrayList<Object> objects) {
    }

    // Getters et setters
    public int getId() {
        return Id;
    }

    public void setId(int Id ) {
        this.Id = Id;
    }
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

        public double getBudget() {
            return budget;
        }

        public void setBudget(double budget) {
            this.budget = budget;
        }
    // Getters et setters pour membres


    @Override
        public String toString() {
            return "Equipe{" +
                    "nom='" + nom + '\'' +
                    ", description='" + description + '\'' +
                    ", membres=" + membres +
                    ", budget=" + budget +
                    '}';
        }
    // Autres méthodes
    public void ajouterMembre(Freelancer membre) {
        membres.add(membre);
    }
    public List<Freelancer> getMembres() {
        return membres;
    }

    public void setMembres(List<Freelancer> membres) {
        this.membres = membres;
    }
    public void retirerMembre(Freelancer membre) {
        membres.remove(membre);
    }
    }


