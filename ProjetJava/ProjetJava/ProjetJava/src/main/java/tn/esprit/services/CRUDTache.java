package tn.esprit.services;

import tn.esprit.models.Tache;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tn.esprit.Utils.MaConnexion;

public class CRUDTache {

    Statement ste;
    Connection conn= MaConnexion.getInstance().getCnx();

    public void ajouterTache(Tache c) {
        try {
            String req="INSERT INTO `tache`(`titre`, `description`,`status`) VALUES ('"+c.getTitre()+"','"+c.getDescription()+"','"+c.getStatus()+"')";

            ste=conn.createStatement();
            ste.executeUpdate(req);

            System.out.println("Tache ajouter avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    }
    public void modifierTache(Tache c,String titre,String description,String Status) {
        try {
            String requete4 = " UPDATE Tache SET " + "  titre= ?, description = ?, status = ? WHERE id= " + c.getId();
            PreparedStatement pst = MaConnexion.getInstance().getCnx().prepareStatement(requete4);
            pst.setString(1, titre);
            pst.setString(2, description);
            pst.setString(3, Status);
            pst.executeUpdate();
            System.out.println("Tache modifié !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void supprimerTache(Tache c) {
        try {
            String req = "DELETE FROM tache WHERE id='"+c.getId()+"'";
            ste=conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("tache supprimé avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression du Poste");
        }
    }
    public List<Tache> afficherTache() {
        List<Tache> list=new ArrayList<>();

        String req="SELECT * FROM `tache` ";
        Statement ste;
        try {

            ste = conn.createStatement();
            ResultSet RS=ste.executeQuery(req);
            while(RS.next()){
                Tache c =new Tache();
                c.setId(RS.getInt(1));
                c.setTitre(RS.getString("titre"));
                c.setDescription(RS.getString("description"));
                c.setStatus(RS.getString("status"));



                list.add(c);

            }
            System.out.println("affichage");
        } catch (SQLException ex) {
            System.out.println("erreur d afficahge");        }
        return list;
    }
    public Tache findbyid(int id) {
        String req="SELECT * FROM poste WHERE id='+id'";
        Statement ste;
        Tache c =new Tache();

        try {

            ste = conn.createStatement();
            ResultSet RS=ste.executeQuery(req);
            while(RS.next()){
                c.setId(RS.getInt(1));
                c.setTitre(RS.getString("titre"));
                c.setDescription(RS.getString("description"));
                c.setStatus(RS.getString("status"));


            }
        } catch (SQLException ex) {
            System.out.println("erreur d afficahge");        }

        return c;
    }

}
