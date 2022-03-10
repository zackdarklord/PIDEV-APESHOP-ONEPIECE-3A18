/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Commande;
import entities.Commentaire;
import entities.Panier;
import entities.Produit;
import entities.Utilisateur;
import helper.AlertHelper;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;
import services.CommandeCRUD;
import services.panierCRUD;
 
/**
 *
 * @author Ramesh Godara
 */
public class Page03Controller implements Initializable {

    @FXML
    private TableView<Commande> tableview;
  
    @FXML
    private TableColumn<Commande, Integer> numC;
    @FXML
    private TableColumn<Commande, Date> dateC;
    @FXML
    private TableColumn<Commande, Date> dateE;
    @FXML
    private TableColumn<Commande, String> statut;
     public Utilisateur u= new Utilisateur() ;
         Window window;
    @FXML
    private Button btn_supprimer;
     CommandeCRUD ps=new CommandeCRUD();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    

        
    }
   public void afficher (){
   CommandeCRUD prd=new CommandeCRUD();
          List <Commande> myList = prd.afficherCommandesUnique(u.getNumeroUtilisateur());
          ObservableList list = FXCollections.observableArrayList(myList);
          tableview.setItems(list);
          numC.setCellValueFactory(new PropertyValueFactory<>("numeroCommande"));
          dateC.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
          dateE.setCellValueFactory(new PropertyValueFactory<>("dateEnvoi"));
          statut.setCellValueFactory(new PropertyValueFactory<>("statut"));}

    @FXML
    private void supprimer(ActionEvent event) {
    Commande aa = tableview.getSelectionModel().getSelectedItem();
      
        tableview.getItems().remove(aa);
        ps.supprimerCommande(aa.getNumeroCommande());
        AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "Commande annulé!.");
      
     
      }
    }
    

