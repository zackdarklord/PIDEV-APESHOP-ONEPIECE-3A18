/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entities.Avis;
import entities.CategorieA;
import entities.Forum;
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
import services.ForumCRUD;

/**
 *
 * @author zakar
 */
public class Page03AController {

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
    ForumCRUD ps = new ForumCRUD();
    public Forum a = new Forum();
    Window window;

    @FXML
    private void ajouter(ActionEvent event) {
        Forum a = new Forum();
        a.setSujetForum(tf_avis.getText());

        ps.ajouterForum(a);
        afficher();
        AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                "Avis ajouté!.");

    }

    @FXML
    private void supprimer(ActionEvent event) {
        Forum aa = (Forum) tableview.getSelectionModel().getSelectedItem();
        tableview.getItems().remove(aa);
        ps.supprimerForum(aa.getIdForum());
        AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                "Forum supprimé!.");
    }

    @FXML
    private void modifier(ActionEvent event) {
        Forum aax = (Forum) tableview.getSelectionModel().getSelectedItem();
        //table_avis.getItems();
        System.out.println(aax);
        tf_avis.setText(aax.getSujetForum());

        a = aax;
        
    }

    @FXML
    private void modifier2(ActionEvent event) {
        a.setSujetForum((tf_avis.getText()));
        System.out.println(a);
        ps.modiferForum(a, a.getIdForum());
        afficher();
        AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                "Forum modifié!.");
    }

    public void afficher() {
        ForumCRUD sp = new ForumCRUD();
        List listCategorie = sp.afficherForum();
        ObservableList list = FXCollections.observableArrayList(listCategorie);
        tableview.setItems(list);

        categorie.setCellValueFactory(new PropertyValueFactory<>("sujetForum"));
    }
}
