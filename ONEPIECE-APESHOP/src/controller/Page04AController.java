/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.xdevapi.Table;
import entities.Avis;
import entities.Commande;
import entities.Utilisateur;
import helper.AlertHelper;
import static java.awt.SystemColor.window;
import java.io.FileNotFoundException;
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
import services.AvisCRUD;
import services.CategorieACRUD;
import services.CommandeCRUD;

/**
 *
 * @author Ramesh Godara
 */
public class Page04AController implements Initializable {

    @FXML
    private TableView<Avis> tableview;
    @FXML
    private TableColumn<Avis, String> categorie;
    @FXML
    private TableColumn<Avis, String> avis;
    @FXML
    private TableColumn<Avis, Integer> numC;
    @FXML
    private Button btn_supprimer;
   public Utilisateur u = new Utilisateur();
   private AvisCRUD ps =new AvisCRUD();
   public Avis a=new Avis(); 
    Window window;
    @FXML
    private Button btn_supprimer1;

    public void initialize(URL url, ResourceBundle rb) {

      
    }
   

    @FXML
    private void supprimer(ActionEvent event) {
       Avis aa = tableview.getSelectionModel().getSelectedItem();
      tableview.getItems().remove(aa);
      ps.supprimerAvis(aa.getIdAvis());
    AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "Avis supprimé!.");
    }

    public void afficher() {
        AvisCRUD prd=new AvisCRUD();
          List <Avis> myList = prd.afficherAvis();
          System.out.println(myList);
          ObservableList list = FXCollections.observableArrayList(myList);
          tableview.setItems(list);
          categorie.setCellValueFactory(new PropertyValueFactory<>("nomCategorie"));
          avis.setCellValueFactory(new PropertyValueFactory<>("contenuAvis"));
          numC.setCellValueFactory(new PropertyValueFactory<>("numeroUtilisateur"));
         }

    @FXML
    private void Export(ActionEvent event) {
        Document document = new Document();
          

        try {
            AvisCRUD prd=new AvisCRUD();
             List <Avis> myList = prd.afficherAvis();
            //System.out.println(myList);
            PdfWriter.getInstance(document,
                new FileOutputStream("PDF/Liste_avis.pdf"));
            PdfPTable table = new PdfPTable(3); 

            document.open();
            document.add(new Paragraph("                  Lise des avis:\n\n\n\n"));
            PdfPCell cell1 = new PdfPCell(new Paragraph("Numero Utilisateur"));
            PdfPCell cell2 = new PdfPCell(new Paragraph("Nom Catégorie"));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Avis"));

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            for(Avis a:myList){
            //document.add(new Paragraph("numero Client: "+a.getNumeroUtilisateur()+"Categorie "+a.getNomCategorie()+"Avis: "+a.getContenuAvis()+"\n"));
           // 3 columns.

           
            
           cell1 = new PdfPCell(new Paragraph(String.valueOf(a.getNumeroUtilisateur())));
           cell2 = new PdfPCell(new Paragraph(a.getNomCategorie()));
           cell3= new PdfPCell(new Paragraph(a.getContenuAvis()));

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);

            
             
            
}  
            document.add(table);
            AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "Exported!.");
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    
    }

