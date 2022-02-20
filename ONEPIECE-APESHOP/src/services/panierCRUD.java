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
            String req = "INSERT INTO paniers (numeroProduit,quantite,dateAjout) "
                    + "VALUES (?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getNumeroProduit());
            pst.setInt(2, p.getQuantite());
            pst.setString(3, p.getDateAjout());

            pst.executeUpdate();
            System.out.println("panier ajoute !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void modifierPanier(Panier p, int id) {
        try {
            String req = "UPDATE paniers SET numeroProduit=?,quantite=?,dateAjout=? "
                    + "WHERE numeroPanier=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, p.getNumeroProduit());
            pst.setInt(2, p.getQuantite());
            pst.setString(3, p.getDateAjout());
            pst.setInt(4, id);
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
                p.setDateAjout(rs.getString(4));

                MyList.add(p);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return MyList;
    }

}
