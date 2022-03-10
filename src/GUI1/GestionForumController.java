/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI1;


import entities.Commentaire;
import entities.Forum;
import services.CommentaireCRUD;
import services.forumCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author User
 */
public class GestionForumController implements Initializable {

    @FXML
    private TextField sujetForum;
    @FXML
    private TextField idForum;
    @FXML
    private TextField numeroUtilisateur;
    @FXML
    public TextField idCommentaire;
    @FXML
    private TableView tableview;
    @FXML
    
    private TableView tableview2;
    @FXML
    private TableColumn  numeroUtilisateur2;
    @FXML
    private TableColumn  contenuCommentaire2;
    @FXML
    private TableColumn  idForum3;
    @FXML 
    private TableColumn  sujetForum2;
    @FXML 
    private TableColumn  idForum2;
    @FXML 
    private TableColumn  idCommentaire2;
    
    forumCRUD ps = new forumCRUD();
    CommentaireCRUD cs = new CommentaireCRUD();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        forumCRUD sp = new forumCRUD();
        CommentaireCRUD cp = new CommentaireCRUD();
        List forums = sp.afficherForum();
        List commentaires = cp.afficherCommentaires();
        ObservableList list1 = FXCollections.observableArrayList(commentaires);
        ObservableList list = FXCollections.observableArrayList(forums);
        tableview.setItems(list1);
        
        tableview2.setItems(list);
        contenuCommentaire2.setCellValueFactory(new PropertyValueFactory<>("contenuCommentaire"));
        sujetForum2.setCellValueFactory(new PropertyValueFactory<>("sujetForum"));
        idForum2.setCellValueFactory(new PropertyValueFactory<>("idForum"));
        
        idCommentaire2.setCellValueFactory(new PropertyValueFactory<>("idCommentaire"));
        
        
    }
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void switchtoajout(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("../GUI1/ajoutcommentaire.fxml"));
       stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
       
   }
   @FXML
    private void btnajouterfclicked(ActionEvent event) {
    
    Forum f = new Forum();
        f.setSujetForum(sujetForum.getText());
        ps.ajouterForum(f);
    
}
   @FXML
    private void btnmodifierclicked(ActionEvent event) {
    
        Forum f = new Forum();
        f.setSujetForum(sujetForum.getText());
        f.setIdForum(Integer.parseInt(idForum.getText()));
        ps.modiferForum(f);
    
}
    @FXML
    private void btnsuppclicked(ActionEvent event) {
    
        Forum f = new Forum();
        f.setSujetForum(sujetForum.getText());
        ps.supprimerForum(f);
    
}
    
  @FXML
    private void btnsuppcclicked(ActionEvent event) {
    
        Commentaire c = new Commentaire();
        c.setIdCommentaire(Integer.parseInt(idCommentaire.getText()));
        cs.supprimercommentaire(c);
      
}
 
    
    
     
}

