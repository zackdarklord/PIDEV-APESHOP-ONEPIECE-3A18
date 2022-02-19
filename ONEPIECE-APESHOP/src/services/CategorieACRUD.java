
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Avis;
import entities.CategorieA;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;
/**
 *
 * @author ASUS
 */
public class CategorieACRUD {
     Connection cnx2 ; 
    public CategorieACRUD (){
        cnx2 = MyConnection.getInstance().getCnx();
    }
    
    public void ajouterCategorieA(){
        try {
            String requete ="INSERT INTO categoriea (nomCategorie) "
                    + "VALUES ('jeux')"; 
            Statement st =cnx2.createStatement() ;
            st.executeUpdate(requete); 
            System.out.println ("categorie ajoutée avec succés"); 
        } catch (SQLException ex) {
           System.err.println (ex.getMessage());
        }
    }
    
    public void ajouterAvis2 (CategorieA c ){
        try {
            String requete2 = "INSERT INTO categorie (nomCategorie) "
                    + "VALUES (?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setString(1,c.getNomCategorie());
            pst.executeUpdate(); 
            System.out.println (" votre Avis ajoutée avec succés"); 


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<CategorieA> affCategorieAs (){
                    List<CategorieA> myList = new ArrayList<>();
        try {
            String requete3 = " SELECT * FROM categorieA ";
            Statement st = cnx2.createStatement();
            ResultSet rs= st.executeQuery(requete3);  
            while (rs.next()){
            CategorieA c = new CategorieA() ; 
            c.setIdCategorie(rs.getInt(1));
            c.setNomCategorie(rs.getString(2));
            myList.add(c);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList ;
    }
    
     public void modifierCategorieA (CategorieA c , int idCategorie){
    try {
            String req = "UPDATE commandes SET nomCategorie=?"
                    + "WHERE idCategorie=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setString(1,c.getNomCategorie()); 
             pst.setInt(2,c.getIdCategorie()) ;
            pst.executeUpdate();
            System.out.println("Categorie modifie !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
  
   public void supprimerCategorieA(int idCategorie){
    try {
            String req = "DELETE FROM categorieA "
                    + "WHERE idCategorie=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setInt(1, idCategorie);
            pst.executeUpdate();
            System.out.println("Categorie supprime !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}