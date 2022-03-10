/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Panier;
import entities.Produit;
import entities.Utilisateur;
import helper.AlertHelper;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import services.ProduitCRUD;
import services.panierCRUD;
import services.utilisateurCRUD;

/**
 *
 * @author Ramesh Godara
 */
public class Page01Controller implements Initializable {
       @FXML
    private Button btn_ajouter;
       @FXML
    private TextField number;   
    //table view
    @FXML
    private AnchorPane pane;
    @FXML
    private TableView<Produit> tableview;
  
    @FXML
    private TableColumn<Produit, String> nomP;
    @FXML
    private TableColumn<Produit, Integer> quant;
    @FXML
    private TableColumn<Produit, Float> prixU;
    @FXML
    private TableColumn<Produit, String> nomC;
    @FXML
    private TableColumn<Produit, Integer> ID;
         Window window;
         ProduitCRUD prd=new ProduitCRUD();
         private Utilisateur u;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            
         ProduitCRUD prd=new ProduitCRUD();
          List <Produit> myList = prd.afficherProduits();
          ObservableList list = FXCollections.observableArrayList(myList);
          tableview.setItems(list);
          nomP.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
          //quant.setCellValueFactory(new PropertyValueFactory<>("10"));
          prixU.setCellValueFactory(new PropertyValueFactory<>("prixUnitaire"));
          nomC.setCellValueFactory(new PropertyValueFactory<>("nomCategorie"));
          ID.setCellValueFactory(new PropertyValueFactory<>("numeroProduit"));
      } catch (SQLException ex) {
          Logger.getLogger(Page01AController.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }
        @FXML
    private void ajouter() throws SQLException  { 
    
    int selectedIndex = tableview.getSelectionModel().getSelectedIndex();
    TablePosition idUser= tableview.getSelectionModel().getSelectedCells().get(0);
    int id =idUser.getRow();
    // Item here is the table view type:
     Produit item = tableview.getItems().get(id);
     panierCRUD urd =new panierCRUD();
     Panier p=new Panier();
     if (this.isValidated()) {
     p.setNumeroProduit(item.getNumeroProduit());
     p.setQuantite(Integer.parseInt(number.getText()));
     p.setDateAjout(new Date(System.currentTimeMillis()));
         System.out.println(u.getNumeroUtilisateur());
     p.setNumeroUtilisateur(u.getNumeroUtilisateur());
     p.setNomProduit(item.getNomProduit());
     urd.ajouterPanier(p);
    //tableview.getItems().remove(selectedIndex);
     AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "added to cart!.");
     }

        }
    private boolean isValidated() {

        window = btn_ajouter.getScene().getWindow();
        if (number.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "quantite text field cannot be blank.");
            number.requestFocus();
            } else if (!number.getText().chars().allMatch( Character::isDigit ) ) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "quantite text field accepts digits only..");
            number.requestFocus();
        
        } else if (Integer.parseInt(number.getText()) < 0 || Integer.parseInt(number.getText()) >10 ) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "quantite text field cannot be less than 0 and greator than 10 characters.");
            number.requestFocus();
        } else {
            return true;
        }

        return false;
    }

    public void setU(Utilisateur u) {
        this.u = u;
    }
    
}
