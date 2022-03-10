/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ameni
 */
public class FicheRemiseController implements Initializable {

    @FXML
    private Button ajouter_remise;
    @FXML
    private Button supprimer_remise;
    @FXML
    private Button consulter_remise;
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

    @FXML
    private void AjouterRemise(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("AjouterRemise.fxml"));
                    try {
                        loader.load();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    Parent parent = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(parent));
                    stage.show();
    }

    @FXML
    private void SupprimerRemise(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("SupprimerRemise.fxml"));
                    try {
                        loader.load();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    Parent parent = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(parent));
                    stage.show();
        
    }

    @FXML
    private void ConsulterRemise(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("ConsulterRemise.fxml"));
                    try {
                        loader.load();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    Parent parent = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(parent));
                    stage.show();
        
    }
}
