package tn.esprit.models;

import java.util.List;

public class Freelancer extends Utilisateur {
    private int idFreelancer;
    private List<String> competences;
    private String domaineExpertise;
    private double tauxHoraire;
    private List<String> certifications;
    private NiveauExperience niveauExperience;


    public Freelancer(int idUser, String nom, String prenom, String adresseMail, String password, Date dateNaissance, Date dateCreationCompte, int idFreelancer, List<String> competences, String domaineExpertise, double tauxHoraire, List<String> certifications, NiveauExperience niveauExperience) {
        super(idUser, nom, prenom, adresseMail, password, dateNaissance, dateCreationCompte);
        this.idFreelancer = idFreelancer;
        this.competences = competences;
        this.domaineExpertise = domaineExpertise;
        this.tauxHoraire = tauxHoraire;
        this.certifications = certifications;
        this.niveauExperience = niveauExperience;
    }


    public int getIdFreelancer() {
        return idFreelancer;
    }

    public void setIdFreelancer(int idFreelancer) {
        this.idFreelancer = idFreelancer;
    }

    public List<String> getCompetences() {
        return competences;
    }

    public void setCompetences(List<String> competences) {
        this.competences = competences;
    }

    public String getDomaineExpertise() {
        return domaineExpertise;
    }

    public void setDomaineExpertise(String domaineExpertise) {
        this.domaineExpertise = domaineExpertise;
    }

    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public List<String> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<String> certifications) {
        this.certifications = certifications;
    }

    public NiveauExperience getNiveauExperience() {
        return niveauExperience;
    }

    public void setNiveauExperience(NiveauExperience niveauExperience) {
        this.niveauExperience = niveauExperience;
    }

    @Override
    public String toString() {
        return "Freelancer{" +
                "idFreelancer=" + idFreelancer +
                ", competences=" + competences +
                ", domaineExpertise='" + domaineExpertise + '\'' +
                ", tauxHoraire=" + tauxHoraire +
                ", certifications=" + certifications +
                ", niveauExperience=" + niveauExperience +
                "} " + super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idFreelancer, competences, domaineExpertise, tauxHoraire, certifications, niveauExperience);
    }


    // CRUD pour les compétences
    public void ajouterCompetence(String competence) {
        competences.add(competence);
    }

    public void supprimerCompetence(String competence) {
        competences.remove(competence);
    }

    public void modifierCompetence(String ancienneCompetence, String nouvelleCompetence) {
        int i = competences.indexOf(ancienneCompetence);
        if (i != -1) {
            competences.set(index, nouvelleCompetence);
        }
    }

    // CRUD pour les certifications
    public void ajouterCertification(String certification) {
        certifications.add(certification);
    }

    public void supprimerCertification(String certification) {
        certifications.remove(certification);
    }
}
