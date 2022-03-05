
package gui;

import entities.Avis;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.AvisCRUD;
import services.CategorieACRUD;

/**
 * FXML Controller class
 *
 * @author Skander
 */


    
 
public class ModifAvisController implements Initializable {

    
    
    @FXML
    private Label labelAvis;
    @FXML
    private TextField col_id ;
    @FXML
    private TextField col_avis;
    @FXML
    private ChoiceBox col_categorie;
    @FXML
    private TextField col_numUtilisateur;
    AvisCRUD ps = new AvisCRUD();
    @FXML    
    Avis ax =new Avis();
    
   
   // col_numUtilisateur =setText(ax.getSetconteny()) ;
        
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       CategorieACRUD ca =new CategorieACRUD();
        col_categorie.getItems().addAll(ca.afficherCategorieANom());
        
        
    }    
    @FXML
    public void Test (Avis a2){
        
        col_avis.setText(a2.getContenuAvis());
        col_categorie.setValue(a2.getNomCategorie());
        
        col_numUtilisateur.setText(String.valueOf(a2.getNumeroUtilisateur()));    
    }
    
    @FXML
    private void Insert(ActionEvent event ) {
        Avis a = new Avis();
        //a.setIdAvis(Integer.parseInt(col_id.getText()));
        a.setContenuAvis(col_avis.getText());
        a.setNomCategorie((String) col_categorie.getValue());
        a.setNumeroUtilisateur(Integer.parseInt(col_numUtilisateur.getText()));
       
        ps.modifierAvis(a,ax.getIdAvis());
         JOptionPane.showMessageDialog(null, "modifié");
         System.out.println(ax);
         
         
    }

    @FXML
    private void Affichage(ActionEvent event) {
        try {
            System.out.println(ax);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListAvis.fxml"));
            Parent root = loader.load();
            col_numUtilisateur.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjoutAvisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
