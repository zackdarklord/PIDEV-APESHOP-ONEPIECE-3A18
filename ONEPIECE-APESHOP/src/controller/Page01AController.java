/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Produit;
import entities.Utilisateur;
import helper.AlertHelper;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.ProduitCRUD;
import services.utilisateurCRUD;

/**
 *
 * @author Ramesh Godara
 */

public class Page01AController implements Initializable  {
    @FXML
    private TextField nomProduit;
    @FXML
    private TextField Quantite;
    @FXML
    private TextField prixUnitaire;
    @FXML
    private TextField nomCategorie;
    @FXML
    private Button btn_ajouter;
    @FXML
    private TableView<Produit> tableview;
    @FXML
    private TextField IDproduitU;
    @FXML
    private TextField nomProduitU;
    @FXML
    private TextField QuantiteU;
    @FXML
    private TextField prixUnitaireU;
    @FXML
    private TextField nomCategorieU;
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
    @FXML
    private Button btn_supprimer;
    @FXML
    private Button btn_modifier;
    @FXML
    private Button btn_supprimer1;
 
         
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      try {
          ProduitCRUD prd=new ProduitCRUD();
          List <Produit> myList = prd.afficherProduits();
          ObservableList list = FXCollections.observableArrayList(myList);
          tableview.setItems(list);
          nomP.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
          quant.setCellValueFactory(new PropertyValueFactory<>("quantite"));
          prixU.setCellValueFactory(new PropertyValueFactory<>("prixUnitaire"));
          nomC.setCellValueFactory(new PropertyValueFactory<>("nomCategorie"));
          ID.setCellValueFactory(new PropertyValueFactory<>("numeroProduit"));
      } catch (SQLException ex) {
          Logger.getLogger(Page01AController.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }
    @FXML
    private void ajouter() throws SQLException  { 
   Produit p = new Produit();
   window = btn_ajouter.getScene().getWindow();
        if (this.isValidated()) {
            p.setNomProduit(nomProduit.getText());
            p.setQuantite(Integer.parseInt(Quantite.getText()));
            p.setPrixUnitaire(Float.valueOf(prixUnitaire.getText()));
            p.setNomCategorie(nomCategorie.getText());
            prd.ajouterProduit2(p);
             AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "registred!.");
             boolean test = clearForm();
             actualiser();

        }
    }
    @FXML
    private void modifier() throws SQLException { 
    Produit p = new Produit();
   window = btn_ajouter.getScene().getWindow();
        if (this.isValidated2()) {
            p.setNomProduit(IDproduitU.getText());
            p.setNomProduit(nomProduitU.getText());
            p.setQuantite(Integer.parseInt(QuantiteU.getText()));
            p.setPrixUnitaire(Float.valueOf(prixUnitaireU.getText()));
            p.setNomCategorie(nomCategorieU.getText());
            prd.modifierProduit(p,Integer.parseInt(IDproduitU.getText()));
            
             AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "Updated!.");
             boolean test = clearForm2();
             actualiser();

        }}
    
    private void actualiser() { 
     try {
          ProduitCRUD prd=new ProduitCRUD();
          List <Produit> myList = prd.afficherProduits();
          ObservableList list = FXCollections.observableArrayList(myList);
          tableview.setItems(list);
          nomP.setCellValueFactory(new PropertyValueFactory<>("nomProduit"));
          quant.setCellValueFactory(new PropertyValueFactory<>("quantite"));
          prixU.setCellValueFactory(new PropertyValueFactory<>("prixUnitaire"));
          nomC.setCellValueFactory(new PropertyValueFactory<>("nomCategorie"));
          ID.setCellValueFactory(new PropertyValueFactory<>("numeroProduit"));
          AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "refreshed!.");
      } catch (SQLException ex) {
          Logger.getLogger(Page01AController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    @FXML
    private void supprimer() throws Exception{ 
    int selectedIndex = tableview.getSelectionModel().getSelectedIndex();
    TablePosition idUser= tableview.getSelectionModel().getSelectedCells().get(0);
    int id =idUser.getRow();
    // Item here is the table view type:
     Produit item = tableview.getItems().get(id);
     ProduitCRUD urd =new ProduitCRUD();
     urd.supprimerProduit(item.getNumeroProduit());
    tableview.getItems().remove(selectedIndex);
     AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "produit supprimé!.");
     actualiser();
    }
    private boolean isValidated() throws SQLException {

        window = btn_ajouter.getScene().getWindow();
        if (nomProduit.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "nom produit text field cannot be blank.");
            nomProduit.requestFocus();
        } else if (nomProduit.getText().length() < 2 || nomProduit.getText().length() > 25) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "nom produit text field cannot be less than 2 and greator than 25 characters.");
            nomProduit.requestFocus();
        } else if (Quantite.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "quantite text field cannot be blank.");
            Quantite.requestFocus();
        } else if (!Quantite.getText().chars().allMatch( Character::isDigit )) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "quantite text field accepts digits only.");
            Quantite.requestFocus();
             
        }  else if (prixUnitaire.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Prix Unitaire text field cannot be blank.");
            prixUnitaire.requestFocus();
        } else if (!prixUnitaire.getText().matches("[-+]?[0-9]*\\.?[0-9]+")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "quantite text field accepts digits only.");
            prixUnitaire.requestFocus();
        } else if (nomCategorie.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "nom Categorie  text field cannot be blank.");
            nomCategorie.requestFocus();
              } else if (nomCategorie.getText().length() < 2 || nomCategorie.getText().length() > 25) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "nom categorie text field cannot be less than 2 and greator than 25 characters.");
            nomCategorie.requestFocus();
            } else if (!(nomCategorie.getText().equals("console")||nomCategorie.getText().equals("jeux video")||nomCategorie.getText().equals("accessoire"))) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "nom Categorie  console or jeux video or accessoire.");
            nomCategorie.requestFocus();
        
        } else if (this.isAlreadyRegistered()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                        "This product is already added.");
            nomProduit.requestFocus();
        } else {
            return true;
        }

        return false;
    }
    private boolean isAlreadyRegistered() throws SQLException {

        boolean productExist = false;
        List<Produit> myList = prd.afficherProduits();
        for (Produit p : myList) {

            if (nomProduit.getText().equals(p.getNomProduit())) {
                productExist = true;
            }
        }

        return productExist;
    }
     private boolean clearForm() {
        
        nomProduit.clear();
        Quantite.clear();
        prixUnitaire.clear();
        nomCategorie.clear();
        
        
        return true;
    }
         private boolean clearForm2() {
        IDproduitU.clear();
        nomProduitU.clear();
        QuantiteU.clear();
        prixUnitaireU.clear();
        nomCategorieU.clear();
        
        
        return true;
    }
     private boolean isValidated2() throws SQLException {

        window = btn_ajouter.getScene().getWindow();
        if (IDproduitU.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "ID produit text field cannot be blank.");
            IDproduitU.requestFocus();
        } else if (!IDproduitU.getText().chars().allMatch( Character::isDigit )) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "ID produit text field accepts digits only.");
            IDproduitU.requestFocus();
        }
        else if (nomProduitU.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "nom produit text field cannot be blank.");
            nomProduitU.requestFocus();
        } else if (nomProduitU.getText().length() < 2 || nomProduitU.getText().length() > 25) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "nom produit text field cannot be less than 2 and greator than 25 characters.");
            nomProduitU.requestFocus();
        } else if (QuantiteU.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "quantite text field cannot be blank.");
            QuantiteU.requestFocus();
        } else if (!QuantiteU.getText().chars().allMatch( Character::isDigit )) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "quantite text field accepts digits only.");
            QuantiteU.requestFocus();
             
        }  else if (prixUnitaireU.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Prix Unitaire text field cannot be blank.");
            prixUnitaireU.requestFocus();
        } else if (!prixUnitaireU.getText().matches("[-+]?[0-9]*\\.?[0-9]+")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "quantite text field accepts digits only.");
            prixUnitaireU.requestFocus();
        } else if (nomCategorieU.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "nom Categorie  text field cannot be blank.");
            nomCategorieU.requestFocus();
              } else if (nomCategorieU.getText().length() < 2 || nomCategorieU.getText().length() > 25) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "nom categorie text field cannot be less than 2 and greator than 25 characters.");
            nomCategorieU.requestFocus();
            } else if (!(nomCategorieU.getText().equals("console")||nomCategorieU.getText().equals("jeux video")||nomCategorieU.getText().equals("accessoire"))) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "nom Categorie  console or jeux video or accessoire.");
            nomCategorieU.requestFocus();
        
        } else if (this.isAlreadyRegistered()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                        "This product is already added.");
            nomProduitU.requestFocus();
        } else {
            return true;
        }

        return false;
    }

    @FXML
    private void notifier(ActionEvent event) throws SQLException {
        utilisateurCRUD urd =new utilisateurCRUD();
        List<Utilisateur>MyList =urd.afficherUser();
        List<Produit> myListp = prd.afficherProduits();
     for (Utilisateur u :MyList){
           
           
           ////////////////////////////////////
        final String username = "ape.shop123@gmail.com";
        final String password = "Ape123shop";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Produit p;
            p = myListp.get(myListp.size()-1);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(u.getEmail())
            );
            message.setSubject("Nouveau Produit");
            
            message.setText("nom Produit:"+p.getNomProduit()+" à "+p.getPrixUnitaire()+" DT seulement");

            Transport.send(message);

            System.out.println("Done");
            AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "Error",
                        "Emails sent!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    }
}
   
