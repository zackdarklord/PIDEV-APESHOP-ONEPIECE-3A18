/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import utils.MyConnection;

import entities.Commande;
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
import services.CommandeCRUD;



/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GUIbController implements Initializable {

    @FXML
    private TextField tfnumC;
    @FXML
    private TextField tfdc;
    @FXML
    private TextField tfde;
    @FXML
    private TextField tfnu;
    @FXML
    private TextField tfstat;
    @FXML
    private TableView<Commande> tvcommandes;
    @FXML
    private TableColumn<Commande,Integer> colnumc;
    @FXML
    private TableColumn<Commande, String> coldc;
    @FXML
    private TableColumn<Commande, String> colde;
    @FXML
    private TableColumn<Commande,Integer> colnumu;
    @FXML
    private TableColumn<Commande, String> colstat;
    @FXML
    private Button btninsert;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showCommandes();
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("you Clicked on me ! ");//alerte de click 
        if (event.getSource()==btninsert){
            insertRecord1(); 
        }else if(event.getSource()==btnupdate){
   updateRecord();
    } else if(event.getSource()==btndelete){
        deleteButton();
    }
    }
     //   Window window;

  // CommandeCRUD crd = new CommandeCRUD();
   // List<Commande> myList = crd.afficherCommandes();
    
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
    
    
    public ObservableList<Commande> getCommandesList()  {
    ObservableList<Commande> CommandeList = FXCollections.observableArrayList();
    Connection conn = getConnection1() ;
    String query = "SELECT * from commandes  ";
    Statement st ; 
    ResultSet rs ; 
    try{ 
        st = conn.createStatement();
        rs=st.executeQuery(query);
        Commande Commandes ; 
        while (rs.next()){
            Commandes = new Commande(rs.getInt("numeroCommande"),rs.getString("dateCreation"),rs.getString("dateEnvoi"),rs.getInt("numeroUtilisateur"),rs.getString("statut"));
            CommandeList.add(Commandes); 
        }
    
        
    }catch(Exception ex){
    ex.printStackTrace();
    }
    return CommandeList ; 
    }
    public void showCommandes()  {
        ObservableList <Commande> List = getCommandesList();
        colnumc.setCellValueFactory(new PropertyValueFactory <Commande, Integer> ("numeroCommande"));
        coldc.setCellValueFactory(new PropertyValueFactory <Commande, String> ("dateCreation"));
        colde.setCellValueFactory(new PropertyValueFactory <Commande, String> ("dateEnvoi"));
        colnumu.setCellValueFactory(new PropertyValueFactory <Commande, Integer> ("numeroUtilisateur"));
        colstat.setCellValueFactory(new PropertyValueFactory <Commande, String> ("statut"));
        
        tvcommandes.setItems(List);
    }
private void insertRecord1(){
    String query = "INSERT INTO commandes VALUES ("+ tfnumC.getText()+",'"+tfdc.getText()+"','"+tfde.getText() +"',"+tfnu.getText() +",'"+tfstat.getText() +"')";
    executeQuery(query);
    showCommandes(); 
    
            }
private void updateRecord(){
String query ="UPDATE commandes SET statut ='"+tfstat.getText() +"', dateCreation = '" +tfdc.getText() +"', dateEnvoi ='"+tfde.getText()+" WHERE numeroCommande ="+tfnumC.getText()+"";
executeQuery(query);
showCommandes();

}
private void deleteButton(){
String query = "DELETE FROM commandes WHERE numeroCommande =" + tfnumC.getText() +"";
executeQuery(query); 
showCommandes(); 
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

    @FXML
    private void handleMouseAction(MouseEvent event) {
      Commande cmd =   tvcommandes.getSelectionModel().getSelectedItem();
      tfnumC.setText(""+cmd.getNumeroCommande());
       tfnumC.setText(cmd.getDateCreation());
       tfnumC.setText(cmd.getDateEnvoi());
       tfnumC.setText(""+cmd.getNumeroUtilisateur());
       tfnumC.setText(cmd.getStatut());
    }
}