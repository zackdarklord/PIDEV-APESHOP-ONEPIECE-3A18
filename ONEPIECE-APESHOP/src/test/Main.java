/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import entities.Panier;
import entities.Utilisateur;
import java.sql.Date;
import services.panierCRUD;
import services.utilisateurCRUD;
import utils.MyConnection;

/**
 *
 * @author zakar
 */
public class Main {

    public static void main(String[] args) {
        //TEST PANIER
        // MyConnection mc=new MyConnection();
       // Panier p = new Panier (1,3,new Date(System.currentTimeMillis()));
        //Panier p1 = new Panier (1,3,"1-1-2022");
        //panierCRUD prd =new panierCRUD();
        //prd.ajouterPanier(p);
        //prd.ajouterPanier(p1);
        //prd.modifierPanier(p, 1);
        //prd.supprimerPanier(1); //pas d'affichage d'erreur
        //System.out.println(prd.afficherPanier()); 
        //TEST USERS
        // Utilisateur u= new Utilisateur("zak@gmail.com","kamekaze","1-1-1994");
        //Utilisateur u1= new Utilisateur("zak@gmail.com","kamekaze","1-1-1994","Adminzack");
        // Utilisateur u1= new Utilisateur("zak@gmail.com","kamekaze","1-1-1994","zakaria", "laouina", "155448815", 20164182);
        utilisateurCRUD urd =new utilisateurCRUD ();
        //urd.ajouterUser(u1);
        // urd.modifierUser(u1, 1);
        //urd.supprimerUser(1);

        System.out.println(urd.afficherUser());
    }
}
