package tn.esprit.services;

import tn.esprit.Utils.MaConnexion;
import tn.esprit.models.Freelancer;
import tn.esprit.models.NiveauExperience;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FreelancerService {
    Connection cnx;

    public FreelancerService() {
        MaConnexion m = new MaConnexion();
        cnx = m.getCnx();
    }

    public void addFreelancer(Freelancer freelancer) {
        String qry = "INSERT INTO `freelancer`(`idUser`, `nom`, `prenom`, `adresseMail`, `password`, `dateNaissance`, `dateCreationCompte`, `competences`, `domaineExpertise`, `tauxHoraire`, `certifications`, `niveauExperience`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setInt(1, freelancer.getIdUser());
            pstm.setString(2, freelancer.getNom());
            pstm.setString(3, freelancer.getPrenom());
            pstm.setString(4, freelancer.getAdresseMail());
            pstm.setString(5, freelancer.getPassword());
            pstm.setDate(6, new java.sql.Date(freelancer.getDateNaissance().getTime()));
            pstm.setDate(7, new java.sql.Date(freelancer.getDateCreationCompte().getTime()));
            // La conversion de la liste en chaîne de caractères doit être gérée ici pour les colonnes `competences` et `certifications`
            pstm.setString(8, String.join(",", freelancer.getCompetences()));
            pstm.setString(9, freelancer.getDomaineExpertise());
            pstm.setDouble(10, freelancer.getTauxHoraire());
            pstm.setString(11, String.join(",", freelancer.getCertifications()));
            pstm.setString(12, freelancer.getNiveauExperience().name());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Freelancer> getAllFreelancers() {
        ArrayList<Freelancer> freelancers = new ArrayList<>();
        String qry = "SELECT * FROM `freelancer`";
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Freelancer f = new Freelancer();
                f.setIdUser(rs.getInt("idFreelancer"));
                f.setNom(rs.getString("nomFreelancer"));
                f.setPrenom(rs.getString("prenomFreelancer"));
                f.setAdresseMail(rs.getString("adresseMailFreelancer"));
                f.setPassword(rs.getString("passwordFreelancer"));
                f.setDateNaissance(rs.getDate("dateNaissanceFreelancer"));
                f.setDateCreationCompte(rs.getDate("dateCreationCompteFreelancer"));
                f.setCompetences(List.of(rs.getString("competences").split(",")));
                f.setDomaineExpertise(rs.getString("domaineExpertise"));
                f.setTauxHoraire(rs.getDouble("tauxHoraire"));
                f.setCertifications(List.of(rs.getString("certifications").split(",")));
                f.setNiveauExperience(NiveauExperience.valueOf(rs.getString("niveauExperience")));
                freelancers.add(f);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return freelancers;
    }

    public void updateFreelancer(Freelancer freelancer) {
        String qry = "UPDATE `freelancer` SET `nom`=?,`prenom`=?,`adresseMail`=?,`password`=?,`dateNaissance`=?,`dateCreationCompte`=?,`competences`=?,`domaineExpertise`=?,`tauxHoraire`=?,`certifications`=?,`niveauExperience`=? WHERE `idUser`=?";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setString(1, freelancer.getNom());
            pstm.setString(2, freelancer.getPrenom());
            pstm.setString(3, freelancer.getAdresseMail());
            pstm.setString(4, freelancer.getPassword());
            pstm.setDate(5, new java.sql.Date(freelancer.getDateNaissance().getTime()));
            pstm.setDate(6, new java.sql.Date(freelancer.getDateCreationCompte().getTime()));
            pstm.setString(7, String.join(",", freelancer.getCompetences()));
            pstm.setString(8, freelancer.getDomaineExpertise());
            pstm.setDouble(9, freelancer.getTauxHoraire());
            pstm.setString(10, String.join(",", freelancer.getCertifications()));
            pstm.setString(11, freelancer.getNiveauExperience().name());
            pstm.setInt(12, freelancer.getIdUser());
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void deleteFreelancer(int idUser) {
        String qry = "DELETE FROM `freelancer` WHERE `idUser`=?";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setInt(1, idUser);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
