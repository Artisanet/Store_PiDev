/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.LigneCommande;
import com.esprit.utils.Connexion;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ameni
 */
public class ConsulterCommande_ArtisanController implements Initializable {

    @FXML
    private TableView<?> tab_commande;
    @FXML
    private TableColumn<?, ?> ligne_commande;
    @FXML
    private TableColumn<?, ?> no_commande;
    @FXML
    private TableColumn<?, ?> numero_commande;
    @FXML
    private TableColumn<?, ?> lieu_livraison;
    @FXML
    private TableColumn<?, ?> prix_total;
    @FXML
    private TableColumn<?, ?> mode_paiement;
    @FXML
    private ImageView imagechange;
    @FXML
    private Label username;
    @FXML
    private Button consulter_commande;
    @FXML
    private Button afficher_satistique;

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
  public ObservableList<LigneCommande> AfficherLigneCommande(ObservableList<LigneCommande> list_lignecommande) throws SQLException{
       
        
            Connexion connexion= Connexion.getInstance();
            String req ="select * from lignecommande";
            Statement s= connexion.getConnexion().createStatement();
            ResultSet rst = s.executeQuery(req);
            while(rst.next()){
               LigneCommande lc = new LigneCommande();
               lc.setNolc(rst.getInt("nolc"));
               lc.setNop(rst.getInt("nocmd"));
               lc.setNop(rst.getInt("nop"));
                lc.setLieuLivr_cmd(rst.getString("lieuLivr_cmd"));
                lc.setModePaiement(rst.getString("modePaiement"));
                lc.setPrixTotal(rst.getFloat("prixTotal"));
               
                list_lignecommande.add(lc);
            }
        return list_lignecommande;
        
    }   
}
