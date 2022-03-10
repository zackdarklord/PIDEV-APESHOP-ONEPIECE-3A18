/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entities.Avis;
import entities.CategorieA;
import helper.AlertHelper;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;
import services.CategorieACRUD;
import services.CommandeCRUD;
import services.FactureCRUD;

/**
 *
 * @author zakar
 */
public class Page07AController {

    @FXML
    private TableView<?> tableview;
    @FXML
    private TableColumn<?, ?> categorie;
    @FXML
    private Button btn_ajouter;
    @FXML
    private TextField tf_avis;
    @FXML
    private Button btn_supprimer;
    @FXML
    private Button btn_modifier;
    @FXML
    private Button btn_modifier1;
    CategorieACRUD ps = new CategorieACRUD();
    public CategorieA a = new CategorieA();
    Window window;
   
    @FXML
    private void ajouter(ActionEvent event) {
        CategorieA a = new CategorieA();
        a.setNomCategorie(tf_avis.getText());

        ps.ajouterCategorieA2(a);
        afficher();
        AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                "Avis ajouté!.");

    }

    @FXML
    private void supprimer(ActionEvent event) {
        CategorieA aa = (CategorieA) tableview.getSelectionModel().getSelectedItem();
        tableview.getItems().remove(aa);
        ps.supprimerCategorieA(aa.getIdCategorie());
        AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                "Avis supprimé!.");
    }

    @FXML
    private void modifier(ActionEvent event) {
        CategorieA aax = (CategorieA) tableview.getSelectionModel().getSelectedItem();
        //table_avis.getItems();
        System.out.println(aax);
        tf_avis.setText(aax.getNomCategorie());

        a = aax;
        
    }

    @FXML
    private void modifier2(ActionEvent event) {
        a.setNomCategorie((tf_avis.getText()));
        System.out.println(a);
        ps.modifierCategorieA(a, a.getIdCategorie());
        afficher();
        AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                "Avis modifié!.");
    }

    public void afficher() {
        CategorieACRUD sp = new CategorieACRUD();
        List listCategorie = sp.afficherCategorieA();
        ObservableList list = FXCollections.observableArrayList(listCategorie);
        tableview.setItems(list);

        categorie.setCellValueFactory(new PropertyValueFactory<>("nomCategorie"));
    }
}
