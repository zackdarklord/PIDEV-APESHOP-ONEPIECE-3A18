/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author zakar
 */
public class Utilisateur {
    private int numeroUtilisateur;
    private String email;
    private String motDePasse;
    private String dateInscription;
    private String role;
    private String nomClient;
    private String nomAdmin;
    private String adresse;
    private String infoCarteBancaire;
    private int numTel;

    //constructors
    public Utilisateur() {
    }

    public Utilisateur(int numeroUtilisateur, String email, String motDePasse, String dateInscription, String role, String nomClient, String nomAdmin, String adresse, String infoCarteBancaire, int numTel) {
        this.numeroUtilisateur = numeroUtilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateInscription = dateInscription;
        this.role = role;
        this.nomClient = nomClient;
        this.nomAdmin = nomAdmin;
        this.adresse = adresse;
        this.infoCarteBancaire = infoCarteBancaire;
        this.numTel = numTel;
    }

    //simple user
    public Utilisateur(int numeroUtilisateur, String email, String motDePasse, String dateInscription) {
        this.numeroUtilisateur = numeroUtilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateInscription = dateInscription;
        this.role = "user";

    }

    //admin
    public Utilisateur(int numeroUtilisateur, String email, String motDePasse, String dateInscription, String nomAdmin) {
        this.numeroUtilisateur = numeroUtilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateInscription = dateInscription;
        this.role = "admin";
        this.nomAdmin = nomAdmin;

    }
    //client

    public Utilisateur(int numeroUtilisateur, String email, String motDePasse, String dateInscription, String nomClient, String adresse, String infoCarteBancaire, int numTel) {
        this.numeroUtilisateur = numeroUtilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
        this.dateInscription = dateInscription;
        this.role = "client";
        this.nomClient = nomClient;
        this.adresse = adresse;
        this.infoCarteBancaire = infoCarteBancaire;
        this.numTel = numTel;
    }
    // getters

    public int getNumeroUtilisateur() {
        return numeroUtilisateur;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDateInscription() {
        return dateInscription;
    }

    public String getEmail() {
        return email;
    }

    public String getInfoCarteBancaire() {
        return infoCarteBancaire;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public String getNomClient() {
        return nomClient;
    }

    public int getNumTel() {
        return numTel;
    }

    public String getRole() {
        return role;
    }
    //setters

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInfoCarteBancaire(String infoCarteBancaire) {
        this.infoCarteBancaire = infoCarteBancaire;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public void setNumeroUtilisateur(int numeroUtilisateur) {
        this.numeroUtilisateur = numeroUtilisateur;
    }

    public void setRole(String role) {
        this.role = role;
    }
    //to string

    @Override
    public String toString() {
        return "Utilisateur{" + "numeroUtilisateur=" + numeroUtilisateur + ", email=" + email + ", motDePasse=" + motDePasse + ", dateInscription=" + dateInscription + ", role=" + role + ", nomClient=" + nomClient + ", nomAdmin=" + nomAdmin + ", adresse=" + adresse + ", infoCarteBancaire=" + infoCarteBancaire + ", numTel=" + numTel + '}';
    }

    public String toStringU() {
        return "Utilisateur{" + "numeroUtilisateur=" + numeroUtilisateur + ", email=" + email + ", motDePasse=" + motDePasse + ", dateInscription=" + dateInscription + ", role=" + role + '}';
    }

    public String toStringA() {
        return "Utilisateur{" + "numeroUtilisateur=" + numeroUtilisateur + ", email=" + email + ", motDePasse=" + motDePasse + ", dateInscription=" + dateInscription + ", role=" + role + ", nomAdmin=" + nomAdmin + '}';
    }

    public String toStringC() {
        return "Utilisateur{" + "numeroUtilisateur=" + numeroUtilisateur + ", email=" + email + ", motDePasse=" + motDePasse + ", dateInscription=" + dateInscription + ", role=" + role + ", nomClient=" + nomClient + ", adresse=" + adresse + ", infoCarteBancaire=" + infoCarteBancaire + ", numTel=" + numTel + '}';
    }
}
