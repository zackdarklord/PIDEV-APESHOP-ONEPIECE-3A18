/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.AvisCRUD;
import entities.Avis;
/**
 * FXML Controller class
 *
 * 
 */
  public class ListAvisController implements Initializable {
    @FXML
    private AnchorPane pane;
    @FXML
    private TableView<Avis> table_avis;
    @FXML
    private TableColumn<Avis, String> col_id;
    @FXML
    private TableColumn<Avis, String> col_avis;
    @FXML
    private TableColumn<Avis, String> col_categorie;
    @FXML
    private TableColumn<Avis, String> col_numUtilisateur;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
      
     AvisCRUD sp = new AvisCRUD();
        List listAvis = sp.afficherAvis();
        ObservableList<Avis> ListAvis = FXCollections.observableArrayList();            
    
    
    /**
     * Initializes the controller class.
     */
    @Override                                                               
              
        public void initialize(URL location, ResourceBundle resources) {
        AvisCRUD sp = new AvisCRUD();
        List listAvis = sp.afficherAvis();
        ObservableList list = FXCollections.observableArrayList(listAvis);
        table_avis.setItems(list);
        
        //col_id.setCellValueFactory(new PropertyValueFactory<>("idAvis"));
        col_avis.setCellValueFactory(new PropertyValueFactory<>("contenuAvis"));
        col_categorie.setCellValueFactory(new PropertyValueFactory<>("nomCategorie"));
        col_numUtilisateur.setCellValueFactory(new PropertyValueFactory<>("numeroUtilisateur"));
        
        
        }
   

    
    
   
    public void Ajouter (ActionEvent event) throws IOException {
     root = FXMLLoader.load(getClass().getResource("AjoutAvis.fxml"));
     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
     scene = new Scene(root);
     stage.setScene(scene);
     stage.show();
    
    }
      
   public void Supprimer (ActionEvent event){
       
      Avis aa = table_avis.getSelectionModel().getSelectedItem();
      table_avis.getItems().remove(aa);
      sp.supprimerAvis(aa.getIdAvis());
      
               
       
   }
    
  public void Modifier (ActionEvent event) throws IOException {
      Avis aax = table_avis.getSelectionModel().getSelectedItem();
      //table_avis.getItems();
      
     FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifAvis.fxml"));
     root = loader.load();
      ModifAvisController modifAvisController = loader.getController();
      modifAvisController.ax=aax;    
      modifAvisController.Test(aax);
     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
     scene = new Scene(root);
     stage.setScene(scene);
     
     stage.show();
     
    
    }
 /* private void Modifier (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifAvis.fxml"));
            root = loader.load();
            AjoutAvisController controller = loader.getController();
            
             Avis aa = table_avis.getSelectionModel().getSelectedItem();
             table_avis.getItems().remove(aa);
             controller.setContenuAvis(col_id.getText());
            //Personne.user = ;
            //Personne.user.get
             col_id.getScene().setRoot(root);  
        } catch (IOException ex) {
            Logger.getLogger(ListAvisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
  
  
 /*public void start(Stage stage) {
  try {
    Parent root = FXMLLoader.load(getClass().getResource("ListAvis.fxml"));
   Scene scene = new Scene(root);
   //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
   String css = this.getClass().getResource("fxml.css").toExternalForm();
   scene.getStylesheets().add(css);
   stage.setScene(scene);
   stage.show();
  } catch(Exception e) {
   e.printStackTrace();
  }
 }*/
    
  
}
