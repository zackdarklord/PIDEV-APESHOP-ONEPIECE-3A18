


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services ; 
import entities.Produit;
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
public class ProduitCRUD {
    Connection cnx2; 
    public ProduitCRUD(){
        cnx2 = MyConnection.getInstance().getCnx();
    }
    public void ajouterProduit () {
        try {
            String requete = "INSERT INTO produits(nomProduit,quantite,prixUnitaire,idCategorie) "
                    + "VALUES ('nintendo','50','1500','20')";
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("Produit ajouté avec succès");
        } catch (SQLException ex) {
            System.err.println (ex.getMessage());
        }
    }
    public void ajouterProduit2 (Produit p){
        try {
            String requete2 = "INSERT INTO produits(nomProduit,quantite,prixUnitaire,idCategorie) "
                    + "VALUES(?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setString(1, p.getNomProduit());
            pst.setInt(2, p.getQuantite());
            pst.setFloat(3, p.getPrixUnitaire());
            pst.setInt(4, p.getIdCategorie());

         
            pst.executeUpdate();
            System.out.println ("votre produit est ajouté");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
                
    }
    public List<Produit> afficherProduits () {
        List<Produit> myList = new ArrayList<>();
        try {
            
            String requete3 = "SELECT * FROM produits";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                  Produit p = new Produit();
                  p.setNumeroProduit(rs.getInt(1));
                  p.setNomProduit(rs.getString(2));
                  p.setQuantite(rs.getInt(3));
                  p.setPrixUnitaire(rs.getFloat(4));
                  p.setIdCategorie(rs.getInt(5));

                  
                  myList.add(p);
                  
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
        return myList;
    }
    
    public void modifierProduit (Produit p , int numeroProduit){
    try {
            String req = "UPDATE produits SET nomProduit=?,quantite=?,prixUnitaire=?,idCategorie=? "
                    + "WHERE numeroProduit=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
             pst.setString(1,p.getNomProduit());
            pst.setInt(2,p.getQuantite());
            pst.setFloat (3,p.getPrixUnitaire()); 
            pst.setInt(4,p.getIdCategorie()) ;
             pst.setInt(4,p.getNumeroProduit()) ;
            pst.executeUpdate();
            System.out.println("produit modifie !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
  
   public void supprimerProduit(int numeroProduit){
    try {
            String req = "DELETE FROM produits "
                    + "WHERE numeroProduit=?";
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setInt(1, numeroProduit);
            pst.executeUpdate();
            System.out.println("produit supprime !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
