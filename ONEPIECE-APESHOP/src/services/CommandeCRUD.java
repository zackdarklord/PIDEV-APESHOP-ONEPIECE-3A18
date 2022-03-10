package services;

import entities.Commande;
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
public class CommandeCRUD {
     Connection cnx2 ; 
    public CommandeCRUD (){
        cnx2 = MyConnection.getInstance().getCnx();
    }
    
    public void ajouterCommande(){
        try {
            String requete ="INSERT INTO commandes (dateCreation , dateEnvoi,numeroUtilisateur, statut) "
                    + "VALUES ('24152020','26022022','123','bechir')"; 
            Statement st =cnx2.createStatement() ;
            st.executeUpdate(requete); 
            System.out.println ("Commande ajoutée avec succés"); 
        } catch (SQLException ex) {
           System.err.println (ex.getMessage());
        }
    }
    
    public void ajouterCommande2 (Commande c ){
        try {
            String requete2 = "INSERT INTO commandes (dateCreation , dateEnvoi,numeroUtilisateur, statut) "
                    + "VALUES (?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setDate(1,c.getDateCreation());
            pst.setDate(2,c.getDateEnvoi());
            pst.setInt (3,c.getNumeroUtilisateur());
            pst.setString (4,c.getStatut()); 
            pst.executeUpdate(); 
            System.out.println (" votre Commande ajoutée avec succés"); 


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Commande> afficherCommandes (){
                    List<Commande> myList = new ArrayList<>();
        try {
            String requete3 = " SELECT * FROM commandes ";
            Statement st = cnx2.createStatement();
            ResultSet rs= st.executeQuery(requete3);  
            while (rs.next()){
            Commande c = new Commande() ; 
            c.setNumeroCommande(rs.getInt(1));
            c.setDateCreation(rs.getDate(2));
            c.setDateEnvoi(rs.getDate(3));
            c.setNumeroUtilisateur(rs.getInt(4));
            c.setStatut(rs.getString(5));
            myList.add(c);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList ;
    }
    public List<Commande> afficherCommandesUnique (int id){
                    List<Commande> myList = new ArrayList<>();
        try {
            String requete3 = " SELECT * FROM commandes WHERE numeroUtilisateur="+id;
            Statement st = cnx2.createStatement();
            ResultSet rs= st.executeQuery(requete3);  
            while (rs.next()){
            Commande c = new Commande() ; 
            c.setNumeroCommande(rs.getInt(1));
            c.setDateCreation(rs.getDate(2));
            c.setDateEnvoi(rs.getDate(3));
            c.setNumeroUtilisateur(rs.getInt(4));
            c.setStatut(rs.getString(5));
            myList.add(c);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList ;
    }
    
     public void modifierCommande (Commande c , int numeroCommande){
    try {
            String req = "UPDATE commandes SET dateCreation=?,dateEnvoi=?,numeroUtilisateur=?,statut=? "
                    + "WHERE numeroCommande=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
             pst.setDate(1,c.getDateCreation());
            pst.setDate(2,c.getDateEnvoi());
            pst.setInt (3,c.getNumeroUtilisateur()); 
            pst.setString(4,c.getStatut()) ;
             pst.setInt(5,c.getNumeroCommande()) ;
            pst.executeUpdate();
            System.out.println("commande modifie !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
  
   public void supprimerCommande(int numeroCommande){
    try {
            String req = "DELETE FROM commandes "
                    + "WHERE numeroCommande=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setInt(1, numeroCommande);
            pst.executeUpdate();
            System.out.println("commande supprime !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}