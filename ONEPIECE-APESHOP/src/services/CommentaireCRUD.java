/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Commentaire;
import entities.Forum;
import java.sql.Connection;
import utils.MyConnection;
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
     Connection cnx2 ; 
    public CommentaireCRUD (){
        cnx2 = MyConnection.getInstance().getCnx();
    }
    public void ajouterCommentaire(Commentaire c){
        try {
            String requete2 = "INSERT INTO COMMENTAIRES (contenuCommentaire,idForum,numeroUtilisateur)"
                    + "VALUES (?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setString(1,c.getContenuCommentaire());
            pst.setInt(2,c.getIdForum());
            pst.setInt(3,c.getNumeroUtilisateur());
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
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requte3);
            while(rs.next()){
                Commentaire c = new Commentaire();
                c.setContenuCommentaire(rs.getString("contenuCommentaire"));
                c.setIdForum(rs.getInt("idForum"));
                c.setNumeroUtilisateur(rs.getInt("numeroUtilisateur"));
                 c.setIdCommentaire(rs.getInt("idCommentaire"));
                myList.add(c);
            }
            
         
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return myList;
    }
    public void modiferCommentaire(Commentaire f,int id) {
        try {
            String req = "UPDATE commentaires SET contenuCommentaire=?,idForum=?,numeroUtilisateur=? "
                    + "WHERE idCommentaire="+id;
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setString(1, f.getContenuCommentaire());
            pst.setInt(2, f.getIdForum());
            pst.setInt(3, f.getNumeroUtilisateur());
            
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    public List<Commentaire> afficherCommentairesu (int id){
        List<Commentaire> myList = new ArrayList<>();
        
        try {
            String requte3 = "SELECT * FROM commentaires where idForum="+id;
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requte3);
            while(rs.next()){
                Commentaire c = new Commentaire();
                c.setContenuCommentaire(rs.getString("contenuCommentaire"));
                c.setIdForum(rs.getInt("idForum"));
                c.setNumeroUtilisateur(rs.getInt("numeroUtilisateur"));
                c.setIdCommentaire(rs.getInt("idCommentaire"));
                myList.add(c);
            }
            
         
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return myList;
    }
    
    public void supprimercommentaire( int id ) {
           try {
            String req1 = "delete from commentaires where idCommentaire ="+id;
            PreparedStatement pst =cnx2.prepareStatement(req1);
           
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }
    
    
}