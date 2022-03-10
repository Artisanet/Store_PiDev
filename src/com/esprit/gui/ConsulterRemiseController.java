/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Remise;
import com.esprit.utils.Connexion;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ameni
 */
public class ConsulterRemiseController implements Initializable {
@FXML
    private Label username;
@FXML
    private TableView<Remise> table_remise;
    @FXML
    private TableColumn<?, ?> id_remise;
    @FXML
    private TableColumn<?, ?> numero_produit;
    @FXML
    private TableColumn<?, ?> pourcentage;
    @FXML
    private TableColumn<?, ?> ancien_prix;
    @FXML
    private TableColumn<?, ?> nouveau_prix;

    /**
     * Initializes the controller class.
     */
    ObservableList<Remise> remises = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       /* InitColumn();
        remises=loadData(remises);
        table_remise.setItems(remises);*/
    }    
    public void setUser(String u){
        this.username.setText(u);
    }
    public void InitColumn(){
           id_remise.setCellValueFactory(new PropertyValueFactory<>("id_remise"));
           numero_produit.setCellValueFactory(new PropertyValueFactory<>("nop"));
           pourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
           ancien_prix.setCellValueFactory(new PropertyValueFactory<>("ancienPrix"));
           nouveau_prix.setCellValueFactory(new PropertyValueFactory<>("nouveauPrix"));
}
     public ObservableList<Remise> loadData(ObservableList<Remise> remises)throws SQLException{
      
               Connexion connexion= Connexion.getInstance();
               String req ="select * from remise";
               Statement s= connexion.getConnexion().createStatement();
               ResultSet rst = s.executeQuery(req);
               while(rst.next()){
                   Remise r = new Remise();
                   r.setId_remise(rst.getInt("id_remise"));
                   r.setNop(rst.getInt("nop"));
                   r.setPourcentage(rst.getFloat("pourcentage"));
                   r.setAncienPrix(rst.getFloat("ancienPrix"));
                   r.setNouveauPrix(rst.getFloat("nouveauPrix"));
                   remises.add(r);
               } 
        return remises;
    }
}
