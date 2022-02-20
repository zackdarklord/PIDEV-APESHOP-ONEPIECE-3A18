/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Panier;
import entities.Utilisateur;
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
public class utilisateurCRUD {

    Connection cnx;

    public utilisateurCRUD() {
        cnx = MyConnection.getInstance().getCnx();
    }

    public void ajouterUser(Utilisateur u) {
        try {
            String req = "INSERT INTO utilisateurs (email,motDePasse,dateInscription,role,nomClient,nomAdmin,adresse,infoCarteBancaire,numTel) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(req);

            pst.setString(1, u.getEmail());
            pst.setString(2, u.getMotDePasse());
            pst.setString(3, u.getDateInscription());
            pst.setString(4, u.getRole());
            pst.setString(5, u.getNomClient());
            pst.setString(6, u.getNomAdmin());
            pst.setString(7, u.getAdresse());
            pst.setString(8, u.getInfoCarteBancaire());
            pst.setInt(9, u.getNumTel());

            pst.executeUpdate();
            System.out.println("user ajoute !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void modifierUser(Utilisateur u, int id) {
        try {
            String req = "UPDATE utilisateurs SET email=?,motDePasse=?,dateInscription=?,role=?,nomClient=?,nomAdmin=?,Adresse=?,infoCarteBancaire=?,numTel=? "
                    + "WHERE numeroUtilisateurs=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, u.getEmail());
            pst.setString(2, u.getMotDePasse());
            pst.setString(3, u.getDateInscription());
            pst.setString(4, u.getRole());
            pst.setString(5, u.getNomClient());
            pst.setString(6, u.getNomAdmin());
            pst.setString(7, u.getAdresse());
            pst.setString(8, u.getInfoCarteBancaire());
            pst.setInt(9, u.getNumTel());
            pst.setInt(10, id);
            pst.executeUpdate();
            System.out.println("panier modifie !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void supprimerUser(int id) {
        try {
            String req = "DELETE FROM utilisateurs  "
                    + "WHERE numeroUtilisateurs=?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("user supprime !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Utilisateur> afficherUser() {
        List<Utilisateur> MyList = new ArrayList<>();
        try {

            String req = "SELECT * FROM utilisateurs";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Utilisateur p = new Utilisateur();
                p.setNumeroUtilisateur(rs.getInt(1));
                p.setEmail(rs.getString(2));
                p.setMotDePasse(rs.getString(3));
                p.setDateInscription(rs.getString(4));
                p.setRole(rs.getString(5));
                p.setNomClient(rs.getString(6));
                p.setNomAdmin(rs.getString(7));
                p.setAdresse(rs.getString(8));
                p.setInfoCarteBancaire(rs.getString(9));
                p.setNumTel(rs.getInt(10));

                MyList.add(p);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return MyList;
    }

}
