/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author zakar
 */
public class Commande {
      private int numeroCommande;
    private String dateCreation;
    private String dateEnvoi;
    private int numeroUtilisateur;
    private String statut;

    public Commande() {
    }

    public Commande(int numeroCommande, String dateCreation, String dateEnvoi, int numeroUtilisateur, String statut) {
        this.numeroCommande = numeroCommande;
        this.dateCreation = dateCreation;
        this.dateEnvoi = dateEnvoi;
        this.numeroUtilisateur = numeroUtilisateur;
        this.statut = statut;
    }

    public Commande(String dateCreation, String dateEnvoi, int numeroUtilisateur, String statut) {
        this.dateCreation = dateCreation;
        this.dateEnvoi = dateEnvoi;
        this.numeroUtilisateur = numeroUtilisateur;
        this.statut = statut;
    }

    public int getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(String dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public int getNumeroUtilisateur() {
        return numeroUtilisateur;
    }

    public void setNumeroUtilisateur(int numeroUtilisateur) {
        this.numeroUtilisateur = numeroUtilisateur;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Commande{" + "numeroCommande=" + numeroCommande + ", dateCreation=" + dateCreation + ", dateEnvoi=" + dateEnvoi + ", numeroUtilisateur=" + numeroUtilisateur + ", statut=" + statut + '}';
    }
}
