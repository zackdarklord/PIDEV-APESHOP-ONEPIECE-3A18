/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Panier;
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
 * @author zakar
 */
public class panierCRUD {

    Connection cnx;

    public panierCRUD() {
        cnx = MyConnection.getInstance().getCnx();
    }

    public void ajouterPanier(Panier p) {
        try {
            String req = "INSERT INTO paniers (numeroProduit,quantite,dateAjout,numeroUtilisateur,nomProduit) "
                    + "VALUES (?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getNumeroProduit());
            pst.setInt(2, p.getQuantite());
            pst.setDate(3, p.getDateAjout());
            pst.setInt(4, p.getNumeroUtilisateur());
            pst.setString(5, p.getNomProduit());

            pst.executeUpdate();
            System.out.println("panier ajoute !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void modifierPanier(Panier p, int id) {
        try {
            String req = "UPDATE paniers SET numeroProduit=?,quantite=?,dateAjout=?,numeroUtilisateur=? "
                    + "WHERE numeroPanier=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getNumeroProduit());
            pst.setInt(2, p.getQuantite());
            pst.setDate(3, p.getDateAjout());
            pst.setInt(4, p.getNumeroUtilisateur());
            pst.setInt(5, id);
            pst.executeUpdate();
            System.out.println("panier modifie !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void supprimerPanier(int id) {
        try {
            String req = "DELETE FROM paniers  "
                    + "WHERE numeroPanier=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("panier supprime !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Panier> afficherPanier() {
        List<Panier> MyList = new ArrayList<>();
        try {

            String req = "SELECT * FROM paniers";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Panier p = new Panier();
                p.setNumeroPanier(rs.getInt(1));
                p.setNumeroProduit(rs.getInt(2));
                p.setQuantite(rs.getInt(3));
                p.setDateAjout(rs.getDate(4));
                  p.setNumeroUtilisateur(rs.getInt(5));
                  p.setNomProduit(rs.getString(5));

                MyList.add(p);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return MyList;
    }
    public List<Panier> afficherPanierU(int id ) {
        List<Panier> MyList = new ArrayList<>();
        try {

            String req = "SELECT * FROM paniers WHERE numeroUtilisateur="+id;
            
            PreparedStatement pst = cnx.prepareStatement(req);
            
            ResultSet rs = pst.executeQuery(req);
            while (rs.next()) {
                Panier p = new Panier();
                p.setNumeroPanier(rs.getInt(1));
                p.setNumeroProduit(rs.getInt(2));
                p.setQuantite(rs.getInt(3));
                p.setDateAjout(rs.getDate(4));
                p.setNumeroUtilisateur(id);
                p.setNomProduit(rs.getString(6));

                MyList.add(p);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return MyList;
    }
public List<Panier> afficherPanierUt(int id ) {
        List<Panier> MyList = new ArrayList<>();
        try {

            String req = "SELECT * FROM paniers"+
                    " WHERE numeroUtilisateur="+id+
                    " ORDER BY nomProduit";
            
            PreparedStatement pst = cnx.prepareStatement(req);
              //pst.setInt(1, id);
            ResultSet rs = pst.executeQuery(req);
            while (rs.next()) {
                Panier p = new Panier();
                p.setNumeroPanier(rs.getInt(1));
                p.setNumeroProduit(rs.getInt(2));
                p.setQuantite(rs.getInt(3));
                p.setDateAjout(rs.getDate(4));
                p.setNumeroUtilisateur(id);
                p.setNomProduit(rs.getString(6));

                MyList.add(p);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return MyList;
    }
public List<Panier> afficherPanierUt(int id , String rech) {
        List<Panier> MyList = new ArrayList<>();
        try {

            String req = "SELECT * FROM paniers"+
                    " WHERE numeroUtilisateur="+id+
                    " And nomProduit Like "+"'"+rech+"%"+"'";
            
            PreparedStatement pst = cnx.prepareStatement(req);
              //pst.setInt(1, id);
            ResultSet rs = pst.executeQuery(req);
            while (rs.next()) {
                Panier p = new Panier();
                p.setNumeroPanier(rs.getInt(1));
                p.setNumeroProduit(rs.getInt(2));
                p.setQuantite(rs.getInt(3));
                p.setDateAjout(rs.getDate(4));
                p.setNumeroUtilisateur(id);
                p.setNomProduit(rs.getString(6));

                MyList.add(p);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return MyList;
    }
}
