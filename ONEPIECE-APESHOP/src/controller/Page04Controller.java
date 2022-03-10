/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Avis;
import entities.Commentaire;
import entities.Forum;
import entities.Utilisateur;
import helper.AlertHelper;
import java.net.URL;
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
import javafx.stage.Window;
import services.CommentaireCRUD;
import services.ForumCRUD;

/**
 *
 * @author Ramesh Godara
 */
public class Page04Controller implements Initializable {

    @FXML
    private TableView<Commentaire> tableview;
    @FXML
    private TableColumn<?, ?> commentaire;
    @FXML
    private Button btn_ajouter;
    @FXML
    private ChoiceBox<String> ch_categorie;
    @FXML
    private TextField tf_com;
    @FXML
    private Button btn_supprimer;
    
   public Commentaire u = new Commentaire();
   private CommentaireCRUD ps =new CommentaireCRUD();
   public Avis a=new Avis(); 
   public Forum f=new Forum(); 
   public int ID ;
    public Utilisateur uu=new Utilisateur();
    Window window;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ForumCRUD ca =new ForumCRUD();
        ch_categorie.getItems().addAll(ca.afficherForumN());
        ch_categorie.setValue("LES CONSOLES RARES!!"); 
        
    }

    @FXML
    private void afficherS(ActionEvent event) {
     String nomSujet=ch_categorie.getValue();
    ForumCRUD frd=new ForumCRUD();
    List <Forum> myList = frd.afficherForum();
    for (Forum f:myList){
    if(nomSujet.equals(f.getSujetForum())){
    ID=f.getIdForum();
  
    }
            }
    CommentaireCRUD prd=new CommentaireCRUD();
          List <Commentaire> myList1 = prd.afficherCommentairesu(ID);
          ObservableList list = FXCollections.observableArrayList(myList1);
          tableview.setItems(list);
          commentaire.setCellValueFactory(new PropertyValueFactory<>("contenuCommentaire"));
          
    }
    
    private void afficherS() {
     String nomSujet=ch_categorie.getValue();
    ForumCRUD frd=new ForumCRUD();
    List <Forum> myList = frd.afficherForum();
    for (Forum f:myList){
    if(nomSujet.equals(f.getSujetForum())){
    ID=f.getIdForum();
  
    }
            }
    CommentaireCRUD prd=new CommentaireCRUD();
          List <Commentaire> myList1 = prd.afficherCommentairesu(ID);
          ObservableList list = FXCollections.observableArrayList(myList1);
          tableview.setItems(list);
          commentaire.setCellValueFactory(new PropertyValueFactory<>("contenuCommentaire"));
          
    }

    @FXML
    private void supprimer(ActionEvent event) {
        Commentaire aa = tableview.getSelectionModel().getSelectedItem();
      if (uu.getNumeroUtilisateur()==aa.getNumeroUtilisateur()){
        tableview.getItems().remove(aa);
      ps.supprimercommentaire(aa.getIdCommentaire());
    AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "commentaire supprimé!.");
      }
      else{
      AlertHelper.showAlert(Alert.AlertType.ERROR, window, "ERROR",
                    "selectionner votre commentaire!.");
      }
    }

    @FXML
    private void ajouter(ActionEvent event) {
     afficherS();
        Commentaire a = new Commentaire();
        if (isValidated()){
        a.setContenuCommentaire(tf_com.getText());
        a.setIdForum(ID);
        a.setNumeroUtilisateur(uu.getNumeroUtilisateur());
       
        ps.ajouterCommentaire(a);
         AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "commentaire déposé!.");
            afficherS();
        }
    }

    void afficher() {
       CommentaireCRUD prd=new CommentaireCRUD();
          List <Commentaire> myList = prd.afficherCommentaires();
          ObservableList list = FXCollections.observableArrayList(myList);
          tableview.setItems(list);
          commentaire.setCellValueFactory(new PropertyValueFactory<>("contenuCommentaire"));
             
    }
     private boolean isValidated() {

        window = btn_ajouter.getScene().getWindow();
        if (tf_com.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "commentaire text field cannot be blank.");
            tf_com.requestFocus();
        } else if (tf_com.getText().length() < 5 || tf_com.getText().length() > 64) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "commentaire text field cannot be less than 5 and greator than 64 characters.");
            tf_com.requestFocus();
        
        } else {
            return true;
        }
        return false;
    }
}
