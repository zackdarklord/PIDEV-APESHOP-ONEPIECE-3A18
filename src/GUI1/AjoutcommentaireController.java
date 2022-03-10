/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI1;


import entities.Commentaire;
import services.CommentaireCRUD;
import services.forumCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AjoutcommentaireController implements Initializable {

    @FXML
    private TextField contenuCommentaire;
    @FXML
    private TableView tableview3;
    @FXML
    private TableView tableview4;
    @FXML
    private TableColumn  contenuCommentaire2;
    @FXML 
    private TableColumn  sujetForum2;

    CommentaireCRUD ps = new CommentaireCRUD();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        forumCRUD sp = new forumCRUD();
        CommentaireCRUD cp = new CommentaireCRUD();
        List forums = sp.afficherForumu();
        List commentaires = cp.afficherCommentairesu();
        ObservableList list3 = FXCollections.observableArrayList(commentaires);
        ObservableList list4 = FXCollections.observableArrayList(forums);
        tableview3.setItems(list4);
        tableview4.setItems(list3);
        contenuCommentaire2.setCellValueFactory(new PropertyValueFactory<>("contenuCommentaire"));
        sujetForum2.setCellValueFactory(new PropertyValueFactory<>("sujetForum"));
 
    }    

    @FXML
    private void btnajouterclicked(ActionEvent event) {
    
    Commentaire c = new Commentaire();
        c.setContenuCommentaire(contenuCommentaire.getText());
        ps.ajouterCommentaire(c);
    
}
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void switchtogestion(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("../GUI1/gestion forum.fxml"));
       stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();     
   }    
   
    
    
    
}