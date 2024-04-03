package tn.esprit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load the first FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SignUp.fxml"));
        Parent root = loader.load();
        Scene scene1 = new Scene(root);

        // Load the second FXML file
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/LogInUI.fxml"));
        Parent root2 = loader2.load();
        Scene scene2 = new Scene(root2);

        // Load the third FXML file
        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/ResetPassword.fxml"));
        Parent root3 = loader3.load();
        Scene scene3 = new Scene(root3);

        // Set initial scene
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Sign Up");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
