/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Commande;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import utils.MyConnection;

import entities.Facture;
import java.awt.Label;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import services.FactureCRUD;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GUIb2Controller implements Initializable {

    @FXML
    private TextField tfnumF;
    @FXML
    private TextField tftypL;
    @FXML
    private TextField tfprL;
    @FXML
    private TextField tfnumR;
    @FXML
    private TableView<Facture> tvfactures;
  
    @FXML
    private Button btninsert2;
    @FXML
    private Button btnupdate2;
    @FXML
    private Button btndelete2;
    @FXML
    private TableColumn<?, ?> colnumF;
    @FXML
    private TableColumn<?, ?> coltypl;
    @FXML
    private TableColumn<?, ?> colprl;
    @FXML
    private TableColumn<?, ?> colnumr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleMouseAction(MouseEvent event) {
         Facture cmd =   (Facture) tvfactures.getSelectionModel().getSelectedItem();
      tfnumF    .setText(""+cmd.getNumeroFacture());
       tftypL.setText(cmd.getTypeLivraison());
       tfprL.setText(""+cmd.getPrixLivraison());
       tfnumR.setText(""+cmd.getNumeroRegionDestinataire());
    
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
             System.out.println("you Clicked on me ! ");//alerte de click 
        if (event.getSource()==btninsert2){
            insertRecord2(); 
        }else if(event.getSource()==btnupdate2){
   updateRecord2();
    } else if(event.getSource()==btndelete2){
        deleteButton2();
    }
    }
    
    
    
      public Connection getConnection1() {
    Connection conn; 
    try{
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/apeshop", "root", "");
        return conn ;
    }catch(Exception ex){
        System.out.println("error : " +ex.getMessage());
        return null;
    }
    }
    
    
     public ObservableList<Facture> getFacturesList()  {
    ObservableList<Facture> FactureList = FXCollections.observableArrayList();
    Connection conn = getConnection1() ;
    String query = "SELECT * from factures ";
    Statement st ; 
    ResultSet rs ; 
    try{ 
        st = conn.createStatement();
        rs=st.executeQuery(query);
        Facture facture ; 
        while (rs.next()){
            facture = new Facture(rs.getInt("numeroFacture"),rs.getString("typeLivraison"), (int) rs.getFloat("prixLivraison"),rs.getInt("numeroRegionDestinataire"));
          FactureList.add(facture); 
        }
    }catch(Exception ex){
    ex.printStackTrace();
    }
    return FactureList ; 
    }
    
    
  public void showFactures()  {
        ObservableList <Facture> List1 = getFacturesList();
        colnumF.setCellValueFactory(new PropertyValueFactory <>("numeroFacture"));
        coltypl.setCellValueFactory(new PropertyValueFactory <>("typeLivraison"));
        colprl.setCellValueFactory(new PropertyValueFactory <>("prixLivraison"));
        colnumr.setCellValueFactory(new PropertyValueFactory <>("numeroRegionDestinataire"));
        tvfactures.setItems(List1);
    }  
  
  private void insertRecord2(){
    String query = "INSERT INTO factures VALUES ("+ colnumF.getText()+",'"+coltypl.getText()+"','"+colprl.getText() +"',"+colnumr.getText() +"')";
    executeQuery(query);
   // showFactures(); 
    
            }
    
    
    private void updateRecord2(){
String query ="UPDATE factures SET typeLivraison ='"+tftypL.getText() +"', prixLivraison = " +tfprL.getText() +", numeroRegionDestinataire ="+tfnumR.getText()+" WHERE numeroFacture ="+tfnumF.getText()+"";
executeQuery(query);
//showFactures();

}
private void deleteButton2(){
String query = "DELETE FROM factures WHERE numeroFacture =" + tfnumF.getText() +"";
executeQuery(query); 
//showFactures(); 
}
    
    
    
   private void executeQuery(String query) {
     Connection conn = getConnection1(); 
     Statement st ; 
    try{
         st = conn.createStatement();
         st.executeUpdate(query);
     }catch(Exception ex){
    ex.printStackTrace();
}
}  
    
    
    
    
    
}
