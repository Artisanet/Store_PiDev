/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bayrem
 */
public class AdminDashboardFXMLController implements Initializable {

    @FXML
    private AnchorPane AdminAnchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showNews(MouseEvent event) throws IOException {
           FXMLLoader fx = new FXMLLoader();
           fx.setLocation(getClass().getResource("/edu/artisanet/gui/PageNewsFXML.fxml"));
           AnchorPane ap = fx.load();
           AdminAnchor.getChildren().setAll(ap);
           
//        Parent root = FXMLLoader.load(getClass().getResource("/edu/artisanet/gui/PageNewsFXML.fxml"));
//        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    
    }

    @FXML
    private void showRec(MouseEvent event) throws IOException {
        FXMLLoader fx = new FXMLLoader();
           fx.setLocation(getClass().getResource("/edu/artisanet/gui/AdminRexFXML.fxml"));
           AnchorPane ap = fx.load();
           AdminAnchor.getChildren().setAll(ap);
    }
    
}
