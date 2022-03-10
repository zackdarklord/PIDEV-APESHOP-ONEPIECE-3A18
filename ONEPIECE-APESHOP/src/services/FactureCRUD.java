package services;

import entities.Facture;
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
public class FactureCRUD {
    Connection cnx2 ; 
    public FactureCRUD (){
        cnx2 = MyConnection.getInstance().getCnx();
    }
    
    public void ajouterFacture(){
        try {
            String requete ="INSERT INTO factureS (typeLivraison , prixLivraison, numeroRegionDestinataire) "
                    + "VALUES ('145il','12','352')"; 
            Statement st =cnx2.createStatement() ;
            st.executeUpdate(requete); 
            System.out.println ("Facture ajoutée avec succés"); 
        } catch (SQLException ex) {
           System.err.println (ex.getMessage());
        }
    }

 public void ajouterFacture2(Facture f ){
        try {
            String requete2 = "INSERT INTO factures (typeLivraison , prixLivraison, numeroRegionDestinataire,numeroUtilisateur) "
                    + "VALUES (?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setString(1,f.getTypeLivraison());
            pst.setFloat(2,f.getPrixLivraison());
            pst.setInt (3,f.getNumeroRegionDestinataire()); 
            pst.setInt (4,f.getNumeroUtilisateur()); 
            pst.executeUpdate(); 
            System.out.println (" votre Facture est  ajoutée avec succés"); 


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

  public List<Facture> afficherFactures (){
                    List<Facture> myListf = new ArrayList<>();
        try {
            String requete3 = " SELECT * FROM factures ";
            Statement st = cnx2.createStatement();
            ResultSet rs= st.executeQuery(requete3);  
            while (rs.next()){
           Facture f = new Facture() ; 
            f.setNumeroFacture(rs.getInt(1));
            f.setTypeLivraison(rs.getString(2));
            f.setPrixLivraison(rs.getFloat(3));
            f.setNumeroRegionDestinataire(rs.getInt(4));
            myListf.add(f);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myListf;
    }
   public List<Facture> afficherFacturesu (int id){
                    List<Facture> myListf = new ArrayList<>();
        try {
            String requete3 = " SELECT * FROM factures WHERE numeroUtilisateur="+id;
            Statement st = cnx2.createStatement();
            ResultSet rs= st.executeQuery(requete3);  
            while (rs.next()){
            Facture f = new Facture() ; 
            f.setNumeroFacture(rs.getInt(1));
            f.setTypeLivraison(rs.getString(2));
            f.setPrixLivraison(rs.getFloat(3));
            f.setNumeroRegionDestinataire(rs.getInt(4));
            f.setNumeroUtilisateur(rs.getInt(5));
            myListf.add(f);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myListf;
    }
    
  public void modifierFacture (Facture f , int numeroFacture){
    try {
            String req = "UPDATE factures SET typeLivraison=?,prixLivraison=?,numeroRegionDestinataire=? "
                    + "WHERE numeroFacture=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
             pst.setString(1,f.getTypeLivraison());
            pst.setFloat(2,f.getPrixLivraison());
            pst.setInt (3,f.getNumeroRegionDestinataire()); 
            pst.setInt(4,f.getNumeroFacture()) ; 
            pst.executeUpdate();
            System.out.println("facture modifie !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
  
   public void supprimerFacture(int numeroFacture){
    try {
            String req = "DELETE FROM factures  "
                    + "WHERE numeroFacture=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setInt(1, numeroFacture);
            pst.executeUpdate();
            System.out.println("facture supprime !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}