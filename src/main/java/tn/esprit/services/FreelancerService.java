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
        String qry = "INSERT INTO `freelancer`(`nom`, `adresseMail`, `password`, `dateNaissance`, `dateCreationCompte`, `competences`, `domaineExpertise`, `tauxHoraire`, `certifications`, `niveauExperience`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setString(1, freelancer.getNom());
            pstm.setString(2, freelancer.getAdresseMail());
            pstm.setString(3, freelancer.getPassword());
            pstm.setDate(4, new java.sql.Date(freelancer.getDateNaissance().getTime()));
            pstm.setDate(5, new java.sql.Date(freelancer.getDateCreationCompte().getTime()));
            pstm.setString(6, String.join(",", freelancer.getCompetences()));
            pstm.setString(7, freelancer.getDomaineExpertise());
            pstm.setDouble(8, freelancer.getTauxHoraire());
            pstm.setString(9, String.join(",", freelancer.getCertifications()));
            pstm.setString(10, freelancer.getNiveauExperience().name());
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
        String qry = "UPDATE `freelancer` SET `nom`=?, `adresseMail`=?,`password`=?,`dateNaissance`=?,`dateCreationCompte`=?,`competences`=?,`domaineExpertise`=?,`tauxHoraire`=?,`certifications`=?,`niveauExperience`=? WHERE `idUser`=?";
        try {
            PreparedStatement pstm = cnx.prepareStatement(qry);
            pstm.setString(1, freelancer.getNom());
            pstm.setString(2, freelancer.getAdresseMail());
            pstm.setString(3, freelancer.getPassword());
            pstm.setDate(4, new java.sql.Date(freelancer.getDateNaissance().getTime()));
            pstm.setDate(5, new java.sql.Date(freelancer.getDateCreationCompte().getTime()));
            pstm.setString(6, String.join(",", freelancer.getCompetences()));
            pstm.setString(7, freelancer.getDomaineExpertise());
            pstm.setDouble(8, freelancer.getTauxHoraire());
            pstm.setString(9, String.join(",", freelancer.getCertifications()));
            pstm.setString(10, freelancer.getNiveauExperience().name());
            pstm.setInt(11, freelancer.getIdUser());
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
