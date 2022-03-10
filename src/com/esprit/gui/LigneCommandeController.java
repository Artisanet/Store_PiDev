/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Commande;
import com.esprit.entities.LigneCommande;
import com.esprit.services.CommandeService;
import com.esprit.services.LigneCommandeService;
import com.esprit.utils.Connexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ameni
 */
public class LigneCommandeController implements Initializable {
    private Label username;
    @FXML
    private TableView<LigneCommande> tab_lignecommande;
    @FXML
    private TableColumn<LigneCommande, Double> montant;
    
    @FXML
    private TableColumn<LigneCommande, Integer> delai;
    @FXML
    private TableColumn<LigneCommande, Float> prix;
    @FXML
    private TableColumn<LigneCommande, String> mode_paiement;
    @FXML
    private Button supprimer_commande;
    @FXML
    private Button modifier_paiement;
    @FXML
    private TableColumn<LigneCommande, String> lieu;
    @FXML
    private TextField txt_montant;
    @FXML
    private TextField txt_delai;
    @FXML
    private TextField txt_lieu;
    @FXML
    private TextField txt_mode;
    @FXML
    private TextField txt_prix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
refreshlist();
    }
    int index = -1;

   /* private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }  */
    public void setUser(String u){
        this.username.setText(u);
    }
    LigneCommandeService lcs =new LigneCommandeService();
    ObservableList<LigneCommande> data=FXCollections.observableArrayList();
    
    @FXML
private void SupprimerLigneCommande(ActionEvent event){
    Connection connexion = Connexion.getInstance().getConnexion();
        String sql="delete from lignecommande where montant_cmd=?";
        try {
            
            PreparedStatement ps = connexion.prepareStatement(sql);
         ps.setString(1,txt_montant.getText());
           ps.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "ligneCommande Supprimée");
           refreshlist();
        }
        catch(SQLException ex){}
}
@FXML
    public void getSelected (MouseEvent event){
    index = tab_lignecommande.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    
    txt_montant.setText(montant.getCellData(index).toString());
    txt_delai.setText(delai.getCellData(index).toString());
    txt_lieu.setText(lieu.getCellData(index).toString());
    txt_mode.setText(mode_paiement.getCellData(index).toString());
    txt_prix.setText(prix.getCellData(index).toString());
    
    
    
    }
@FXML
private void ModifierLigneCommande(ActionEvent event){
    
    try{
    Connection connexion = Connexion.getInstance().getConnexion();
    String value1=txt_montant.getText();
    String value2=txt_delai.getText();
    String value3=txt_lieu.getText();
    String value4=txt_prix.getText();
    String value5=txt_mode.getText();
   
    String sql="Update lignecommande set lieuLivr_cmd='"+value3
            +"',modePaiement= '"+value5
            +"',delailivr_cmd= '"+value2
            +"' where montant_cmd='"
            +value1+"'" ;
    PreparedStatement ps = connexion.prepareStatement(sql);
    ps.execute();
    JOptionPane.showMessageDialog(null, "ligne commande modifiée avec sucées");
    refreshlist();
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    }
    
    
    
    /*LigneCommande lc=new LigneCommande();
LigneCommandeService lcs=new LigneCommandeService();
Alert alert =new Alert(Alert.AlertType.INFORMATION);
try{
lcs.ModifierLigneCommande(lc);
alert.setTitle("Succées");
alert.setHeaderText("Mode de paiement modifié");
alert.setContentText("Mode de paiement est modifié avec succés");}
catch (SQLException ex){

alert.setAlertType(Alert.AlertType.ERROR);
alert.setTitle("Erreur");
alert.setHeaderText("Mode de paiement non modifié");
alert.setContentText(ex.getMessage());
}
finally{
alert.showAndWait();
}*/
public void AjouteLignerCommande (){    
        Connection connexion = Connexion.getInstance().getConnexion();
        String sql = "insert into lignecommande (montant_cmd,delaiLivr_cmd,lieuLivr_cmd,prixTotal,modePaiement)values(?,?,?,?,?)";
        try {
            PreparedStatement ps = connexion.prepareStatement(sql);
    
            ps.setString(1, txt_montant.getText());
            ps.setString(2, txt_delai.getText());
            ps.setString(3, txt_lieu.getText());
            ps.setString(4, txt_prix.getText());
            ps.setString(5, txt_mode.getText());
            
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "ligne commande ajoutée avec sucées");
            refreshlist();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
public void refreshlist(){


        data.clear();
        try {
            data= FXCollections.observableArrayList(lcs.afficherLigneCommande());
        } catch (SQLException ex) {
            
        }


        montant.setCellValueFactory(new PropertyValueFactory<>("montant_cmd"));
        delai.setCellValueFactory(new PropertyValueFactory<>("delaiLivr_cmd"));
        lieu.setCellValueFactory(new PropertyValueFactory<>("lieuLivr_cmd"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prixTotal"));
         mode_paiement.setCellValueFactory(new PropertyValueFactory<>("modePaiement"));
        
        tab_lignecommande.setItems(data);

}
    @FXML
    public void retour(){
FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("Commande.fxml"));
                    try {
                        loader.load();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                    Parent parent = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(parent));
                    stage.show();}}
