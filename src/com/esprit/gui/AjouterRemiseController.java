/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Remise;
import com.esprit.services.NotificationAPI;
import com.esprit.services.RemiseService;
import com.esprit.utils.Connexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ameni
 */
public class AjouterRemiseController implements Initializable {

    @FXML
    private TextField tfproduit;
    @FXML
    private TextField tfpourcentage;
    private Label username;
    @FXML
    private TextField tfancien;
    @FXML
    private TextField tfnouveau;
    @FXML
    private TextField tfnop;
    @FXML
    private TableColumn<Remise, String> colnom;
    @FXML
    private TableColumn<Remise, String> colpourcentage;
    @FXML
    private TableColumn<Remise, String> colancien;
    @FXML
    private TableColumn<Remise, String> colnouveau;
    @FXML
    private TableView<Remise> table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshlist();
    }    
     public void setUser(String u)
    {
        this.username.setText(u);
    }
     int index=-1;
     RemiseService rs=new RemiseService();
    ObservableList<Remise> data=FXCollections.observableArrayList();
    @FXML
    private void ajouterRemise(ActionEvent event) throws SQLException {
        /*RemiseService su = new RemiseService();
        Remise r = new Remise();
        String nop =tfproduit.getText();
        String pourcentage =tfpourcentage.getText();
        String ancienPrix =tfancien.getText();
        float floatval1 = Float.valueOf(pourcentage).floatValue();
        float floatval2 = Float.valueOf(ancienPrix).floatValue();
        int idint=Integer.parseInt(nop);
        r.setNop(idint);
        r.setPourcentage(floatval1);
        r.setAncienPrix(floatval2);
        su.AjouterRemise(r);*/
        Connection connexion = Connexion.getInstance().getConnexion();
        String req ="Insert into remise(id_remise,libelle,pourcentage,ancienPrix,nouveauPrix) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setString(1, tfnop.getText());
            ps.setString(1, tfproduit.getText());
            ps.setString(2, tfpourcentage.getText());
            ps.setString(3, tfancien.getText());
            ps.setString(4, tfnouveau.getText());
            
            
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "remise ajoutée avec sucées");
      //      refreshlist();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
           
     @FXML
    public void getSelected (MouseEvent event){
    index = table.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    tfproduit.setText(colnom.getCellData(index).toString());
    tfpourcentage.setText(colpourcentage.getCellData(index).toString());
    tfancien.setText(colancien.getCellData(index).toString());
    tfnouveau.setText(colnouveau.getCellData(index).toString());
    
    
    }
    
@FXML
private void ModfierRemise(ActionEvent event){
    try{
    Connection connexion = Connexion.getInstance().getConnexion();
    String value1=tfproduit.getText();
     String value2=tfpourcentage.getText();
    String value3=tfancien.getText();
     String value4=tfnouveau.getText();
    String sql="Update remise set pourcentage='"+value2
             
            +"' where libelle='"+value1+"'" ;
    PreparedStatement ps = connexion.prepareStatement(sql);
    ps.execute();
    refreshlist();
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    }
    


public void refreshlist(){
         data.clear();
        try {
            data= FXCollections.observableArrayList(rs.afficherRemise());
        } catch (SQLException ex) {
            
        }

        colnom.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        colpourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
        colancien.setCellValueFactory(new PropertyValueFactory<>("ancienPrix"));
        colnouveau.setCellValueFactory(new PropertyValueFactory<>("nouveauPrix"));
          table.setItems(data);

    }
@FXML
    private void delete(ActionEvent event)throws SQLException {
        Connection connexion = Connexion.getInstance().getConnexion();
        String sql="delete from remise where libelle=?";
        try {
            
            PreparedStatement ps = connexion.prepareStatement(sql);
         ps.setString(1,tfproduit.getText());
           ps.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "remise Supprimée");
           refreshlist();
        }
        catch(SQLException ex){}
           
    }
    }
