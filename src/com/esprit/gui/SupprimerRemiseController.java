/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Remise;
import com.esprit.services.CommandeService;
import com.esprit.services.RemiseService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ameni
 */
public class SupprimerRemiseController implements Initializable {

    @FXML
    private Button supprimer;
    @FXML
    private TextField id_remise;
    @FXML
    private Label username;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setUser(String u){
        this.username.setText(u);
    }

    /*@FXML
    private void supprimerRemise(ActionEvent event) {
        ServiceUser us = new ServiceUser();
        Remise r = new Remise();
        String id =id_remise.getText();
        int idint=Integer.parseInt(id);
        
        r.setId_remise(idint);
        us.SupprimerRemise(r);
        
    }*/
     @FXML
    private void supprimerRemise(ActionEvent event){
    Remise r=new Remise();
RemiseService rs=new RemiseService();
Alert alert =new Alert(Alert.AlertType.INFORMATION);
try{
rs.SupprimerRemise(r);
alert.setTitle("Succées");
alert.setHeaderText("Remise supprimée");
alert.setContentText("Remise supprimée avec succés");
}
catch (SQLException ex){

alert.setAlertType(Alert.AlertType.ERROR);
alert.setTitle("Erreur");
alert.setHeaderText("Remise non supprimé");
alert.setContentText(ex.getMessage());
}
finally{
alert.showAndWait();
}}
}
