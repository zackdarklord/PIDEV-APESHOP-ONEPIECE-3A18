/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.Commentaire;
import entities.Forum;
import services.CommentaireCRUD;
import services.forumCRUD;

/**
 *
 * @author User
 */
public class mainclass {
    public static void main(String[] args) {
        CommentaireCRUD pcd =new CommentaireCRUD();
        forumCRUD fcd = new forumCRUD();
        //Myconnection mc = new Myconnection();
        Commentaire c = new Commentaire();
        pcd.ajouterCommentaire(c);
        System.out.println(pcd.afficherCommentaires());
        Forum f = new Forum();
        fcd.ajouterForum(f);
        fcd.modiferForum(f);
        fcd.supprimerForum(f);
        System.out.println(fcd.afficherForum());
        
        
        
        
        
    }
    
}
