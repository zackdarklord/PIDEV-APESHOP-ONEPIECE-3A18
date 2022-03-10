/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Forum;
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
public class forumCRUD {
    
    
    public void ajouterForum(Forum f ){
        try {
            String requete = "INSERT INTO Forums (sujetForum)"
                    + "VALUES (?)";
            PreparedStatement pst = new Myconnection().getcnx().prepareStatement(requete);
            pst.setString(1,f.getSujetForum());
            pst.executeUpdate();
            System.out.println("votre forum a été ajouté");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
 
    
    public List<Forum> afficherForum (){
        List<Forum> myList = new ArrayList<>();
        
        try {
            String requte1 = "SELECT * FROM Forums ";
            Statement st = new Myconnection().getcnx().createStatement();
            ResultSet rs = st.executeQuery(requte1);
            while(rs.next()){
                Forum f = new Forum();
                f.setIdForum(rs.getInt("idForum"));
                f.setSujetForum(rs.getString("sujetForum"));
                myList.add(f);
            }
            
         
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return myList;
    }
    
    public List<Forum> afficherForumu (){
        List<Forum> myList = new ArrayList<>();
        
        try {
            String requte1 = "SELECT * FROM Forums ";
            Statement st = new Myconnection().getcnx().createStatement();
            ResultSet rs = st.executeQuery(requte1);
            while(rs.next()){
                Forum f = new Forum();
                f.setSujetForum(rs.getString("sujetForum"));
                myList.add(f);
            }
            
         
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return myList;
    }
    
         public void modiferForum(Forum f) {
        try {
            String req = "update forums set sujetForum = ?,idForum=? ";
            PreparedStatement pst = new Myconnection().getcnx().prepareStatement(req);
            pst.setString(1, f.getSujetForum());
            pst.setInt(2,f.getIdForum());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    public void supprimerForum( Forum f ) {
           try {
            String req1 = "delete from forums where sujetForum = ?";
            PreparedStatement pst = new Myconnection().getcnx().prepareStatement(req1);
            pst.setString(1,f.getSujetForum());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }

    
  
}
