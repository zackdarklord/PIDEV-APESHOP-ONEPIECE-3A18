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
import static java.awt.SystemColor.window;
import java.io.IOException;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import services.AvisCRUD;
import services.CategorieACRUD;
import services.CommandeCRUD;

/**
 *
 * @author Ramesh Godara
 */
public class Page05Controller implements Initializable {

    @FXML
    private TableView<Avis> tableview;
    @FXML
    private TableColumn<?, ?> categorie;
    @FXML
    private TableColumn<?, ?> avis;
    @FXML
    private Button btn_ajouter;
    @FXML
    private ChoiceBox<String> ch_categorie;
    @FXML
    private TextField tf_avis;
    @FXML
    private Button btn_supprimer;
    @FXML
    private Button btn_modifier;
   public Utilisateur u = new Utilisateur();
   private AvisCRUD ps =new AvisCRUD();
   public Avis a=new Avis(); 
    Window window;
    @FXML
    private Button btn_modifier1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        CategorieACRUD ca =new CategorieACRUD();
        ch_categorie.getItems().addAll(ca.afficherCategorieANom());
        ch_categorie.setValue("proposition");   
    }
    @FXML
    private void ajouter(ActionEvent event) {
        Avis a = new Avis();
        if (isValidated()){
        a.setContenuAvis(tf_avis.getText());
        a.setNomCategorie((String) ch_categorie.getValue());
        a.setNumeroUtilisateur(u.getNumeroUtilisateur());
       
        ps.ajouterAvis2(a);
         AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "Avis déposé!.");
        afficher();
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
       Avis aa = tableview.getSelectionModel().getSelectedItem();
      tableview.getItems().remove(aa);
      ps.supprimerAvis(aa.getIdAvis());
    AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "Avis supprimé!.");
    }
@FXML
    public void modifier (ActionEvent event) throws IOException {
      Avis aax = tableview.getSelectionModel().getSelectedItem();
      //table_avis.getItems();
      System.out.println(aax);
        tf_avis.setText(aax.getContenuAvis());
        ch_categorie.setValue(aax.getNomCategorie());
        
      a=aax;
     
    
    }
    public void afficher() {
        AvisCRUD prd=new AvisCRUD();
          List <Avis> myList = prd.afficherAvisU(u.getNumeroUtilisateur());
          ObservableList list = FXCollections.observableArrayList(myList);
          tableview.setItems(list);
          categorie.setCellValueFactory(new PropertyValueFactory<>("nomCategorie"));
          avis.setCellValueFactory(new PropertyValueFactory<>("contenuAvis"));
         }

    @FXML
    private void modifier2(ActionEvent event) throws IOException {
        
        a.setNomCategorie((String) ch_categorie.getValue());
        a.setContenuAvis((tf_avis.getText()));
        System.out.println(a);
        ps.modifierAvis(a, a.getIdAvis());
        afficher();
        AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "Avis modifié!.");
    }
    private boolean isValidated() {

        window = btn_ajouter.getScene().getWindow();
        if (tf_avis.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "avis text field cannot be blank.");
            tf_avis.requestFocus();
        } else if (tf_avis.getText().length() < 5 || tf_avis.getText().length() > 64) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "avis text field cannot be less than 5 and greator than 64 characters.");
            tf_avis.requestFocus();
        
        } else {
            return true;
        }
        return false;
    }
    }

