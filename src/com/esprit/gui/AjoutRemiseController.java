/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Remise;
import com.esprit.services.CommandeService;
import com.esprit.services.RemiseService;
import com.esprit.utils.Connexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author ameni
 */
public class AjoutRemiseController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private Button ajouter;
    @FXML
    private Button supprimer;
    @FXML
    private TextField poucentage;

    String query = null;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    Remise r = null;
    private boolean update;
    int Id_remise;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void save(MouseEvent event) throws SQLException {

        connection = Connexion.getInstance().getConnexion();
        String libelle = nom.getText();
        
        String pourcent = poucentage.getText();
       

        if (libelle.isEmpty() || pourcent.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
            getQuery();
            insert();
            clean();

        }

    }

    @FXML
    private void clean() {
        nom.setText(null);
        
        poucentage.setText(null);
        
        
    }

    private void getQuery() {

        if (update == false) {
            
            query = "INSERT INTO `remise`( `id_remise`, `nop`, `libelle`, `pourcentage`"
                    + ", `ancienPrix`, `nouveauPrix`) VALUES (?,?,?,?,?,?)";

        }else{
            query = "UPDATE `remise` SET "
                    + "`id_remise`=?,"
                    + "`nop`=?,"
                    + "`libelle`=?,"
                    + "`pourcentage`=?,"
                    + "`ancienPrix`=?,"
                    + "`nouveauPrix`= ? WHERE id_remise = '"+Id_remise+"'";
        }

    }

    private void insert() throws SQLException {

        Remise r =new Remise();
RemiseService rs=new RemiseService();

rs.AjouterRemise(r);



    }

    void setTextField(int id_remise,int nop,String libelle,Float pourcentage,float ancienPrix,float nouveauPrix) {
           
        Id_remise = id_remise;
        
        nom.setText(libelle);
        
        

    }

    void setUpdate(boolean b) {
        this.update = b;

    }

    

}
    

