package tn.esprit.controllers;

import tn.esprit.models.Tache;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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


public class HelloController {

    @FXML
    private TableColumn<Tache, String> statuscolumn;
    @FXML
    private TableColumn<Tache, String> titrecolumn;
    @FXML
    private TableColumn<Tache, Integer> idcolumn;
    @FXML
    private TableColumn<Tache, String> descriptioncolumn;
    @FXML
    private TableView<Tache> table;
    @FXML
    private TextField descriptionfield;
    @FXML
    private TextField statusfield;
    @FXML
    private TextField titrefield;
    @FXML
    private Button deletebutton;
    @FXML
    private Button ajoutbutton;
    @FXML
    private Button modifierbutton;

    @FXML
    protected void onHelloButtonClick() {

    }
    Connection conn= MaConnexion.getInstance().getCnx();

    public void initialize() throws IOException {
        table();

    }

    public void table() throws IOException {
        try { // Exception handling for database operations
            // Initialize table columns (only once)


            // Retrieve Taches from the database
            ObservableList<Tache> taches1 = FXCollections.observableArrayList();
            String req = "SELECT * FROM `tache`";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(req);
            while (rs.next()) {
                Tache tache = new Tache();
                tache.setId(rs.getInt("id"));
                tache.setTitre(rs.getString("titre"));
                tache.setDescription(rs.getString("description"));
                tache.setStatus(rs.getString("status"));
                taches1.add(tache);
            }

            // Set items for the TableView
            table.setItems(taches1);
            idcolumn.setCellValueFactory(f -> new SimpleIntegerProperty(f.getValue().getId()).asObject());
            descriptioncolumn.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getDescription()));
            statuscolumn.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getStatus()));
            titrecolumn.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getTitre()));



        } catch (SQLException e) {
            System.err.println("Error retrieving Taches from database: " + e.getMessage());
            // Handle the exception appropriately, e.g., display an error message to the user
        }

    }

    @FXML
    public void modifierclick(ActionEvent actionEvent) throws IOException{
        Tache t = new Tache();
        CRUDTache Ct = new CRUDTache();
        t= table.getSelectionModel().getSelectedItem();
        Ct.modifierTache(t,titrefield.getText(),descriptionfield.getText(),statusfield.getText());
        table();
    }

    @FXML
    public void deleteclick(ActionEvent actionEvent) throws IOException {
        Tache t = new Tache();
        CRUDTache Ct = new CRUDTache();
        t= table.getSelectionModel().getSelectedItem();
        Ct.supprimerTache(t);
        table();
    }

    @FXML
    public void ajoutclick(ActionEvent actionEvent) throws IOException {
        Tache t = new Tache(titrefield.getText(),descriptionfield.getText(), statusfield.getText());
        CRUDTache Ct = new CRUDTache();
        Ct.ajouterTache(t);
        table();
    }
}