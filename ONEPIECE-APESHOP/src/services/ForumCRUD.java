/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
public class ForumCRUD {
    
        Connection cnx2 ; 
    public ForumCRUD (){
        cnx2 = MyConnection.getInstance().getCnx();
    }
    public void ajouterForum(Forum f ){
        try {
            String requete = "INSERT INTO Forums (sujetForum)"
                    + "VALUES (?)";
            PreparedStatement pst = cnx2.prepareStatement(requete);
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
            Statement st = cnx2.createStatement();
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
     public List<String> afficherForumN (){
                    List<String> myList = new ArrayList<>();
        try {
            String requete3 = " SELECT sujetForum FROM forums ";
            Statement st = cnx2.createStatement();
            ResultSet rs= st.executeQuery(requete3);  
            while (rs.next ()){
            String x ;
           
            
            x=rs.getString(1);
            myList.add(x);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList ;
    }
    
    public List<Forum> afficherForumu (){
        List<Forum> myList = new ArrayList<>();
        
        try {
            String requte1 = "SELECT * FROM Forums ";
            Statement st = cnx2.createStatement();
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
    
         public void modiferForum(Forum f,int id) {
        try {
            String req = "update forums set sujetForum = ? where idForum="+id;
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setString(1, f.getSujetForum());
            
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    public void supprimerForum( int  id ) {
           try {
            String req1 = "delete from forums where idForum ="+id;
            PreparedStatement pst = cnx2.prepareStatement(req1);
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }

    
  
}