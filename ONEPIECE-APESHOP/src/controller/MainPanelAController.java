/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ramesh Godara
 */
public class MainPanelAController implements Initializable {

    @FXML
    private BorderPane borderPane;

    private List<Button> menus;

    @FXML
    private AreaChart<?, ?> chartPurchase;

    @FXML
    private AreaChart<?, ?> chartSale;

    @FXML
    private LineChart<?, ?> chartReceipt;
    public Utilisateur au=new Utilisateur();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void changeButtonBackground(ActionEvent e) {
        Iterator<Button> iteratorMenus = menus.iterator();

        while (iteratorMenus.hasNext()) {
            Button clickedButton = (Button) e.getSource();
            Button OtherButton = iteratorMenus.next();
            if (clickedButton == OtherButton) {
                clickedButton.setStyle("-fx-text-fill:#f0f0f0;-fx-background-color:#2b2a26;");
            } else {
                if (OtherButton != null) {
                    OtherButton.setStyle("-fx-text-fill:#f0f0f0;-fx-background-color:#404040;");
                }
            }
        }

    }

    @FXML
    private void clear() {
        borderPane.setCenter(null);
    }

    @FXML
    private void loadFXML(String fileName) {
        Parent parent;
        try {
            parent = FXMLLoader.load(getClass().getResource("/view/" + fileName + ".fxml"));
            borderPane.setCenter(parent);

        } catch (IOException ex) {
            Logger.getLogger(MainPanelAController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void close() throws IOException {

        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("/view/LoginView.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("User Login");
        stage.getIcons().add(new Image("/asset/icon.png"));
        stage.show();
    }

    @FXML
    private void loadPage01View(ActionEvent e) {
        loadFXML("Page01AView");
        changeButtonBackground(e);
    }

    @FXML
    private void loadPage02View(ActionEvent e) {
        loadFXML("Page02AView");
        changeButtonBackground(e);
    }

    @FXML
    private void loadPage03View(ActionEvent e) throws IOException {
        Stage stage =new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/Page03AView.fxml"));
        
                    Parent root =loader.load();
                    borderPane.setCenter(root);
                    //Parent root = FXMLLoader.load(getClass().getResource("/view/MainPanelView.fxml"));
                    Page03AController mainpanelController=loader.getController();
                    //System.out.println(u);
                    //mainpanelController.u=au;
                    //System.out.println(au);
                    mainpanelController.afficher();
                   
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("Admin Panel");
                    stage.getIcons().add(new Image("/asset/icon.png"));
                    stage.show();     
    }

    @FXML
    private void loadPage04View(ActionEvent e) throws IOException {
     Stage stage =new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/Page04AView.fxml"));
        
                    Parent root =loader.load();
                    borderPane.setCenter(root);
                    //Parent root = FXMLLoader.load(getClass().getResource("/view/MainPanelView.fxml"));
                    Page04AController mainpanelController=loader.getController();
                    //System.out.println(u);
                    mainpanelController.u=au;
                    //System.out.println(au);
                    mainpanelController.afficher();
                   
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("Admin Panel");
                    stage.getIcons().add(new Image("/asset/icon.png"));
                    stage.show();      
    }

    @FXML
    private void loadPage05View(ActionEvent e) {
        loadFXML("Page05AView");
        changeButtonBackground(e);
    }

    @FXML
    private void loadPage06View(ActionEvent e) {
        loadFXML("Page06AView");
        changeButtonBackground(e);
    }
    @FXML
    private void loadPage07View(ActionEvent e) throws IOException {
        Stage stage =new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/Page07AView.fxml"));
        
                    Parent root =loader.load();
                    borderPane.setCenter(root);
                    //Parent root = FXMLLoader.load(getClass().getResource("/view/MainPanelView.fxml"));
                    Page07AController mainpanelController=loader.getController();
                    //System.out.println(u);
                   // mainpanelController.u=au;
                    //System.out.println(au);
                    mainpanelController.afficher();
                   
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("Admin Panel");
                    stage.getIcons().add(new Image("/asset/icon.png"));
                    stage.show();    
    }
    @FXML
    private void loadPage08AView(ActionEvent e) throws IOException {
        Stage stage =new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/Page08AView.fxml"));
        
                    Parent root =loader.load();
                    borderPane.setCenter(root);
                    //Parent root = FXMLLoader.load(getClass().getResource("/view/MainPanelView.fxml"));
                    Page08AController mainpanelController=loader.getController();
                    //System.out.println(u);
                   // mainpanelController.u=au;
                    //System.out.println(au);
                    mainpanelController.afficher();
                   
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("Admin Panel");
                    stage.getIcons().add(new Image("/asset/icon.png"));
                    stage.show();    
    }
 @FXML
    private void loadHomeView(ActionEvent e) throws IOException {
       Stage stage =new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/HomeAView.fxml"));
        
                    Parent root =loader.load();
                    borderPane.setCenter(root);
                    //Parent root = FXMLLoader.load(getClass().getResource("/view/MainPanelView.fxml"));
                    HomeAController mainpanelController=loader.getController();
                    //System.out.println(u);
                    mainpanelController.u=au;
                    //System.out.println(au);
                    mainpanelController.test();
                   
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("Admin Panel");
                    stage.getIcons().add(new Image("/asset/icon.png"));
                    stage.show();    
    }
    
}
