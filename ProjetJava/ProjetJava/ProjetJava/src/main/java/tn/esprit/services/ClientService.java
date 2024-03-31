public class ClientService {
    private
    ClientDao clientDao = new ClientDao();

    public void ajouterCollaboration(int idClient, String collaboration) {
        Client client = clientDao.getClient(idClient);
        if (client != null) {
            client.ajouterCollaboration(collaboration);
            clientDao.updateClient(client);
        }
    }

    public void supprimerCollaboration(int idClient, String collaboration) {
        Client client = clientDao.getClient(idClient);
        if (client != null) {
            client.supprimerCollaboration(collaboration);
            clientDao.updateClient(client);
        }
    }

    public void modifierCollaboration(int idClient, String ancienneCollaboration, String nouvelleCollaboration) {
        Client client = clientDao.getClient(idClient);
        if (client != null) {
            client.modifierCollaboration(ancienneCollaboration, nouvelleCollaboration);
            clientDao.updateClient(client);
        }
    }

}
