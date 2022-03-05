
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.CategorieA;
import entities.Avis;
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
public class AvisCRUD {
     Connection cnx2 ; 
    public AvisCRUD (){
        cnx2 = MyConnection.getInstance().getCnx();
    }
    
    public void ajouterAvis(){
        try {
            String requete ="INSERT INTO avis (contenuAvis , nomCategorie,numeroUtilisateur) "
                    + "VALUES ('bon','CONSOLE','1')"; 
            Statement st =cnx2.createStatement() ;
            st.executeUpdate(requete); 
            System.out.println ("Avis ajoutée avec succés"); 
        } catch (SQLException ex) {
           System.err.println (ex.getMessage());
        }
    }
    
    public void ajouterAvis2 (Avis a ){
        try {
            String requete2 = "INSERT INTO avis (contenuAvis , nomCategorie,numeroUtilisateur) "
                    + "VALUES (?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setString(1,a.getContenuAvis());
            pst.setString (2,a.getNomCategorie());
            pst.setInt (3,a.getNumeroUtilisateur()); 
            pst.executeUpdate(); 
            System.out.println (" votre Avis ajoutée avec succés"); 


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Avis> afficherAvis (){
                    List<Avis> myList = new ArrayList<>();
        try {
            String requete3 = " SELECT * FROM avis ";
            Statement st = cnx2.createStatement();
            ResultSet rs= st.executeQuery(requete3);  
            while (rs.next()){
            Avis a = new Avis() ; 
            a.setIdAvis(rs.getInt(1));
            a.setContenuAvis(rs.getString(2));
            a.setNomCategorie(rs.getString(3));
            a.setNumeroUtilisateur(rs.getInt(4));
            myList.add(a);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList ;
    }
    
     public void modifierAvis (Avis a , int idAvis){
    try {
            String req = "UPDATE avis SET contenuAvis=?,nomCategorie=?,numeroUtilisateur=? "
                    + "WHERE idAvis=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
             
            pst.setString(1,a.getContenuAvis());
            pst.setString(2,a.getNomCategorie());
            pst.setInt (3,a.getNumeroUtilisateur()); 
            pst.setInt(4,idAvis) ;
            
            pst.executeUpdate();
            System.out.println("Avis modifie !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
  
   public void supprimerAvis(int idAvis){
    try {
            String req = "DELETE FROM avis "
                    + "WHERE idAvis=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setInt(1, idAvis);
            pst.executeUpdate();
            System.out.println("Avis supprime !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
   
  
}
