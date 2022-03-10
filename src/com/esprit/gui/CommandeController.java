/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Commande;
import com.esprit.entities.LigneCommande;
import com.esprit.entities.panier;
import com.esprit.services.CommandeService;
import com.esprit.services.LigneCommandeService;
import com.esprit.services.PanierService;
import com.esprit.utils.Connexion;
import com.esprit.utils.Helper;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author ameni
 */
public class CommandeController implements Initializable {

    @FXML
    private TableView<Commande> tvcommande;
    @FXML
    private TableColumn<Commande,Date> coldate;
    
    @FXML
    private Button btnsupprimercommande;
    @FXML
    private Button btnmodifiercommande;
    @FXML
    private Button valider_commande;
    private Label username;
    private TextField supp;
    
   
    @FXML
    private TextField datecommande;
    private Label Total;
    @FXML
    private Button imprimer;
    @FXML
    private TableColumn<Commande, Integer> col_numero;
    @FXML
    private TableColumn<Commande, String> col_adresse;
    @FXML
    private TableColumn<Commande,String> col_statut;
    @FXML
    private TableColumn<Commande, Float> col_prix;
    @FXML
    private TextField prix;
    @FXML
    private TextField statut;
    @FXML
    private TextField adresse;
    @FXML
    private TextField numero;
    @FXML
    private TextField total;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        refreshlist();
        
        
    }    
    public void setUser(String u){
        this.username.setText(u);
    }
    int index = -1;
    CommandeService cs =new CommandeService();
    ObservableList<Commande> list=FXCollections.observableArrayList();
    Commande c=new Commande();
    
    
    @FXML
    public void AjouterCommande (){    
        Connection connexion = Connexion.getInstance().getConnexion();
        String sql = "insert into command (date_commande,statut,adresse,prix)values(?,?,?,?)";
        try {
            PreparedStatement ps = connexion.prepareStatement(sql);
    
            ps.setString(1, datecommande.getText());
            ps.setString(2, statut.getText());
            ps.setString(3, adresse.getText());
            ps.setString(4, prix.getText());
            
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "commande ajoutée avec sucées");
            refreshlist();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
@FXML
    public void getSelected (MouseEvent event){
    index = tvcommande.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    
     datecommande.setText(coldate.getCellData(index).toString());
     numero.setText(col_numero.getCellData(index).toString());
     adresse.setText(col_adresse.getCellData(index).toString());
      statut.setText(col_statut.getCellData(index).toString());
       prix.setText(col_prix.getCellData(index).toString());
  
    }
@FXML
private void ModfierCommande(ActionEvent event){
    try{
    Connection connexion = Connexion.getInstance().getConnexion();
    //String value1=numclient.getText();
    //String value2=numproduit.getText();
    String value1=datecommande.getText();
    String value2=adresse.getText();
    String value3=statut.getText();
    String value4=prix.getText();
    String sql="Update command set adresse='"+value2
            +"',statut='"+value3
            +"',date_commande='"+value1
            +"' where prix='"+value4+"'" ;
    PreparedStatement ps = connexion.prepareStatement(sql);
    ps.execute();
    
    JOptionPane.showMessageDialog(null, "commande modifiée avec sucées");
            refreshlist();
            
        
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    }
    


/*@FXML
private void Passer_ala_Commande(ActionEvent event) throws IOException{
    
                try {
            Parent parent = FXMLLoader.load(getClass().getResource("LigneCommande.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RemiseController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
                }*/

public void refreshlist(){


        list.clear();
        try {
            list= FXCollections.observableArrayList(cs.afficherCommande());
        } catch (SQLException ex) {
            
        }

        coldate.setCellValueFactory(new PropertyValueFactory<>("date_commande"));
        col_numero.setCellValueFactory(new PropertyValueFactory<>("id_commande"));
        col_statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        
        
        tvcommande.setItems(list);

    }
@FXML
    private void delete(ActionEvent event)throws SQLException {
        Connection connexion = Connexion.getInstance().getConnexion();
        String sql="delete from command where date_commande=?";
        try {
            
            PreparedStatement ps = connexion.prepareStatement(sql);
         ps.setString(1,datecommande.getText());
           ps.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Commande Supprimée");
           refreshlist();
        }
        catch(SQLException ex){}
           
    }
@FXML
    public void export(ActionEvent event) throws IOException, SQLException {

      // File file = new File(System.getProperty("user.home") + "/Desktop/raport.csv");
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Csv files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
     File file = fileChooser.showSaveDialog(prix.getScene().getWindow());

        if (file != null) {


            
                // create FileWriter object with file as parameter
                FileWriter outputfile = new FileWriter(file);

                // create CSVWriter object filewriter object as parameter
                CSVWriter writer = new CSVWriter(outputfile);

                // adding header to csv
           String[] header = { "Datecmd","Adresse","Statut" };
                writer.writeNext(header);

               cs.afficherCommande();
               list.forEach((data) -> {
                   String donnes[] = {data.getDate_commande()+"", data.getAdresse()+"", data.getStatut()+""};
                  writer.writeNext(donnes);
         });

                writer.close();
                Helper.Alert("Fichier Sauvegardé avec succées ");
           
        
    }
    }
    private String total(ObservableList<Commande> list){
        AtomicReference<Double> t= new AtomicReference<>(0.0);
        list.forEach((tvcommande) -> {
          t.updateAndGet(v -> v + tvcommande.getPrix());
         });
        return t+"";
    }
/*@FXML
     private String total(ObservableList<Commande> list){
        AtomicReference<Double> t= new AtomicReference<>(0.0);
        list.forEach((tvcommande) -> {
           t.updateAndGet(v -> v + tvcommande.getPrix());
         });
        return t+"";
    }*/
    @FXML
    private void ModfierCommande(KeyEvent event) {
    }

    @FXML
    private void Passer_ala_Commande(ActionEvent event) {
    }

    @FXML
    private void total(ActionEvent event) {
    }

    
}

