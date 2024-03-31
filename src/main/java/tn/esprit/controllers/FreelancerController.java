package tn.esprit.controllers;

import tn.esprit.models.Freelancer;
import tn.esprit.services.FreelancerService;

import java.util.List;

public class FreelancerController {
    private FreelancerService freelancerService = new FreelancerService();

    public FreelancerController() {
        this.freelancerService = new FreelancerService();
    }

    public void addFreelancer(Freelancer freelancer) {
        freelancerService.addFreelancer(freelancer);
    }

    public List<Freelancer> getAllFreelancers() {
        return freelancerService.getAllFreelancers();
    }

    public void updateFreelancer(Freelancer freelancer) {
        freelancerService.updateFreelancer(freelancer);
    }

    public void deleteFreelancer(int idUser) {
        freelancerService.deleteFreelancer(idUser);
    }

}

