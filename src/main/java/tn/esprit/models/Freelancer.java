package tn.esprit.models;

import java.util.List;
import java.util.Objects;

public class Freelancer extends Utilisateur {
    private List<String> competences;
    private String domaineExpertise;
    private double tauxHoraire;
    private List<String> certifications;
    private NiveauExperience niveauExperience;


    public Freelancer() {
        super();
        this.competences = competences;
        this.domaineExpertise = domaineExpertise;
        this.tauxHoraire = tauxHoraire;
        this.certifications = certifications;
        this.niveauExperience = niveauExperience;
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
                ", competences=" + competences +
                ", domaineExpertise='" + domaineExpertise + '\'' +
                ", tauxHoraire=" + tauxHoraire +
                ", certifications=" + certifications +
                ", niveauExperience=" + niveauExperience +
                "} " + super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), competences, domaineExpertise, tauxHoraire, certifications, niveauExperience);
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
            competences.set(i, nouvelleCompetence);
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
