/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author zakar
 */
public class Avis {
    private int idAvis;
    private String contenuAvis;
    private String nomCategorie;
    private int numeroUtilisateur;

    public Avis() {
    }

    public Avis(int idAvis, String contenuAvis, String nomCategorie, int numeroUtilisateur) {
        this.idAvis = idAvis;
        this.contenuAvis = contenuAvis;
        this.nomCategorie = nomCategorie;
        this.numeroUtilisateur = numeroUtilisateur;
    }

    public Avis(String contenuAvis, String nomCategorie, int numeroUtilisateur) {
        this.contenuAvis = contenuAvis;
        this.nomCategorie = nomCategorie;
        this.numeroUtilisateur = numeroUtilisateur;
    }

    public int getIdAvis() {
        return idAvis;
    }

    public String getContenuAvis() {
        return contenuAvis;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public int getNumeroUtilisateur() {
        return numeroUtilisateur;
    }

    public void setIdAvis(int idAvis) {
        this.idAvis = idAvis;
    }

    public void setContenuAvis(String contenuAvis) {
        this.contenuAvis = contenuAvis;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public void setNumeroUtilisateur(int numeroUtilisateur) {
        this.numeroUtilisateur = numeroUtilisateur;
    }

    @Override
    public String toString() {
        return "Avis{" + "idAvis=" + idAvis + ", contenuAvis=" + contenuAvis + ", nomCategorie=" + nomCategorie + ", numeroUtilisateur=" + numeroUtilisateur + '}';
    }
}
