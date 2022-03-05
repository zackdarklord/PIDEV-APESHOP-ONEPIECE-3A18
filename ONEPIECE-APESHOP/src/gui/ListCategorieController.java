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
import entities.CategorieA;
import services.CategorieACRUD;
/**
 * FXML Controller class
 *
 * @author AhmedBG
 */
public class ListCategorieController implements Initializable {
    @FXML
    private AnchorPane pane;
    @FXML
    private TableColumn<CategorieA,String> col_categorie;
    @FXML
    private TableView<CategorieA> table_categorie;
    @FXML
    private TableColumn<CategorieA, String> col_id;
    private Stage stage;
    private Scene scene;
    private Parent root;

    
    CategorieACRUD sp = new CategorieACRUD();
        List listCategorie = sp.afficherCategorieA();
        ObservableList<CategorieA> ListCategorie = FXCollections.observableArrayList();          
   
  
    /**
     * Initializes the controller class.
     */
    @Override                                                               
              
        public void initialize(URL location, ResourceBundle resources) {
        CategorieACRUD sp = new CategorieACRUD();
        List listCategorie = sp.afficherCategorieA();
        ObservableList list = FXCollections.observableArrayList(listCategorie);
        table_categorie.setItems(list);
        
        //col_id.setCellValueFactory(new PropertyValueFactory<>("idAvis"));
        col_categorie.setCellValueFactory(new PropertyValueFactory<>("nomCategorie"));
       
        
        
        }
   

    
    
   
    public void Ajouter (ActionEvent event) throws IOException {
     root = FXMLLoader.load(getClass().getResource("AjoutCategorie.fxml"));
     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
     scene = new Scene(root);
     stage.setScene(scene);
     stage.show();
    
    }
      
   public void Supprimer (ActionEvent event){
       
      CategorieA aa = table_categorie.getSelectionModel().getSelectedItem();
      table_categorie.getItems().remove(aa);
      sp.supprimerCategorieA(aa.getIdCategorie());
      
               
       
   }
    
  public void Modifier (ActionEvent event) throws IOException {
      CategorieA aax = table_categorie.getSelectionModel().getSelectedItem();
      //table_avis.getItems();
      
     FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifCategorie.fxml"));
     root = loader.load();
      ModifCategorieController modifCategorieController = loader.getController();
      modifCategorieController.ax=aax;    
      modifCategorieController.Test(aax);
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

