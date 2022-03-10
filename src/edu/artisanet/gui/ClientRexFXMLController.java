/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import edu.artisanet.entities.Reclamation;
import edu.artisanet.service.JavaMailAPI;
import edu.artisanet.service.ReclamationCrud;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Bayrem
 */
public class ClientRexFXMLController implements Initializable {

    @FXML
    private TableView<Reclamation> RecTable;
    @FXML
    private TableColumn<?, ?> titreCol;
    @FXML
    private TableColumn<?, ?> conCol;
    @FXML
    private TableColumn<?, ?> dateCol;
    @FXML
    private TableColumn<?, ?> statusCol;
    @FXML
    private JFXButton updateButton;
    @FXML
    private JFXButton deleteButton;
    @FXML
    private JFXTextField areaTitle;
    @FXML
    private JFXTextArea areaCon;
    
    ObservableList<Reclamation> RecList = FXCollections.observableArrayList();
    
    
    
    private Reclamation catItem; 
    private int id;


    /**
     * Initializes the controller class.
     */
    
    private void refreshTable() {
        try {
            RecList.clear();
            ReclamationCrud ccrud = new ReclamationCrud();

            List<Reclamation> Newss = ccrud.getALL();
            RecList.setAll(Newss);
            RecTable.setItems(RecList);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void loadData() {
        refreshTable();

        titreCol.setCellValueFactory(new PropertyValueFactory<>("nom_rec"));
        conCol.setCellValueFactory(new PropertyValueFactory<>("text_rec"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date_rec"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status_rec"));
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }    

    @FXML
    private void Select(MouseEvent event) {
        catItem = RecTable.getSelectionModel().getSelectedItem();
        areaTitle.setText(catItem.getNom_rec());
        areaCon.setText(catItem.getText_rec());
        id = catItem.getId_rec();
    }

    @FXML
    private void Update(ActionEvent event) throws SQLException, Exception {
        Calendar c = Calendar.getInstance();
        Date d = new Date(c.getTime().getTime());
        
            if(!(areaTitle.getText().matches("^[a-z]*$")) && !(areaTitle.getText().matches("^[A-Z]*$"))) 
            {
              Alert alert = new Alert(Alert.AlertType.ERROR);
              
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid Title!");
                alert.showAndWait();
                
                
            }
        if(areaTitle.getText().isEmpty() | areaCon.getText().isEmpty() == true){
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Blank field detected, please write your name and comment");
                alert.showAndWait();
        }
        else {
        Reclamation rec = new Reclamation(areaTitle.getText(),areaCon.getText(),d,"Not Solved");
        ReclamationCrud r = new ReclamationCrud();
        r.add(rec);
        refreshTable();
        JavaMailAPI.sendMail("mohamedbayrem.gharbi@esprit.tn");
        }
    }

    @FXML
    private void Delete(ActionEvent event) throws SQLException {
        ReclamationCrud r = new ReclamationCrud();
        r.delete(id);
        refreshTable();
    }
    
}
