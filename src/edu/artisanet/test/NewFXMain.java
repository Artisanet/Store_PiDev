/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.test;

import java.io.IOException;
import java.net.URL;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Bayrem
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try{
        URL fxURL = getClass().getResource("/edu/artisanet/gui/AdminDashboardFXML.fxml");
        Parent root = FXMLLoader.load(fxURL);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Artisanet");
        primaryStage.setScene(scene);
        primaryStage.show();
        } catch (IOException ex) {
           // Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
           
           ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        launch(args);
     }
    
}
