/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author zakar
 */
public class Panier {

    private int numeroPanier;
    private int numeroProduit;
    private int quantite;
    private String dateAjout;

    public Panier() {
    }

    public Panier(int numeroPanier, int numeroProduit, int quantite, String dateAjout) {
        this.numeroPanier = numeroPanier;
        this.numeroProduit = numeroProduit;
        this.quantite = quantite;
        this.dateAjout = dateAjout;
    }

    public Panier(int numeroProduit, int quantite, String dateAjout) {

        this.numeroProduit = numeroProduit;
        this.quantite = quantite;
        this.dateAjout = dateAjout;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public int getNumeroPanier() {
        return numeroPanier;
    }

    public int getNumeroProduit() {
        return numeroProduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    public void setNumeroPanier(int numeroPanier) {
        this.numeroPanier = numeroPanier;
    }

    public void setNumeroProduit(int numeroProduit) {
        this.numeroProduit = numeroProduit;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Panier{" + "numeroPanier=" + numeroPanier + ", numeroProduit=" + numeroProduit + ", quantite=" + quantite + ", dateAjout=" + dateAjout + '}';
    }

}
