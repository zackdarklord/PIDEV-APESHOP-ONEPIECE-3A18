
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
import entities.CategorieA;
/**
 * FXML Controller class
 *
 * @author Skander
 */


    
 
public class AjoutAvisController implements Initializable {
    
    @FXML
    private Label welcome;
    @FXML
    private TextField contenuAvis;
    @FXML
    private ChoiceBox nomCategorie;
    @FXML
    private TextField numeroUtilisateur;
    AvisCRUD ps = new AvisCRUD();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategorieACRUD ca =new CategorieACRUD();
        nomCategorie.getItems().addAll(ca.afficherCategorieANom());
        nomCategorie.setValue("consoles"); 
                
    }    
    
   
    
    @FXML
    private void Insert(ActionEvent event) {
       
        Avis a = new Avis();
        a.setContenuAvis(contenuAvis.getText());
        a.setNomCategorie((String) nomCategorie.getValue());
        a.setNumeroUtilisateur(Integer.parseInt(numeroUtilisateur.getText()));
       
        ps.ajouterAvis2(a);
         JOptionPane.showMessageDialog(null, "ajouté");
         System.out.println(a);
    }

    @FXML
    private void Affichage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListAvis.fxml"));
            Parent root = loader.load();
            numeroUtilisateur.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjoutAvisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
