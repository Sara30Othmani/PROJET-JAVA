public class FreelancerController {
    private FreelancerService freelancerService = new FreelancerService();

    public void ajouterCompetence(int idFreelancer, String competence) {
        freelancerService.ajouterCompetence(idFreelancer, competence);
    }

    public void supprimerCompetence(int idFreelancer, String competence) {
        freelancerService.supprimerCompetence(idFreelancer, competence);
    }

    public void modifierCompetence(int idFreelancer, String ancienneCompetence, String nouvelleCompetence) {
        freelancerService.modifierCompetence(idFreelancer, ancienneCompetence, nouvelleCompetence);
    }

    public void ajouterCertification(int idFreelancer, String certification) {
        freelancerService.ajouterCertification(idFreelancer, certification);
    }

    public void supprimerCertification(int idFreelancer, String certification) {
        freelancerService.supprimerCertification(idFreelancer, certification);
    }

}

