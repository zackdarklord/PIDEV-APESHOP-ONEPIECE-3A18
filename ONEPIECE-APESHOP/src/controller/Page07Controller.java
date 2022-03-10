/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entities.Commande;
import entities.Facture;
import entities.Utilisateur;
import helper.AlertHelper;
import java.text.DecimalFormat;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;
import services.CommandeCRUD;
import services.FactureCRUD;
import test.Smsapi;

/**
 *
 * @author zakar
 */
public class Page07Controller {

    @FXML
    private TableView<Facture> tableview;
    @FXML
    private TableColumn<?, ?> numC;
    @FXML
    private TableColumn<?, ?> dateC;
    @FXML
    private TableColumn<?, ?> dateE;
    @FXML
    private Button btn_supprimer;
  Window window;
  public FactureCRUD ps=new FactureCRUD();
   public Utilisateur u =new Utilisateur();
    @FXML
    private Button btn_supprimer1;
    @FXML
    private void supprimer(ActionEvent event) {
    Facture aa = tableview.getSelectionModel().getSelectedItem();
      
        tableview.getItems().remove(aa);
        ps.supprimerFacture(aa.getNumeroFacture());
        AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "Facture supprimé!.");
        afficher();
    }
    public void afficher (){
          FactureCRUD prd=new FactureCRUD();
          List <Facture> myList = prd.afficherFacturesu(u.getNumeroUtilisateur());
          ObservableList list = FXCollections.observableArrayList(myList);
          tableview.setItems(list);
          numC.setCellValueFactory(new PropertyValueFactory<>("typeLivraison"));
          dateC.setCellValueFactory(new PropertyValueFactory<>("prixLivraison"));
          dateE.setCellValueFactory(new PropertyValueFactory<>("numeroRegionDestinataire"));
         

}

    @FXML
    private void SMS(ActionEvent event) {
        FactureCRUD prd=new FactureCRUD();
        List <Facture> myList = prd.afficherFacturesu(u.getNumeroUtilisateur());
         Facture aa = tableview.getSelectionModel().getSelectedItem();
        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(0);
        System.out.println(u.getNumTel());
        
        Smsapi.sendSMS("+216"+df.format(u.getNumTel()), "Le montant de votre facture est :"+aa.getPrixLivraison()+"DT\nAPESHOP");
    
    }
    
}
