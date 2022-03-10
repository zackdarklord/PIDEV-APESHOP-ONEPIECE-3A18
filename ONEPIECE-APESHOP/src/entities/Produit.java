/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author zakar
 */
public class Produit {
     private int numeroProduit;
    private String nomProduit;
    private int quantite;
    private float prixUnitaire;
    private int idCategorie;

    public Produit() {
    }

    public Produit(int numeroProduit, String nomProduit, int quantite, float prixUnitaire, int idCategorie) {
        this.numeroProduit = numeroProduit;
        this.nomProduit = nomProduit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.idCategorie = idCategorie;
    }

    public Produit(String nomProduit, int quantite, float prixUnitaire, int idCategorie) {
        this.nomProduit = nomProduit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.idCategorie = idCategorie;
    }

    public int getNumeroProduit() {
        return numeroProduit;
    }

    public void setNumeroProduit(int numeroProduit) {
        this.numeroProduit = numeroProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    

    @Override
    public String toString() {
        return "Produit{" + "numeroProduit=" + numeroProduit + ", nomProduit=" + nomProduit + ", quantite=" + quantite + ", prixUnitaire=" + prixUnitaire + ", idCategorie=" + idCategorie + '}';
    }
}
