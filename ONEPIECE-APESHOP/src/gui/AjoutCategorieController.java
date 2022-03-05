
package gui;

import entities.CategorieA;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.CategorieACRUD;

/**
 * FXML Controller class
 *
 * @author Skander
 */


    
 
public class AjoutCategorieController implements Initializable {
    
    @FXML
    private Label welcome;
    
    CategorieACRUD ps = new CategorieACRUD();
    @FXML
    private TextField col_categorie;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
   
    
    @FXML
    private void Insert(ActionEvent event) {
        CategorieA a = new CategorieA();
        a.setNomCategorie(col_categorie.getText());
        
       
        ps.ajouterCategorieA2(a); 
         JOptionPane.showMessageDialog(null, "ajouté");
    }

    @FXML
    private void Affichage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListCategorie.fxml"));
            Parent root = loader.load();
            col_categorie.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjoutCategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
