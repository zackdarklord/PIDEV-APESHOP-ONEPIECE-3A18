/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Avis;
import entities.Commande;
import entities.Commentaire;
import entities.Forum;
import entities.Utilisateur;
import helper.AlertHelper;
import static java.awt.SystemColor.window;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import services.AvisCRUD;
import services.CategorieACRUD;
import services.CommandeCRUD;
import services.CommentaireCRUD;
import services.ForumCRUD;

/**
 *
 * @author Ramesh Godara
 */
public class Page08AController implements Initializable {

    @FXML
    private TableView<Commentaire> tableview;
    @FXML
    private TableColumn<?, ?> commentaire;
    @FXML
    private TableColumn<?, ?> numU;
    @FXML
    private Button btn_ajouter;
    @FXML
    private ChoiceBox<String> ch_categorie;
    private TextField tf_avis;
    @FXML
    private Button btn_supprimer;
   public Commentaire u = new Commentaire();
   private CommentaireCRUD ps =new CommentaireCRUD();
   public Avis a=new Avis(); 
   public Forum f=new Forum(); 
   public int ID ;
    Window window;
    @FXML
    private Button btn_ajouter1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ForumCRUD ca =new ForumCRUD();
        ch_categorie.getItems().addAll(ca.afficherForumN());
        ch_categorie.setValue("LES CONSOLES RARES!!");   
    }

    @FXML
    private void supprimer(ActionEvent event) {
       Commentaire aa = tableview.getSelectionModel().getSelectedItem();
      tableview.getItems().remove(aa);
      ps.supprimercommentaire(aa.getIdCommentaire());
    AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "commentaire supprimé!.");
    }
    public void modifier (ActionEvent event) throws IOException {
      /*Avis aax = tableview.getSelectionModel().getSelectedItem();
      //table_avis.getItems();
      System.out.println(aax);
        tf_avis.setText(aax.getContenuAvis());
        ch_categorie.setValue(aax.getNomCategorie());
        
      a=aax;
     */
    
    }
    public void afficher() {
        CommentaireCRUD prd=new CommentaireCRUD();
          List <Commentaire> myList = prd.afficherCommentaires();
          ObservableList list = FXCollections.observableArrayList(myList);
          tableview.setItems(list);
          commentaire.setCellValueFactory(new PropertyValueFactory<>("contenuCommentaire"));
          numU.setCellValueFactory(new PropertyValueFactory<>("numeroUtilisateur"));
         }

    private boolean isValidated() {

        window = btn_ajouter.getScene().getWindow();
        if (tf_avis.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "avis text field cannot be blank.");
            tf_avis.requestFocus();
        } else if (tf_avis.getText().length() < 5 || tf_avis.getText().length() > 64) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "avis text field cannot be less than 5 and greator than 64 characters.");
            tf_avis.requestFocus();
        
        } else {
            return true;
        }
        return false;
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
          numU.setCellValueFactory(new PropertyValueFactory<>("numeroUtilisateur"));
    
    }

    @FXML
    private void Excel(ActionEvent event) {
        try   
{  
         CommentaireCRUD prd=new CommentaireCRUD();
          List <Commentaire> myList = prd.afficherCommentaires();
//declare file name to be create   
String filename = "EXCEL/Balance.xls";  
//creating an instance of HSSFWorkbook class  
HSSFWorkbook workbook = new HSSFWorkbook();  
//invoking creatSheet() method and passing the name of the sheet to be created   
HSSFSheet sheet = workbook.createSheet("liste des commentaires");   
//creating the 0th row using the createRow() method  
HSSFRow rowhead = sheet.createRow((short)0);  
//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method  
rowhead.createCell(0).setCellValue("S.No.");  
rowhead.createCell(1).setCellValue("Numero Utilisateur");  
rowhead.createCell(2).setCellValue("Commentaire");  
  int i =1;
//creating the 1st row  
for (Commentaire c :myList){
HSSFRow row = sheet.createRow((short)i);  
//inserting data in the first row  
row.createCell(1).setCellValue(c.getNumeroUtilisateur());  
row.createCell(2).setCellValue(c.getContenuCommentaire());  
 i++;

  
}
 
  
 
FileOutputStream fileOut = new FileOutputStream(filename);  
workbook.write(fileOut);
//closing the workbook 
//closing the Stream  
fileOut.close();
workbook.close();  
//prints the message on the console  
System.out.println("Excel file has been generated successfully.");  
}   
catch (Exception e)   
{  
e.printStackTrace();  
} 
    }

    
}


