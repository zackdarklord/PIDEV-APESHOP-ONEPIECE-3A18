/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Commentaire;
import entities.Facture;
import entities.Forum;
import entities.Panier;
import entities.Produit;
import entities.Utilisateur;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import services.AvisCRUD;
import services.CommandeCRUD;
import services.CommentaireCRUD;
import services.FactureCRUD;
import services.ForumCRUD;
import services.ProduitCRUD;
import services.panierCRUD;
import services.utilisateurCRUD;
import utils.MyConnection;

/**
 *
 * @author zakar
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        //TEST PANIER
        // MyConnection mc=new MyConnection();
       // Panier p = new Panier (1,3,new Date(System.currentTimeMillis()));
        //Panier p1 = new Panier (1,3,"1-1-2022");
       // panierCRUD prd =new panierCRUD();
       // CommandeCRUD crd =new CommandeCRUD();
        //AvisCRUD ard=new AvisCRUD();
        //ForumCRUD frd=new ForumCRUD();
       // Forum f =new Forum("aaaaaaa");
        //frd.ajouterForum(f);
       // frd.modiferForum(f, 1);
       //frd.supprimerForum(1);
       // System.out.println(frd.afficherForum());
        //prd.ajouterPanier(p);
        //prd.ajouterPanier(p1);
        //prd.modifierPanier(p, 1);
        //prd.supprimerPanier(1); //pas d'affichage d'erreur
        //System.out.println(prd.afficherPanier()); 
        //TEST USERS
        // Utilisateur u= new Utilisateur("zak@gmail.com","kamekaze","1-1-1994");
        //Utilisateur u1= new Utilisateur("zak@gmail.com","kamekaze","1-1-1994","Adminzack");
        // Utilisateur u1= new Utilisateur("zak@gmail.com","kamekaze","1-1-1994","zakaria", "laouina", "155448815", 20164182);
        //utilisateurCRUD urd =new utilisateurCRUD ();
        //Produit p=new Produit("XBOX",6,206,"console");
        //ProduitCRUD prd=new ProduitCRUD();
        //prd.ajouterProduit2(p);
        //System.out.println(prd.afficherProduits());
        //urd.ajouterUser(u1);
        // urd.modifierUser(u1, 1);
        //urd.supprimerUser(1);
       // prd.afficherPanierU(14);
        //System.out.println(prd.afficherPanierU(14));
       // System.out.println(crd.afficherCommandesUnique(14));
        //System.out.println(ard.afficherAvis());
        //System.out.println(urd.afficherUser());
        //CommentaireCRUD crd=new CommentaireCRUD();
        //Commentaire c=new Commentaire(14,"popo",2);
        //crd.ajouterCommentaire(c);
        //crd.modiferCommentaire(c, 2);
        //System.out.println(crd.afficherCommentaires());
        //System.out.println(crd.afficherCommentairesu(0));
        //crd.supprimercommentaire(2);
       // System.out.println(crd.afficherCommentaires());
       //Facture f=new Facture("a domicile",100,24,25);
      // FactureCRUD frd=new FactureCRUD();
      // frd.ajouterFacture2(f);
        //System.out.println(frd.afficherFactures());
        //System.out.println("********************");
        //System.out.println(frd.afficherFacturesu(25));
          /*Document document = new Document();

        try {
            PdfWriter.getInstance(document,
                new FileOutputStream("PDF/HelloWorld1.pdf"));

            document.open();
            document.add(new Paragraph("A Hello World PDF document."));
            document.close(); // no need to close PDFwriter?

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        doHashing("zak123");
        doHashing("zak123");
        

    }
     public static String doHashing(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.update(password.getBytes());

            byte[] resultByteArray = messageDigest.digest();

            StringBuilder sb = new StringBuilder();

            for (byte b : resultByteArray) {
                sb.append(String.format("%02x", b));
            }
            System.out.println(sb.toString());
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

}

