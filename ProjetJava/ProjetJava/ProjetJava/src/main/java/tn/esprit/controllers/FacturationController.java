package tn.esprit.controllers;
import tn.esprit.models.Facturation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tn.esprit.services.CRUDFacturation;
import tn.esprit.services.CRUDTache;
import tn.esprit.Utils.MaConnexion;

import java.sql.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FacturationController {

    @FXML
    private TextField prixfield;
    @FXML
    private TableColumn<Facturation, Integer> tachecolumn;
    @FXML
    private TextField detailfield;
    @FXML
    private TableColumn<Facturation, Integer> prixcolumn;
    @FXML
    private Button deletebutton;
    @FXML
    private TableColumn<Facturation, Integer> idcolumn;
    @FXML
    private TableColumn<Facturation, String> detailcolumn;
    @FXML
    private Button ajoutbutton;
    @FXML
    private Button modifierbutton;
    @FXML
    private TableView table;
    @FXML
    private TextField tachefield;

    Connection conn= MaConnexion.getInstance().getCnx();
    public void initialize() throws IOException {

      table();

    }
    public void table() throws IOException {
        try { // Exception handling for database operations
            // Initialize table columns (only once)


            // Retrieve Taches from the database
            ObservableList<Facturation> taches1 = FXCollections.observableArrayList();
            String req = "SELECT * FROM `facturation`";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(req);
            while (rs.next()) {
                Facturation tache = new Facturation();
                tache.setId(rs.getInt("id"));
                tache.setDetails(rs.getString("details"));
                tache.setPrix(rs.getInt("prix"));
                taches1.add(tache);
            }

            // Set items for the TableView
            table.setItems(taches1);
            idcolumn.setCellValueFactory(f -> new SimpleIntegerProperty(f.getValue().getId()).asObject());
            detailcolumn.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getDetails()));
            prixcolumn.setCellValueFactory(f -> new SimpleIntegerProperty(f.getValue().getPrix()).asObject());



        } catch (SQLException e) {
            System.err.println("Error retrieving Taches from database: " + e.getMessage());
            // Handle the exception appropriately, e.g., display an error message to the user
        }

    }
    @FXML
    public void modifierclick(ActionEvent actionEvent) throws IOException{
        Facturation t = new Facturation();
        CRUDFacturation Ct = new CRUDFacturation();
        t = (Facturation) table.getSelectionModel().getSelectedItem();
        Integer prix= Integer.parseInt(prixfield.getText().toString());
        int p= prix.intValue();
        t.setPrix(p);
        t.setDetails(detailfield.getText());
        Ct.modifierFacturation(t);
        table();


    }

    @FXML
    public void deleteclick(ActionEvent actionEvent) throws IOException  {
        Facturation t = new Facturation();
        CRUDFacturation Ct = new CRUDFacturation();
        t= (Facturation) table.getSelectionModel().getSelectedItem();
        Ct.supprimerFacturation(t);
        table();
    }

    @FXML
    public void ajoutclick(ActionEvent actionEvent) throws IOException {
        String S =tachecolumn.getText();
        CRUDTache Ct = new CRUDTache();
        CRUDFacturation Ft= new CRUDFacturation();
        Integer prix= Integer.parseInt(prixfield.getText().toString());
        int p= prix.intValue();
        Integer id= Integer.parseInt(tachefield.getText().toString());
        int i= id.intValue();
        Facturation t = new Facturation(detailfield.getText(),prix);
       Ft.ajouterFacturation(t,i);
       table();

    }
}
