/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author zakar
 */
public class Forum {
      private int idForum;
    private String sujetForum;

    public Forum() {
    }

    public Forum(int idForum, String sujetForum) {
        this.idForum = idForum;
        this.sujetForum = sujetForum;
    }

    public Forum(String sujetForum) {
        this.sujetForum = sujetForum;
    }

    public int getIdForum() {
        return idForum;
    }

    public void setIdForum(int idForum) {
        this.idForum = idForum;
    }

    public String getSujetForum() {
        return sujetForum;
    }

    public void setSujetForum(String sujetForum) {
        this.sujetForum = sujetForum;
    }

    @Override
    public String toString() {
        return "Forum{" + "idForum=" + idForum + ", sujetForum=" + sujetForum + '}';
    }
}
