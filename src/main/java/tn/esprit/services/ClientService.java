package tn.esprit.services;

import tn.esprit.Utils.MaConnexion;
import tn.esprit.models.Client;
import tn.esprit.models.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    Connection cnx;

    public ClientService() {
        MaConnexion m = new MaConnexion();
        cnx = m.getCnx();
    }

    public void addClient(Client client) {
        String qry = "INSERT INTO `client`(`idUser`, `nom`, `prenom`, `adresseMail`, `password`, `dateNaissance`, `dateCreationCompte`, `nomEntreprise`, `domaineActivite`) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setInt(1, client.getIdUser());
            pstm.setString(2, client.getNom());
            pstm.setString(3, client.getPrenom());
            pstm.setString(4, client.getAdresseMail());
            pstm.setString(5, client.getPassword());
            pstm.setDate(6, new java.sql.Date(client.getDateNaissance().getTime()));
            pstm.setDate(7, new java.sql.Date(client.getDateCreationCompte().getTime()));
            pstm.setString(8, client.getNomEntreprise());
            pstm.setString(9, client.getDomaineActivite());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Client> getAllClients() {
        ArrayList<Client> clients = new ArrayList<>();
        String qry = "SELECT * FROM `client`";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Client c = new Client();
                c.setIdUser(rs.getInt("idClient"));
                c.setNom(rs.getString("nomClient"));
                c.setPrenom(rs.getString("prenomClient"));
                c.setAdresseMail(rs.getString("adresseMailClient"));
                c.setPassword(rs.getString("passwordClient"));
                c.setDateNaissance(rs.getDate("dateNaissanceClient"));
                c.setDateCreationCompte(rs.getDate("dateCreationCompteClient"));
                c.setNomEntreprise(rs.getString("nomEntreprise"));
                c.setDomaineActivite(rs.getString("domaineActivite"));
                clients.add(c);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }


    public void updateClient(Client client) {
        String qry = "UPDATE `client` SET `nom`=?,`prenom`=?,`adresseMail`=?,`password`=?,`dateNaissance`=?,`dateCreationCompte`=?,`nomEntreprise`=?,`domaineActivite`=? WHERE `idUser`=?";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setString(1, client.getNom());
            pstm.setString(2, client.getPrenom());
            pstm.setString(3, client.getAdresseMail());
            pstm.setString(4, client.getPassword());
            pstm.setDate(5, new java.sql.Date(client.getDateNaissance().getTime()));
            pstm.setDate(6, new java.sql.Date(client.getDateCreationCompte().getTime()));
            pstm.setString(7, client.getNomEntreprise());
            pstm.setString(8, client.getDomaineActivite());
            pstm.setInt(9, client.getIdUser());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteClient(int idUser) {
        String qry = "DELETE FROM `client` WHERE `idUser`=?";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setInt(1, idUser);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
