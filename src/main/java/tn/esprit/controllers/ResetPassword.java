package tn.esprit.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class ResetPassword {
    @FXML
    private TextField EmailReset;

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 587; // Port pour TLS/STARTTLS
    private static final String USERNAME = "book.cheerleaders3@gmail.com";
    private static final String PASSWORD = "rgew owdq jetg flqu";

    private static Properties getMailProperties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", SMTP_HOST);
        properties.put("mail.smtp.port", SMTP_PORT);
        return properties;
    }

    @FXML
    public void initialize() {
        if (EmailReset != null) {
            System.out.println("TFEmailReset is not null");
        } else {
            System.out.println("TFEmailReset is null");
        }
    }

    public void Reset(ActionEvent event) {
        if (EmailReset != null) {
            String recipientEmail = EmailReset.getText();

            // Générer un nouveau mot de passe aléatoire ici
            String newPass = generateRandomPassword();

            // Envoyer l'e-mail avec le nom d'utilisateur et le mot de passe Gmail
            sendEmail(USERNAME, PASSWORD, recipientEmail, newPass);
        } else {
            System.out.println("TFEMailReset n'a pas été initialisé correctement.");
        }
    }


    private String generateRandomPassword() {
        return "NouveauMotDePasse123";
    }

    private void sendEmail(String username, String password, String recipientEmail, String newPass) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Réinitialisation de mot de passe");
            message.setText("Votre nouveau mot de passe est : " + newPass);

            Transport.send(message);
            System.out.println("E-mail envoyé avec succès !");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }



    public void RedirectLogIn(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LogInUI.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
