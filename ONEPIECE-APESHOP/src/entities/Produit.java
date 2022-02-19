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
    private String nomCategorie;

    public Produit() {
    }

    public Produit(int numeroProduit, String nomProduit, int quantite, float prixUnitaire, String nomCategorie) {
        this.numeroProduit = numeroProduit;
        this.nomProduit = nomProduit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.nomCategorie = nomCategorie;
    }

    public Produit(String nomProduit, int quantite, float prixUnitaire, String nomCategorie) {
        this.nomProduit = nomProduit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.nomCategorie = nomCategorie;
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

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    @Override
    public String toString() {
        return "Produit{" + "numeroProduit=" + numeroProduit + ", nomProduit=" + nomProduit + ", quantite=" + quantite + ", prixUnitaire=" + prixUnitaire + ", nomCategorie=" + nomCategorie + '}';
    }
}
