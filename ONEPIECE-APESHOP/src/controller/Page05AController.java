/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Utilisateur;
import helper.AlertHelper;
import static java.awt.SystemColor.window;
import services.utilisateurCRUD;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import javax.mail.FetchProfile.Item;

/**
 *
 * @author Ramesh Godara
 */
public class Page05AController implements Initializable {
 @FXML
    private AnchorPane pane;
    @FXML
    private TableView<Utilisateur> tableview;
    @FXML
    private TableColumn<Utilisateur, Integer> ID;
    @FXML
    private TableColumn<Utilisateur, String> email;
    @FXML
    private TableColumn<Utilisateur, String> password;
    @FXML
    private TableColumn<Utilisateur, Date> date_insc;
    @FXML
    private TableColumn<Utilisateur, String> role;
    @FXML
    private TableColumn<Utilisateur, String> username_c;
    @FXML
    private TableColumn<Utilisateur, String> username_a;
    @FXML
    private TableColumn<Utilisateur, String> adresse;
    @FXML
    private TableColumn<Utilisateur, Integer> carte_bancaire;
    @FXML
    private TableColumn<Utilisateur, Integer> num_tel;
    @FXML
    private Button supp_btn;
    Window window;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
    utilisateurCRUD urd=new utilisateurCRUD();
        List <Utilisateur> myList = urd.afficherUser();
        ObservableList list = FXCollections.observableArrayList(myList);
        tableview.setItems(list);
        ID.setCellValueFactory(new PropertyValueFactory<>("numeroUtilisateur"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        password.setCellValueFactory(new PropertyValueFactory<>("motDePasse"));
        date_insc.setCellValueFactory(new PropertyValueFactory<>("dateInscription"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        username_c.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
        username_a.setCellValueFactory(new PropertyValueFactory<>("nomAdmin"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        carte_bancaire.setCellValueFactory(new PropertyValueFactory<>("infoCarteBancaire"));
        num_tel.setCellValueFactory(new PropertyValueFactory<>("numTel"));
    }
    
      @FXML
    private void delete() throws Exception {
    int selectedIndex = tableview.getSelectionModel().getSelectedIndex();
    TablePosition idUser= tableview.getSelectionModel().getSelectedCells().get(0);
    int id =idUser.getRow();
    // Item here is the table view type:
     Utilisateur item = tableview.getItems().get(id);
     utilisateurCRUD urd =new utilisateurCRUD();
     urd.supprimerUser(item.getNumeroUtilisateur());
    tableview.getItems().remove(selectedIndex);
     AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "SUCESS",
                    "user supprimé!.");
     actualiser();
    }
   private void actualiser()  {
    utilisateurCRUD urd=new utilisateurCRUD();
        List <Utilisateur> myList = urd.afficherUser();
        ObservableList list = FXCollections.observableArrayList(myList);
        tableview.setItems(list);
        ID.setCellValueFactory(new PropertyValueFactory<>("numeroUtilisateur"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        password.setCellValueFactory(new PropertyValueFactory<>("motDePasse"));
        date_insc.setCellValueFactory(new PropertyValueFactory<>("dateInscription"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        username_c.setCellValueFactory(new PropertyValueFactory<>("nomClient"));
        username_a.setCellValueFactory(new PropertyValueFactory<>("nomAdmin"));
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        carte_bancaire.setCellValueFactory(new PropertyValueFactory<>("infoCarteBancaire"));
        num_tel.setCellValueFactory(new PropertyValueFactory<>("numTel"));
   }
}
