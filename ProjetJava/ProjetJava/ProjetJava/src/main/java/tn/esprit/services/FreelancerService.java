public class FreelancerService {
    private FreelancerDao freelancerDao = new FreelancerDao();

    public void ajouterCompetence(int idFreelancer, String competence) {
        Freelancer freelancer = freelancerDao.getFreelancer(idFreelancer);
        if (freelancer != null) {
            freelancer.ajouterCompetence(competence);
            freelancerDao.updateFreelancer(freelancer);
        }
    }

    public void supprimerCompetence(int idFreelancer, String competence) {
        Freelancer freelancer = freelancerDao.getFreelancer(idFreelancer);
        if (freelancer != null) {
            freelancer.supprimerCompetence(competence);
            freelancerDao.updateFreelancer(freelancer);
        }
    }

    public void modifierCompetence(int idFreelancer, String ancienneCompetence, String nouvelleCompetence) {
        Freelancer freelancer = freelancerDao.getFreelancer(idFreelancer);
        if (freelancer != null) {
            freelancer.modifierCompetence(ancienneCompetence, nouvelleCompetence);
            freelancerDao.updateFreelancer(freelancer);
        }
    }

    public void ajouterCertification(int idFreelancer, String certification) {
        Freelancer freelancer = freelancerDao.getFreelancer(idFreelancer);
        if (freelancer != null) {
            freelancer.ajouterCertification(certification);
            freelancerDao.updateFreelancer(freelancer);
        }
    }

    public void supprimerCertification(int idFreelancer, String certification) {
        Freelancer freelancer = freelancerDao.getFreelancer(idFreelancer);
        if (freelancer != null) {
            freelancer.supprimerCertification(certification);
            freelancerDao.updateFreelancer(freelancer);
        }
    }

}

