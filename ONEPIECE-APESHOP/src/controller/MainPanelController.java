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
public class MainPanelController implements Initializable {

    @FXML
    private BorderPane borderPane;

    private List<Button> menus;

    @FXML
    private AreaChart<?, ?> chartPurchase;

    @FXML
    private AreaChart<?, ?> chartSale;

    @FXML
    private LineChart<?, ?> chartReceipt;
private String username;
public Utilisateur au = new Utilisateur();
/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        test();
    }
public void test (){
    System.out.println("main"+au);
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
            Logger.getLogger(MainPanelController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void loadPage01View(ActionEvent e) throws IOException {
        Stage stage =new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/Page01View.fxml"));
        
                    Parent root =loader.load();
                    borderPane.setCenter(root);
                    //Parent root = FXMLLoader.load(getClass().getResource("/view/MainPanelView.fxml"));
                    Page01Controller mainpanelController=loader.getController();
                    //System.out.println(u);
                    mainpanelController.setU(au);
                   
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("Client Panel");
                    stage.getIcons().add(new Image("/asset/icon.png"));
                    stage.show();

    }

    @FXML
    private void loadPage02View(ActionEvent e) throws IOException {
       Stage stage =new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/Page02View.fxml"));
        
                    Parent root =loader.load();
                    borderPane.setCenter(root);
                    //Parent root = FXMLLoader.load(getClass().getResource("/view/MainPanelView.fxml"));
                    Page02Controller mainpanelController=loader.getController();
                    //System.out.println(u);
                    mainpanelController.u=au;
                   mainpanelController.afficher();
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("Client Panel");
                    stage.getIcons().add(new Image("/asset/icon.png"));
                    stage.show();
    }

    @FXML
    private void loadPage03View(ActionEvent e) throws IOException {
       Stage stage =new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/Page03View.fxml"));
        
                    Parent root =loader.load();
                    borderPane.setCenter(root);
                    //Parent root = FXMLLoader.load(getClass().getResource("/view/MainPanelView.fxml"));
                    Page03Controller mainpanelController=loader.getController();
                    //System.out.println(u);
                    mainpanelController.u=au;
                    mainpanelController.afficher();
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("Client Panel");
                    stage.getIcons().add(new Image("/asset/icon.png"));
                    stage.show();
    }

    @FXML
    private void loadPage04View(ActionEvent e) throws IOException {
         Stage stage =new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/Page04View.fxml"));
        
                    Parent root =loader.load();
                    borderPane.setCenter(root);
                    //Parent root = FXMLLoader.load(getClass().getResource("/view/MainPanelView.fxml"));
                    Page04Controller mainpanelController=loader.getController();
                    //System.out.println(u);
                    mainpanelController.uu=au;
                    mainpanelController.afficher();
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("Client Panel");
                    stage.getIcons().add(new Image("/asset/icon.png"));
                    stage.show();
    }

    @FXML
    private void loadPage05View(ActionEvent e) throws IOException {
        Stage stage =new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/Page05View.fxml"));
        
                    Parent root =loader.load();
                    borderPane.setCenter(root);
                    //Parent root = FXMLLoader.load(getClass().getResource("/view/MainPanelView.fxml"));
                    Page05Controller mainpanelController=loader.getController();
                    //System.out.println(u);
                    mainpanelController.u=au;
                    mainpanelController.afficher();
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("Client Panel");
                    stage.getIcons().add(new Image("/asset/icon.png"));
                    stage.show();
    }

    @FXML
    private void loadPage06View(ActionEvent e) {
        loadFXML("Page06View");
        changeButtonBackground(e);
    }

    @FXML
    private void loadPage07View(ActionEvent e) throws IOException {
        Stage stage =new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/Page07View.fxml"));
        
                    Parent root =loader.load();
                    borderPane.setCenter(root);
                    //Parent root = FXMLLoader.load(getClass().getResource("/view/MainPanelView.fxml"));
                    Page07Controller mainpanelController=loader.getController();
                    //System.out.println(u);
                    mainpanelController.u=au;
                    mainpanelController.afficher();
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("Client Panel");
                    stage.getIcons().add(new Image("/asset/icon.png"));
                    stage.show();
    }

    @FXML
    private void loadPage08View(ActionEvent e) {
        loadFXML("Page08View");
        changeButtonBackground(e);
    }

    @FXML
    private void loadPage09View(ActionEvent e) {
        loadFXML("Page09View");
        changeButtonBackground(e);
    }

    @FXML
    private void loadPage10View(ActionEvent e) {
        loadFXML("Page10View");
        changeButtonBackground(e);
    }

    @FXML
    private void loadHomeView(ActionEvent e) throws IOException {
        Stage stage =new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/HomeView.fxml"));
        
                    Parent root =loader.load();
                    borderPane.setCenter(root);
                    //Parent root = FXMLLoader.load(getClass().getResource("/view/MainPanelView.fxml"));
                    HomeController mainpanelController=loader.getController();
                    //System.out.println(u);
                    mainpanelController.u=au;
                    mainpanelController.test();
                   
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.setTitle("Client Panel");
                    stage.getIcons().add(new Image("/asset/icon.png"));
                    stage.show();
    }

    /*public void setUsername(String username) {
        this.username = username;
    }*/

    /*void setUsername(Utilisateur a) {
     au =new Utilisateur(a);
        
    }*/

}
