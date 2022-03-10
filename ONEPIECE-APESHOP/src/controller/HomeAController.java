/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entities.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author zakar
 */
public class HomeAController {
    @FXML
    private Label welcome;
    public Utilisateur u= new Utilisateur();
    @FXML
    public void test (){
        System.out.println(u);
        welcome.setText("welcome home  "+u.getNomAdmin());
    }
}
