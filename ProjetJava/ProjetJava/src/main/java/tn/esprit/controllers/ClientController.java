package tn.esprit.controllers;

import tn.esprit.models.Client;
import tn.esprit.services.ClientService;

import java.util.List;

public class ClientController {
    private ClientService clientService = new ClientService();

    public void addClient(Client client) {
        clientService.addClient(client);
    }

    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    public void updateClient(Client client) {
        clientService.updateClient(client);
    }

    public void deleteClient(int idUser) {
        clientService.deleteClient(idUser);
    }
}
