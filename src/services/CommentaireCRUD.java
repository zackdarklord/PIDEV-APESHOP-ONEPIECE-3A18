/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Commentaire;
import utils.Myconnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class CommentaireCRUD  {
    
    public void ajouterCommentaire(Commentaire c){
        try {
            String requete2 = "INSERT INTO COMMENTAIRES (contenuCommentaire)"
                    + "VALUES (?)";
            PreparedStatement pst = new Myconnection().getcnx().prepareStatement(requete2);
            pst.setString(1,c.getContenuCommentaire());
            pst.executeUpdate();
            System.out.println("votre commentaire a ete ajouté");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Commentaire> afficherCommentaires (){
        List<Commentaire> myList = new ArrayList<>();
        
        try {
            String requte3 = "SELECT * FROM commentaires ";
            Statement st = new Myconnection().getcnx().createStatement();
            ResultSet rs = st.executeQuery(requte3);
            while(rs.next()){
                Commentaire c = new Commentaire();
                c.setContenuCommentaire(rs.getString("contenucommentaire"));
                c.setIdCommentaire(rs.getInt(1));
                myList.add(c);
            }
            
         
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return myList;
    }
    
    public List<Commentaire> afficherCommentairesu (){
        List<Commentaire> myList = new ArrayList<>();
        
        try {
            String requte3 = "SELECT * FROM commentaires ";
            Statement st = new Myconnection().getcnx().createStatement();
            ResultSet rs = st.executeQuery(requte3);
            while(rs.next()){
                Commentaire c = new Commentaire();
                c.setContenuCommentaire(rs.getString("contenucommentaire"));
                myList.add(c);
            }
            
         
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return myList;
    }
    
    public void supprimercommentaire( Commentaire c ) {
           try {
            String req1 = "delete from commentaires where idCommentaire = ?";
            PreparedStatement pst = new Myconnection().getcnx().prepareStatement(req1);
            pst.setInt(1,c.getIdCommentaire());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }
    
    
}
