/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author zakar
 */
public class Facture {
      private int numeroFacture;
    private String typeLivraison;
    private float prixLivraison;
    private int numeroRegionDestinataire;

    public Facture() {
    }

    public Facture(int numeroFacture, String typeLivraison, int prixLivraison, int numeroRegionDestinataire) {
        this.numeroFacture = numeroFacture;
        this.typeLivraison = typeLivraison;
        this.prixLivraison = prixLivraison;
        this.numeroRegionDestinataire = numeroRegionDestinataire;
    }

    public Facture(String typeLivraison, int prixLivraison, int numeroRegionDestinataire) {
        this.typeLivraison = typeLivraison;
        this.prixLivraison = prixLivraison;
        this.numeroRegionDestinataire = numeroRegionDestinataire;
    }

    public int getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(int numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public String getTypeLivraison() {
        return typeLivraison;
    }

    public void setTypeLivraison(String typeLivraison) {
        this.typeLivraison = typeLivraison;
    }

    public float getPrixLivraison() {
        return prixLivraison;
    }

    public void setPrixLivraison(float prixLivraison) {
        this.prixLivraison = prixLivraison;
    }

    public int getNumeroRegionDestinataire() {
        return numeroRegionDestinataire;
    }

    public void setNumeroRegionDestinataire(int numeroRegionDestinataire) {
        this.numeroRegionDestinataire = numeroRegionDestinataire;
    }

    @Override
    public String toString() {
        return "Facture{" + "numeroFacture=" + numeroFacture + ", typeLivraison=" + typeLivraison + ", prixLivraison=" + prixLivraison + ", numeroRegionDestinataire=" + numeroRegionDestinataire + '}';
    }
}
