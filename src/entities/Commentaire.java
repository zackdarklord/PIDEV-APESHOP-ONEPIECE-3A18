/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author User
 */
public class Commentaire {
    private int idCommentaire;
    private int numeroUtilisateur;
    private String contenuCommentaire;
    
    
     public Commentaire(){
         
     }

    public Commentaire(int idCommentaire, int numeroUtilisateur, String contenuCommentaire){
        this.idCommentaire = idCommentaire;
        this.numeroUtilisateur = numeroUtilisateur;
        this.contenuCommentaire = contenuCommentaire;
        
    }

    public Commentaire(int numeroUtilisateur, String contenuCommentaire) {
        this.numeroUtilisateur = numeroUtilisateur;
        this.contenuCommentaire = contenuCommentaire;
        
    }


    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public int getNumeroUtilisateur() {
        return numeroUtilisateur;
    }

    public void setNumeroUtilisateur(int numeroUtilisateur) {
        this.numeroUtilisateur = numeroUtilisateur;
    }

    public String getContenuCommentaire() {
        return contenuCommentaire;
    }

    public void setContenuCommentaire(String contenuCommentaire) {
        this.contenuCommentaire = contenuCommentaire;
    }

    

    @Override
    public String toString() {
        return "Commentaire{" + "idCommentaire=" + idCommentaire + ", numeroUtilisateur=" + numeroUtilisateur + ", contenuCommentaire=" + contenuCommentaire + '}';
    }
     
     
     
     
    
}
