/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;
import database.DbConnection;
import entities.Utilisateur;
import helper.AlertHelper;
import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
import javafx.stage.Stage;
import javafx.stage.Window;
import services.utilisateurCRUD;
import services.md5tool;
/**
 *
 * @author Ramesh Godara
 */
public class RegisterAdminController implements Initializable {

    private final Connection con;

    
    @FXML
    private TextField email;
  @FXML
    private TextField username;
  @FXML
    private TextField password;
  @FXML
    private TextField confirmPassword;
  @FXML
    private Button registerButton;

    Window window;

    utilisateurCRUD urd = new utilisateurCRUD();
    List<Utilisateur> myList = urd.afficherUser();
    
    @FXML
    private Button sendButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public RegisterAdminController() {
        DbConnection dbc = DbConnection.getDatabaseConnection();
        con = dbc.getConnection();
    }
 @FXML
    private void register() throws Exception {
        
        window = registerButton.getScene().getWindow();
        md5tool mt= new md5tool("qwrwrww More than 10", "utf-8");
        if (this.isValidated()) {
            Utilisateur u = new Utilisateur();
            u.setEmail(email.getText());
            u.setNomAdmin(username.getText());
            u.setMotDePasse(mt.encode(password.getText()));
            u.setDateInscription(new Date(System.currentTimeMillis()));
            u.setRole("admin");
            urd.ajouterUser(u);
            AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "registred!.");
        }
    }

    private boolean isAlreadyRegistered() {

        boolean usernameExist = false;

        for (Utilisateur u : myList) {

            if (username.getText().equals(u.getNomAdmin()) ) {
                usernameExist = true;
            }
        }

        return usernameExist;
    }

 private boolean isValidated() {

        window = registerButton.getScene().getWindow();
        if (username.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "username text field cannot be blank.");
            username.requestFocus();
        } else if (username.getText().length() < 2 || username.getText().length() > 25) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "username text field cannot be less than 2 and greator than 25 characters.");
            username.requestFocus();
        } else if (email.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Email text field cannot be blank.");
            email.requestFocus();
        } else if (email.getText().length() < 5 || email.getText().length() > 45) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Email text field cannot be less than 5 and greator than 45 characters.");
            email.requestFocus();
             } else if (!email.getText().matches("(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)*\\@(?:\\w|[\\-_])+(?:\\.(?:\\w|[\\-_])+)+" )) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Email form: _@_._ ");
            email.requestFocus();
        }  else if (password.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Password text field cannot be blank.");
            password.requestFocus();
        } else if (password.getText().length() < 5 || password.getText().length() > 25) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Password text field cannot be less than 5 and greator than 25 characters.");
            password.requestFocus();
        } else if (confirmPassword.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Confirm password text field cannot be blank.");
            confirmPassword.requestFocus();
        } else if (confirmPassword.getText().length() < 5 || password.getText().length() > 25) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Confirm password text field cannot be less than 5 and greator than 25 characters.");
            confirmPassword.requestFocus();
        } else if (!password.getText().equals(confirmPassword.getText())) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Password and confirm password text fields does not match.");
            password.requestFocus();
        } else if (this.isAlreadyRegistered()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "The username is already taken by someone else.");
            username.requestFocus();
        } else {
            return true;
        }

        return false;
    }

    private boolean clearForm() {
       
        email.clear();
        username.clear();
        password.clear();
        confirmPassword.clear();
       
        return true;
    }

    @FXML
    private void showLoginStage() throws IOException {
        Stage stage = (Stage) registerButton.getScene().getWindow();
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("User Login");
        stage.getIcons().add(new Image("/asset/icon.png"));
        stage.show();
    }

    @FXML
    private void send(ActionEvent event) {
    }
       public static String doHashing(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(password.getBytes());

            byte[] resultByteArray = messageDigest.digest();

            StringBuilder sb = new StringBuilder();

            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }
            System.out.println(sb.toString());
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }
}
