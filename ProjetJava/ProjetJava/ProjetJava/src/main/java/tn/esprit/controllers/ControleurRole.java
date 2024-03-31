package tn.esprit.controllers;

import tn.esprit.models.Role;
import tn.esprit.services.ServiceRole;

import java.util.List;

public class ControleurRole {
    private ServiceRole serviceRole;

    public ControleurRole() {
        this.serviceRole = new ServiceRole();
    }

    public void ajouterRole(Role role) {
        serviceRole.add(role);
    }

    public void mettreAJourRole(Role role) {
        serviceRole.update(role);
    }

    public void supprimerRole(Role role) {
        serviceRole.delete(role);
    }

    public List<Role> obtenirTousLesRoles() {
        return serviceRole.getAll();
    }
}
