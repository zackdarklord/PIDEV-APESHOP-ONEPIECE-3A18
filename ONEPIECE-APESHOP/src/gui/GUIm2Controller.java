/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.CategorieP;
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
public class GUIm2Controller implements Initializable {

    @FXML
    private TextField tfidc2;
    @FXML
    private TextField tfnomc;
    @FXML
    private Button btnajouter2;
    @FXML
    private Button btnmod2;
    @FXML
    private Button btnsupp2;
    @FXML
    private TableView<CategorieP> tvcategoriesp;
    @FXML
    private TableColumn<?, ?> colidc2;
    @FXML
    private TableColumn<?, ?> colnomc;

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
    
    public ObservableList<CategorieP> getCategoriePsList(){
    ObservableList <CategorieP> CategoriePList = FXCollections.observableArrayList();
    Connection conn= getConnection();
    String query ="SELECT + FROM categoriep";
    Statement st;
    ResultSet rs;
    try{
        st= conn.createStatement();
        rs= st.executeQuery(query);
        CategorieP CategoriePs;
        while (rs.next()) {
            CategorieP CategoriesPs = new CategorieP(rs.getInt ("idCategorie"),rs.getString("nomCategorie"));
            CategoriePList.add(CategoriesPs);
        }
    } catch(SQLException ex){
        ex.printStackTrace();
    }
    return CategoriePList;
    }

   
    
    public void showCategoriePs(){
        ObservableList <CategorieP> List = getCategoriePsList();
        colidc2.setCellValueFactory(new PropertyValueFactory <>("idCategorie"));
        colnomc.setCellValueFactory(new PropertyValueFactory <> ("nomCategorie"));
        
        tvcategoriesp.setItems(List);

    }
    
    
    
    
    private void insertRecord2(){
     String query = "INSERT INTO categoriep VALUES (" +tfidc2.getText()+", '"+tfnomc.getText()+"')";
     executeQuery(query);
     showCategoriePs();   
        
    }
    
    private void updateRecord2() {
     String query ="UPDATE categoriep SET nomCategorie ='"+tfnomc.getText()+"WHERE idCategorie="+tfidc2.getText()+"";
     executeQuery(query);
     showCategoriePs();
     
        
    }
     private void deleteButton2(){
         String query ="DELETE FROM categoriep WHERE idCategorie="+tfidc2.getText()+"";
         executeQuery(query);
         showCategoriePs();
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
