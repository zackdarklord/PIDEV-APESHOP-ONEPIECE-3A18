/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author User
 */
public class Forum {
    int idForum;
    private String sujetForum;
    
    public Forum(){
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
