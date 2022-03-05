
package gui;


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
import entities.CategorieA;

/**
 * FXML Controller class
 *
 * @author Skander
 */


    
 
public class ModifCategorieController implements Initializable {

    
    
    
    @FXML
    private TextField col_categorie;
   
    CategorieACRUD ps = new CategorieACRUD();
    CategorieA ax =new CategorieA();
    
    
    
   
   // col_numUtilisateur =setText(ax.getSetconteny()) ;
        
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    
    public void Test (CategorieA a2){
        
        
        col_categorie.setText(a2.getNomCategorie());
           
    }
    
    @FXML
    private void Insert(ActionEvent event ) {
        CategorieA a = new CategorieA();
        //a.setIdAvis(Integer.parseInt(col_id.getText()));
       
        a.setNomCategorie(col_categorie.getText());
        
       
        ps.modifierCategorieA(a,ax.getIdCategorie());
         JOptionPane.showMessageDialog(null, "modifié");
         System.out.println(ax);
         
         
    }

    @FXML
    private void Affichage(ActionEvent event) {
        try {
            System.out.println(ax);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListCategorie.fxml"));
            Parent root = loader.load();
            col_categorie.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjoutAvisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
