/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Avis;
import entities.Commande;
import entities.Facture;
import entities.Panier;
import entities.Produit;
import entities.Utilisateur;
import helper.AlertHelper;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;
import services.CommandeCRUD;
import services.FactureCRUD;
import services.ProduitCRUD;
import services.panierCRUD;

/**
 *
 * @author Ramesh Godara
 */
public class Page02Controller implements Initializable {
@FXML
    private TableView<Panier> tableview;
  
    @FXML
    private TableColumn<Produit, Date> date_ajout;
    @FXML
    private TableColumn<Produit, Integer> quant;
         Window window;
   @FXML
   private Button btn_commande;
   @FXML
   private Button btn_facture;
    @FXML
   private Label total;
    private float totale=0;
    public Utilisateur u= new Utilisateur() ;
    @FXML
    private Button btn_supprimer;
    @FXML
    private TableColumn<Produit, String> nom_prod;
    @FXML
    private Button btn_supprimer1;
    @FXML
    private Button btn_supprimer2;
    @FXML
    private TextField nomp;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    
          
    }
    @FXML
    public void commander (){
    Commande c = new Commande();
    CommandeCRUD crd = new CommandeCRUD();
    c.setDateCreation(new Date(System.currentTimeMillis()));
    c.setDateEnvoi(new Date(System.currentTimeMillis()+(long)864000 * 100));
    c.setNumeroUtilisateur(u.getNumeroUtilisateur());
    c.setStatut("en cours...");
    crd.ajouterCommande2(c);
    AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "commande passé avec succes!.");
    }

    public void setTotal(float  total) {
        this.total.setText("votre total est :"+Float.toString(total)+"DT"); 
    }
@FXML
    public void facture (){
    Facture c = new Facture();
    FactureCRUD crd = new FactureCRUD();
    c.setPrixLivraison(totale);
    c.setTypeLivraison("A Domicile");
    c.setNumeroUtilisateur(u.getNumeroUtilisateur());
    c.setNumeroRegionDestinataire(1);
   
    crd.ajouterFacture2(c);
    AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "Facture creée!.");
    }
    public void afficher (){
    try {
        totale=0;
        panierCRUD prd=new panierCRUD();
        ProduitCRUD urd=new ProduitCRUD();
        System.out.println(u);
        //List <Panier> myList = prd.afficherPanierU(u.getNumeroUtilisateur());
        List <Panier> myList = prd.afficherPanierU(u.getNumeroUtilisateur());
        List <Produit> myListp = urd.afficherProduits();
        
        for (Panier p:myList ){
        for (Produit a:myListp){
        if (p.getNumeroProduit()==a.getNumeroProduit())
        {
        totale+=a.getPrixUnitaire()*p.getQuantite();
        }
        }
        }
        setTotal(totale);
        ObservableList list = FXCollections.observableArrayList(myList);
        tableview.setItems(list);
        //ID.setCellValueFactory(new PropertyValueFactory<>("numeroPanier"));
        quant.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        //ID_produit.setCellValueFactory(new PropertyValueFactory<>("numeroProduit"));
        date_ajout.setCellValueFactory(new PropertyValueFactory<>("dateAjout"));
        nom_prod.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
        
    } catch (SQLException ex) {
        Logger.getLogger(Page02Controller.class.getName()).log(Level.SEVERE, null, ex);
    }}

    @FXML
    private void supprimer(ActionEvent event) {
        panierCRUD ps=new panierCRUD();
     Panier aa = tableview.getSelectionModel().getSelectedItem();
      tableview.getItems().remove(aa);
      ps.supprimerPanier(aa.getNumeroPanier());
    AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "articles supprimé!.");
    
    afficher();
    }

    @FXML
    private void tri(ActionEvent event) {
        panierCRUD prd=new panierCRUD();
        List <Panier> myList = prd.afficherPanierUt(u.getNumeroUtilisateur());
        ObservableList list = FXCollections.observableArrayList(myList);
        tableview.setItems(list);
        //ID.setCellValueFactory(new PropertyValueFactory<>("numeroPanier"));
        quant.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        //ID_produit.setCellValueFactory(new PropertyValueFactory<>("numeroProduit"));
        date_ajout.setCellValueFactory(new PropertyValueFactory<>("dateAjout"));
        nom_prod.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
    }

    @FXML
    private void recherche(ActionEvent event) {
       panierCRUD prd=new panierCRUD();
        List <Panier> myList = prd.afficherPanierUt(u.getNumeroUtilisateur(),nomp.getText());
        ObservableList list = FXCollections.observableArrayList(myList);
        tableview.setItems(list);
        //ID.setCellValueFactory(new PropertyValueFactory<>("numeroPanier"));
        quant.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        //ID_produit.setCellValueFactory(new PropertyValueFactory<>("numeroProduit"));
        date_ajout.setCellValueFactory(new PropertyValueFactory<>("dateAjout"));
        nom_prod.setCellValueFactory(new PropertyValueFactory<>("nomProduit")); 
    }
    
    
    
}
