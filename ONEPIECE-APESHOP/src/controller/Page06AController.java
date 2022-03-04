/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;

/**
 *
 * @author Ramesh Godara
 */
public class Page06AController implements Initializable {

    
@FXML
private PieChart pieChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Console", 13),
                new PieChart.Data("Jeux Vidéos", 25),
                new PieChart.Data("Accessoires", 10));
        pieChart.setData(pieChartData);
        pieChart.setTitle("ventes");
      
    }
}
