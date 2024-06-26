package tn.esprit.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MaConnexion {

    private final String url = "jdbc:mysql://localhost:3306/java";
    private final String login = "root";
    private final String pwd = "root";

    private Connection cnx;

    private static MaConnexion instance;

    public MaConnexion(){
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("la connexion a été établie !");
        } catch (SQLException e) {
            System.err.println("Erreur de connexion !");
            System.out.println(e.getMessage());
        }
    }

    public static MaConnexion getInstance(){
        if (instance == null) instance = new MaConnexion();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }

}