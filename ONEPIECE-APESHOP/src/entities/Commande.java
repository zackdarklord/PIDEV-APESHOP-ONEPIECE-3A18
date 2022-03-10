/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Date;

/**
 *
 * @author zakar
 */
public class Commande {
      private int numeroCommande;
    private Date dateCreation;
    private Date dateEnvoi;
    private int numeroUtilisateur;
    private String statut;

    public Commande() {
    }

    public Commande(int numeroCommande, Date dateCreation, Date dateEnvoi, int numeroUtilisateur, String statut) {
        this.numeroCommande = numeroCommande;
        this.dateCreation = dateCreation;
        this.dateEnvoi = dateEnvoi;
        this.numeroUtilisateur = numeroUtilisateur;
        this.statut = statut;
    }

    public Commande(Date dateCreation, Date dateEnvoi, int numeroUtilisateur, String statut) {
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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
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
