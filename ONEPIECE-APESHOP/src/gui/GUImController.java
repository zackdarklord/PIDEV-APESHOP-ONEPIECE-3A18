/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import utils.MyConnection;
import entities.Produit;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GUImController implements Initializable {

    @FXML
    private TextField tfnump;
    @FXML
    private TextField tfnomp;
    @FXML
    private TextField tfq;
    @FXML
    private TextField tfprixu;
    @FXML
    private TextField tfidc;
    @FXML
    private TableView<Produit> tvproduits;
    @FXML
    private TableColumn<Produit, Integer> colnump;
    @FXML
    private TableColumn<Produit, String> colnomp;
    @FXML
    private TableColumn<Produit, Integer> colq;
    @FXML
    private TableColumn<Produit, Float> colprixu;
    @FXML
    private TableColumn<Produit, Integer> colidc;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmod;
    @FXML
    private Button btnsupp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked on me");
    }
    public Connection getConnection() {
     Connection conn;
     try{
         conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/apeshop","root", "");
         return conn;
     } catch (SQLException ex){
         System.out.println("erreur : " +ex.getMessage());
         return null;
     }
    }
    
    public ObservableList<Produit> getProduitsList(){
    ObservableList <Produit> ProduitList = FXCollections.observableArrayList();
    Connection conn= getConnection();
    String query ="SELECT + FROM produits";
    Statement st;
    ResultSet rs;
    try{
        st= conn.createStatement();
        rs= st.executeQuery(query);
        Produit Produits;
        while (rs.next()) {
            Produits = new Produit(rs.getInt ("numeroProduit"),rs.getString("nomProduit"),rs.getInt("quantite"),rs.getFloat("prixUnitaire"),rs.getInt("idCategorie"));
            ProduitList.add(Produits);
        }
    } catch(SQLException ex){
        ex.printStackTrace();
    }
    return ProduitList;
    }
    public void showProduits() {
        ObservableList <Produit> List = getProduitsList();
        colnump.setCellValueFactory(new PropertyValueFactory <Produit, Integer>("numeroProduit"));
        colnomp.setCellValueFactory(new PropertyValueFactory <Produit, String> ("nomProduit"));
        colq.setCellValueFactory(new PropertyValueFactory <Produit, Integer> ("quantite"));
        colprixu.setCellValueFactory(new PropertyValueFactory <Produit, Float> ("prixUnitaire"));
        colidc.setCellValueFactory(new PropertyValueFactory <Produit,Integer> ("idCategorie") );
        tvproduits.setItems(List);

    }
    private void insertRecord(){
     String query = "INSERT INTO produits VALUES(" +tfnump.getText()+", '"+tfnomp.getText()+"',"+tfq.getText()+"',"+tfprixu.getText() +",'"+tfidc.getText()+"')";
     executeQuery(query);
     showProduits();   
        
    }
    
    private void updateRecord() {
     String query ="UPDATE produits SET idCategorie ='"+tfidc.getText()+"',prixUnitaire= '" +tfprixu.getText()+"',quantite='"+tfq.getText()+"',nomProduit='"+tfnomp.getText()+"WHERE numeroProduit="+tfnump.getText()+"";
     executeQuery(query);
     showProduits();
     
        
    }
     private void deleteButton(){
         String query ="DELETE FROM produits WHERE numeroProduit="+tfnump.getText()+"";
         executeQuery(query);
         showProduits();
     }
     private void executeQuery(String query) {
         Connection conn = getConnection();
         Statement st;
         try{
             st = conn.createStatement();
             st.executeUpdate(query);
         } catch (Exception ex){
             ex.printStackTrace();
         }
     }
    
    
    
    
}

 