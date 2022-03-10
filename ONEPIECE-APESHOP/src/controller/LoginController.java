/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import services.md5tool;
import database.DbConnection;
import entities.Utilisateur;
import helper.AlertHelper;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
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
import main.MainPanel;
import services.utilisateurCRUD;

/**
 *
 * @author Ramesh Godara
 */
public class LoginController implements Initializable {

    private final Connection con;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button loginButton;
     

    Window window;
    utilisateurCRUD urd =new utilisateurCRUD();
    List<Utilisateur>MyList =urd.afficherUser();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public LoginController() {
        DbConnection dbc = DbConnection.getDatabaseConnection();
        con = dbc.getConnection();
    }

    @FXML
    private void login() throws Exception {
md5tool mt =new md5tool("qwrwrww More than 10","utf-8");
        if (this.isValidated()) {
           
String nom=username.getText();
String pass=mt.encode(password.getText());
boolean verif =false;
             
           for (Utilisateur u: MyList){
              
                if (nom.equals(u.getNomClient()) && pass.equals(u.getMotDePasse()) && u.getRole().equals("client")) {
                   
                   
                    verif =true;
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    stage.close();
                    
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/MainPanelView.fxml"));
                    Parent root =loader.load();
                    //Parent root = FXMLLoader.load(getClass().getResource("/view/MainPanelView.fxml"));
                    MainPanelController mainpanelController=loader.getController();
                    //System.out.println(u);
                    mainpanelController.au=u;
                   
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("Client Panel");
                    stage.getIcons().add(new Image("/asset/icon.png"));
                    stage.show();

                } 
                if (nom.equals(u.getNomAdmin()) && pass.equals(u.getMotDePasse()) && u.getRole().equals("admin")) {
                    
                    verif =true;
                    Stage stage = (Stage) loginButton.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/MainPanelViewA.fxml"));
                    Parent root =loader.load();
                    //Parent root = FXMLLoader.load(getClass().getResource("/view/MainPanelView.fxml"));
                    MainPanelAController mainpanelController=loader.getController();
                    //System.out.println(u);
                    mainpanelController.au=u;
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("admin Panel");
                    stage.getIcons().add(new Image("/asset/icon.png"));
                    stage.show();

                } 
           } 
             if (verif ==false){
                 
                    AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                            "Invalid username and password.");
                       username.requestFocus();
             
             }  
            
            }
        }
    

    private boolean isValidated() {

        window = loginButton.getScene().getWindow();
        if (username.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Username text field cannot be blank.");
            username.requestFocus();
        } else if (username.getText().length() < 5 || username.getText().length() > 25) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Username text field cannot be less than 5 and greator than 25 characters.");
            username.requestFocus();
        } else if (password.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Password text field cannot be blank.");
            password.requestFocus();
        } else if (password.getText().length() < 5 || password.getText().length() > 25) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Password text field cannot be less than 5 and greator than 25 characters.");
            password.requestFocus();
        } else {
            return true;
        }
        return false;
    }

    @FXML
    private void showRegisterStage() throws IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("/view/RegisterView.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("User Registration");
        stage.getIcons().add(new Image("/asset/icon.png"));
        stage.show();
    }
   @FXML
    private void showForgotStage() throws IOException {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("/view/ForgotView.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Send password");
        stage.getIcons().add(new Image("/asset/icon.png"));
        stage.show();
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
