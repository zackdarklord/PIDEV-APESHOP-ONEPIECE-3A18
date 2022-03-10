/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import entities.Utilisateur;
import helper.AlertHelper;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.md5tool;
import services.utilisateurCRUD;

/**
 * FXML Controller class
 *
 * @author zakar
 */
public class ForgotViewController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private Button sendButton;
     Window window;
    utilisateurCRUD urd =new utilisateurCRUD();
    List<Utilisateur>MyList =urd.afficherUser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void send(ActionEvent event) throws Exception {
        if (isValidated()){
            System.out.println("sucess");
        }
    }
private boolean isValidated() throws Exception {

        window = sendButton.getScene().getWindow();
       String mail = email.getText();
       for (Utilisateur u :MyList){
           if(mail.equals(u.getEmail())){
           AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "Sucess",
                    "valid email ,check your inbox!.");
           ////////////////////////////////////
        final String username = "ape.shop123@gmail.com";
        final String password = "Ape123shop";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            md5tool mt=new md5tool ("qwrwrww More than 10","utf-8");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mail)
            );
            message.setSubject("récuperation mot de passe");
            message.setText("votre mot de passe:"+" "+mt.decode(u.getMotDePasse()));

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
           ////////////////////////////////////         
           return true;
           }  
           
           }
       
       AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "invalid email.");
        return false;
    }
    
    @FXML
    private void showLoginStage(MouseEvent event) throws IOException {
        Stage stage = (Stage) sendButton.getScene().getWindow();
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("User Registration");
        stage.getIcons().add(new Image("/asset/icon.png"));
        stage.show();
    }
    
}
