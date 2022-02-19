 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services ; 
import entities.CategorieP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyConnection;


/**
 *
 * @author ASUS
 */
public class CategoriePCRUD {
    Connection cnx2; 
    public CategoriePCRUD(){
        cnx2 = MyConnection.getInstance().getCnx();
}
    public void ajouterCategorieP () {
        try {
            String requete = "INSERT INTO categoriep(nomCategorie) "
                    + "VALUES ('jeuvideo')";
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("Categorie ajouté avec succès");
        } catch (SQLException ex) {
            System.err.println (ex.getMessage());
        }
    }
    public void ajouterCategorie2 (CategorieP c){
        try {
            String requete2 = "INSERT INTO categoriep(nomCategorie) "
                    + "VALUES(?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setInt(1, c.getIdCategorie());
         
            

         
            pst.executeUpdate();
            System.out.println ("votre categorie est ajouté");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
                
    }
    public List<CategorieP> afficherCategoriesP () {
        List<CategorieP> myList = new ArrayList<>();
        try {
            
            String requete3 = "SELECT * FROM categoriep";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                  CategorieP c = new CategorieP();
                  c.setIdCategorie(rs.getInt(1));
                  c.setNomCategorie(rs.getString(2));
                  

                  
                  myList.add(c);
                  
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
        return myList;
    }
    
    public void modifierCategorieP (CategorieP c , int idCategorie){
    try {
            String req = "UPDATE commandes SET dateCreation=?,dateEnvoi=?,numeroUtilisateur=?,statut=? "
                    + "WHERE numeroCommande=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
             pst.setString(1,c.getNomCategorie());
            
            pst.executeUpdate();
            System.out.println("categorie modifie !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
  
   public void supprimerCategorieP(int idCategorie){
    try {
            String req = "DELETE FROM categoriep "
                    + "WHERE idCategorie=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setInt(1, idCategorie);
            pst.executeUpdate();
            System.out.println("categorie supprime !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

