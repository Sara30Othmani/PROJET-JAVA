package tn.esprit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private Scene mainScene;
    private Parent loginRoot;
    private Parent signUpRoot;
    private Parent resetPasswordRoot;

    @Override
    public void start(Stage primaryStage) throws IOException {

        /* Crée un serveur HTTP local sur le port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", exchange -> {
            // Lorsqu'une requête est reçue sur le chemin racine "/", renvoie l'URL complète
            String response = "URL de votre application : http://localhost:8080/";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });
        server.start();
        System.out.println("Serveur local démarré sur le port 8080");*/



        this.primaryStage = primaryStage;

        // Load the FXML files
        loginRoot = FXMLLoader.load(getClass().getResource("/LogInUI.fxml"));
        signUpRoot = FXMLLoader.load(getClass().getResource("/SignUp.fxml"));
        resetPasswordRoot = FXMLLoader.load(getClass().getResource("/ResetPassword.fxml"));

        // Create the main scene
        mainScene = new Scene(loginRoot);

        // Set the main scene
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Your Application Title");
        primaryStage.show();
    }

    // Method to switch to the sign up view
    public void switchToSignUp() {
        mainScene.setRoot(signUpRoot);
    }

    // Method to switch to the login view
    public void switchToLogIn() {
        mainScene.setRoot(loginRoot);
    }

    // Method to switch to the reset password view
    public void switchToResetPassword() {
        mainScene.setRoot(resetPasswordRoot);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
