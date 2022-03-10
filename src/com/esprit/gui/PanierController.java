/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;


import com.esprit.entities.Commande;
import com.esprit.entities.panier;
import com.esprit.services.CommandeService;
import com.esprit.services.PanierService;
import com.esprit.utils.Connexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author pc doctor
 */
public class PanierController implements Initializable {
    
    @FXML
    private TextField prix_tot;
    @FXML
    private TextField nombre_produit;
    
    @FXML
    private TableColumn<panier, String> libelle;
    @FXML
    private TableColumn<panier, Integer> quantite;
    
    @FXML
    private TableColumn<panier, Float> prix;
    
    @FXML
    private TableView<panier> tab_panier;
    @FXML
    private Button supprimer_produit;
    @FXML
    private Button vider_panier;
    @FXML
    private Button nombre_produits;
    @FXML
    private Button prix_total;
    @FXML
    private Button passer_commande;
    private Label username;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_quantite;
    @FXML
    private TextField txt_prix;
    @FXML
    private TableColumn<panier, Integer> col_num;
    @FXML
    private TextField num;
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       refreshlist();
        
        }
    public void setUser(String u){
        this.username.setText(u);
    }
    int index = -1;
    PanierService ps =new PanierService();
    ObservableList<panier> data=FXCollections.observableArrayList();
 

@FXML
private void ViderPanier(ActionEvent event){


panier p=new panier();
PanierService ps=new PanierService();
Alert alert =new Alert(AlertType.INFORMATION);
try{
ps.ViderPanier(p);
alert.setTitle("Succées");
alert.setHeaderText("Panier Vidé");
alert.setContentText("Panié vidé en succées");
refreshlist();
}
catch (SQLException ex){

alert.setAlertType(AlertType.ERROR);
alert.setTitle("Erreur");
alert.setHeaderText("Panié non vidé");
alert.setContentText(ex.getMessage());
}
finally{
alert.showAndWait();
}}

private void ValiderCommande(ActionEvent event){
Commande c=new Commande();
CommandeService cs=new CommandeService();
Alert alert =new Alert(Alert.AlertType.INFORMATION);
try{
cs.ajouterCommande(c);
alert.setTitle("Succées");
alert.setHeaderText("Panier validé ");
alert.setContentText("Vous pouvez passer à la commande");
}
catch (SQLException ex){

alert.setAlertType(Alert.AlertType.ERROR);
alert.setTitle("Erreur");
alert.setHeaderText("Vous ne pouvez pas passer à la commande ");
alert.setContentText(ex.getMessage());
}
finally{
alert.showAndWait();
}}

@FXML
private void SupprimerPanier(ActionEvent event){
    Connection connexion = Connexion.getInstance().getConnexion();
        String sql="delete from panier where libelle=?";
        try {
            
            PreparedStatement ps = connexion.prepareStatement(sql);
         ps.setString(1,txt_nom.getText());
           ps.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "panier Supprimée");
           refreshlist();
        }
        catch(SQLException ex){}
}
@FXML
    public void getSelected (MouseEvent event){
    index = tab_panier.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    
    txt_nom.setText(libelle.getCellData(index).toString());
    txt_quantite.setText(quantite.getCellData(index).toString());
    txt_prix.setText(prix.getCellData(index).toString());
    num.setText(col_num.getCellData(index).toString());
    }
@FXML
private void ModifierPanier(ActionEvent event){
    
    try{
    Connection connexion = Connexion.getInstance().getConnexion();
    String value1=txt_nom.getText();
    String value2=txt_quantite.getText();
    String value3=txt_prix.getText();
   
   
    String sql="Update panier set quantite='"+value3
            
            
            +"' where prix_produit='"
            +value1+"'" ;
    PreparedStatement ps = connexion.prepareStatement(sql);
    ps.execute();
    JOptionPane.showMessageDialog(null, "panier modifiée avec sucées");
    refreshlist();
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    }
    @FXML    
    public void AjouteProduitPanier (){    
        Connection connexion = Connexion.getInstance().getConnexion();
        String sql = "insert into panier (libelle,quantite,prix_produit,nop)values(?,?,?,?)";
        try {
            PreparedStatement ps = connexion.prepareStatement(sql);
    
            ps.setString(1, txt_nom.getText());
            ps.setString(2, txt_quantite.getText());
            ps.setString(3, txt_prix.getText());
            ps.setString(4, num.getText());
            
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "produit ajouter ajoutée avec sucées");
            refreshlist();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    


@FXML
public int NombreProduit() throws SQLException{
               PanierService ps= new PanierService();
                int nbp= ps.NombreProduit();
                nombre_produit.setText(String.valueOf(NombreProduit()));
                return nbp;
               
            }

@FXML
public float PrixPanier() throws SQLException{
               PanierService ps= new PanierService();
                float total= ps.PrixPanier();
                prix_tot.setText(String.valueOf(PrixPanier()));
                return total;
            }


 
  public void refreshlist(){


        data.clear();
        try {
            data= FXCollections.observableArrayList(ps.afficherPanier());
        } catch (SQLException ex) {
            
        }


        libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        
         prix.setCellValueFactory(new PropertyValueFactory<>("prix_produit"));
         quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
         col_num.setCellValueFactory(new PropertyValueFactory<>("nop"));
        
        tab_panier.setItems(data);

    }
  
@FXML
    public void passer_commande(){
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
                    stage.show();}
}


