package tn.esprit.services;

import tn.esprit.Utils.MaConnexion;
import tn.esprit.models.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurService {
    Connection cnx;

    public UtilisateurService() {
        MaConnexion m = new MaConnexion();
        cnx = m.getCnx();
    }

    public void add(Utilisateur utilisateur) {
        String qry = "INSERT INTO `utilisateur`(`nom`, `adresseMail`, `password`, `dateNaissance`, `dateCreationCompte`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setString(1, utilisateur.getNom());
            pstm.setString(2, utilisateur.getAdresseMail());
            pstm.setString(3, utilisateur.getPassword());
            pstm.setDate(4, new java.sql.Date(utilisateur.getDateNaissance().getTime()));
            pstm.setDate(5, new java.sql.Date(utilisateur.getDateCreationCompte().getTime()));
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Utilisateur> getAll() {
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        String qry = "SELECT * FROM `utilisateur`";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Utilisateur u = new Utilisateur();
                u.setIdUser(rs.getInt("idUser"));
                u.setNom(rs.getString("nom"));
                u.setAdresseMail(rs.getString("adresseMail"));
                u.setPassword(rs.getString("password"));
                u.setDateNaissance(rs.getDate("dateNaissance"));
                u.setDateCreationCompte(rs.getDate("dateCreationCompte"));
                utilisateurs.add(u);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return utilisateurs;
    }

    public void update(Utilisateur utilisateur) {
        String qry = "UPDATE `utilisateur` SET `nom`=?,`adresseMail`=?,`password`=?,`dateNaissance`=?,`dateCreationCompte`=? WHERE `idUser`=?";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setString(1, utilisateur.getNom());
            pstm.setString(2, utilisateur.getAdresseMail());
            pstm.setString(3, utilisateur.getPassword());
            pstm.setDate(4, new java.sql.Date(utilisateur.getDateNaissance().getTime()));
            pstm.setDate(5, new java.sql.Date(utilisateur.getDateCreationCompte().getTime()));
            pstm.setInt(6, utilisateur.getIdUser());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int idUser) {
        String qry = "DELETE FROM `utilisateur` WHERE `idUser`=?";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setInt(1, idUser);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
