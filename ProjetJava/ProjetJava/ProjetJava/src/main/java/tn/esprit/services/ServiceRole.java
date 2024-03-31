package tn.esprit.services;

import tn.esprit.models.Role;

import java.util.ArrayList;
import java.util.List;

public class ServiceRole {
    private List<Role> roles;

    public ServiceRole() {
        this.roles = new ArrayList<>();
    }

    public void add(Role role) {
        roles.add(role);
    }

    public List<Role> getAll() {
        return roles;
    }

    public void update(Role role) {
        for (Role r : roles) {
            if (r.getNom().equals(role.getNom())) {
                r.setDescription(role.getDescription());
                break;
            }
        }
    }

    public void delete(Role role) {
        roles.removeIf(r -> r.getNom().equals(role.getNom()));
    }
}
