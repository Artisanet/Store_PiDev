package com.esprit.gui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */

import com.esprit.tests.*;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


/**
 *
 * @author ameni
 */
public class MainClass extends Application {
    
   @Override
   public void start (Stage primaryStage) {
      
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
           URL FxURL = getClass().getResource("Commande.fxml");
           Parent root;
        try {
            root = FXMLLoader.load(FxURL);
            Scene scene = new Scene(root); 
           primaryStage.setScene(scene);
            primaryStage.setTitle("3A22");
            primaryStage.show();
       } catch (IOException ex) {
            alert.setAlertType(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("Adding error");
          alert.setContentText(ex.getMessage());
           
       }
        
        
        /*try {
            
            Parent root = FXMLLoader.load(getClass().getResource("gui/AjouterRemise.fxml"));
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
        }*/




   }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
