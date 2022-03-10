/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Avis;
import entities.Commande;
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
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;
import services.CommandeCRUD;
import services.utilisateurCRUD;

/**
 *
 * @author Ramesh Godara
 */
public class Page02AController implements Initializable {

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
         Window window;
         @FXML 
         private Button btn_annuler;
    @FXML
    private Button btn_annuler1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
CommandeCRUD prd=new CommandeCRUD();
          List <Commande> myList = prd.afficherCommandes();
          ObservableList list = FXCollections.observableArrayList(myList);
          tableview.setItems(list);
          numC.setCellValueFactory(new PropertyValueFactory<>("numeroCommande"));
          dateC.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
          dateE.setCellValueFactory(new PropertyValueFactory<>("dateEnvoi"));
          statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        
    }
    @FXML
     public void annuler()
     {
             int selectedIndex = tableview.getSelectionModel().getSelectedIndex();
    TablePosition idUser= tableview.getSelectionModel().getSelectedCells().get(0);
    int id =idUser.getRow();
    // Item here is the table view type:
     Commande item = tableview.getItems().get(id);
     CommandeCRUD urd =new CommandeCRUD();
     urd.supprimerCommande(item.getNumeroCommande());
    tableview.getItems().remove(selectedIndex);
     AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "commande  annulé!.");
      actualiser();
    }
     public void actualiser(){
     CommandeCRUD prd=new CommandeCRUD();
          List <Commande> myList = prd.afficherCommandes();
          ObservableList list = FXCollections.observableArrayList(myList);
          tableview.setItems(list);
          numC.setCellValueFactory(new PropertyValueFactory<>("numeroCommande"));
          dateC.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
          dateE.setCellValueFactory(new PropertyValueFactory<>("dateEnvoi"));
          statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        
     }

    @FXML
    private void change(ActionEvent event) {
        Commande aa = tableview.getSelectionModel().getSelectedItem();
        CommandeCRUD prd=new CommandeCRUD();
        if (aa.getStatut().equals("en cours...")){
            aa.setStatut("livrée...");
        }
        else {
        aa.setStatut("en cours...");
        }
        prd.modifierCommande(aa, aa.getNumeroCommande());
        actualiser();
    AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "Statut modifié!.");
    }
}
