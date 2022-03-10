/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Produit;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import services.ProduitCRUD;

/**
 *
 * @author Ramesh Godara
 */
public class Page06AController implements Initializable {

    
@FXML
private PieChart pieChart;
    ProduitCRUD prd=new ProduitCRUD();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
     
   
        
         ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Console", 100),
                new PieChart.Data("Jeux Vidéos", 40),
                new PieChart.Data("Accessoires", 20));
            pieChart.setData(pieChartData);
            pieChart.setTitle("ventes");
      
    }
}
