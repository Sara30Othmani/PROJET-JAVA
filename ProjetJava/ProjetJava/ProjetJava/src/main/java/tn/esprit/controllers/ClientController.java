package tn.esprit.controllers;
import tn.esprit.services.ClientService;

public class ClientController {
    private ClientService clientService = new ClientService();

    public void ajouterCollaboration(int idClient, String collaboration) {
        clientService.ajouterCollaboration(idClient, collaboration);
    }

    public void supprimerCollaboration(int idClient, String collaboration) {
        clientService.supprimerCollaboration(idClient, collaboration);
    }

    public void modifierCollaboration(int idClient, String ancienneCollaboration, String nouvelleCollaboration) {
        clientService.modifierCollaboration(idClient, ancienneCollaboration, nouvelleCollaboration);
    }

}
