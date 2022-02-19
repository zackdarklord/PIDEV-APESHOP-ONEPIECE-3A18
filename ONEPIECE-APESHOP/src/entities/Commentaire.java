/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author zakar
 */
public class Commentaire {
     private int idCommentaire;
    private int numeroUtilisateur;
    private String contenuCommentaire;
    private int idForum;

    public Commentaire() {

    }

    public Commentaire(int idCommentaire, int numeroUtilisateur, String contenuCommentaire, int idForum) {
        this.idCommentaire = idCommentaire;
        this.numeroUtilisateur = numeroUtilisateur;
        this.contenuCommentaire = contenuCommentaire;
        this.idForum = idForum;
    }

    public Commentaire(int numeroUtilisateur, String contenuCommentaire, int idForum) {
        this.numeroUtilisateur = numeroUtilisateur;
        this.contenuCommentaire = contenuCommentaire;
        this.idForum = idForum;
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

    public int getIdForum() {
        return idForum;
    }

    public void setIdForum(int idForum) {
        this.idForum = idForum;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "idCommentaire=" + idCommentaire + ", numeroUtilisateur=" + numeroUtilisateur + ", contenuCommentaire=" + contenuCommentaire + ", idForum=" + idForum + '}';
    }
}
