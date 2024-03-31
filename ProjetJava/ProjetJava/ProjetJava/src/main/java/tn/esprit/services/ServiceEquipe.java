package tn.esprit.services;

import tn.esprit.models.Equipe;

import java.util.ArrayList;
import java.util.List;

public class ServiceEquipe {
    private List<Equipe> equipes;

    public ServiceEquipe() {
        this.equipes = new ArrayList<>();
    }

    public void add(Equipe equipe) {
        equipes.add(equipe);
    }

    public List<Equipe> getAll() {
        return equipes;
    }

    public void update(Equipe equipe) {
        for (Equipe e : equipes) {
            if (e.getId() == equipe.getId()) {
                e.setNom(equipe.getNom());
                e.setDescription(equipe.getDescription());
                e.setBudget(equipe.getBudget());
                e.setMembres(equipe.getMembres());
                break;
            }
        }
    }

    public void delete(Equipe equipe) {
        equipes.removeIf(e -> e.getId() == equipe.getId());
    }
}
