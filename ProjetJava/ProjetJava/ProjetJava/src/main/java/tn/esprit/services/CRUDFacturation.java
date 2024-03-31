package tn.esprit.services;

import tn.esprit.models.Facturation;
import tn.esprit.models.Tache;
import tn.esprit.Utils.MaConnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CRUDFacturation {
    Statement ste;

    Connection conn= MaConnexion.getInstance().getCnx();

    public void ajouterFacturation(Facturation c,int t) {
        try {
            String req="INSERT INTO `facturation`(`details`, `prix`, `tache`) VALUES ('"+c.getDetails()+"','"+c.getPrix()+"','"+t+"')";

            ste=conn.createStatement();
            ste.executeUpdate(req);

            System.out.println("Facturation ajouter avec succes");
        } catch (SQLException ex) {
            System.out.println("Facturation non ajouter");        }
    }
    public void supprimerFacturation(Facturation c) {
        try {
            String req = "DELETE FROM `facturation` WHERE `id` = " + c.getId();
            Statement ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Facturation supprimée avec succès");
        } catch (SQLException ex) {
            System.out.println("Facturation non supprimée");
        }
    }
    public void modifierFacturation(Facturation c) {
        try {
            String req = "UPDATE `facturation` SET `details` = '" + c.getDetails() + "', `prix` = '" + c.getPrix() + "' WHERE `id` = " + c.getId();
            Statement ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("Facturation modifiée avec succès");
        } catch (SQLException ex) {
            System.out.println("Facturation non modifiée");
        }
    }
    public List<Facturation> afficherFacturation() {
        List<Facturation> listeFacturation = new ArrayList<>();

        String req = "SELECT * FROM `facturation`";
        Statement ste;
        try {
            ste = conn.createStatement();
            ResultSet RS = ste.executeQuery(req);
            while (RS.next()) {
                Facturation f = new Facturation();
                f.setId(RS.getInt(1)); // Assuming the ID is the first column
                f.setDetails(RS.getString("details"));
                f.setPrix(RS.getInt("prix")); // Assuming prix is a double

                // You can also add logic to populate the Tache object associated with the Facturation
                // if your Facturation table has a foreign key referencing the Tache table
                int tacheId = RS.getInt("tache"); // Assuming there's a 'tache' foreign key column
                Tache tache =new CRUDTache().findbyid(tacheId); // Call a method to retrieve the Tache object based on ID
                f.setTache(tache);

                listeFacturation.add(f);
            }
            System.out.println("Facturation affichée avec succès");
        } catch (SQLException ex) {
            System.out.println("Erreur d'affichage des facturations");
        }
        return listeFacturation;
    }
}
