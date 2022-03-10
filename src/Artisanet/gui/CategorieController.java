/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Artisanet.gui;

import Artisanet.models.Categorie;
import Artisanet.models.Produit;
import Artisanet.services.ServiceCategorie;
import Artisanet.services.ServiceProduit;
import Artisanet.utils.MyConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author nourb
 */
public class CategorieController implements Initializable {
  
    @FXML
    private ImageView fxBack;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    ServiceCategorie sp =new ServiceCategorie();
    ObservableList<Categorie> data=FXCollections.observableArrayList();
    @FXML
    private TableView<Categorie> table1;
    @FXML
    private TextField tfnom;
    @FXML
    private TableColumn<Categorie, Integer> id_cat;
    @FXML
    private TableColumn<Categorie, String> nom_cat;
    @FXML
    private TextField tfid;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshlist();
    }    
    public void refreshlist() {
        data.clear();
        try {
            data = FXCollections.observableArrayList(sp.afficherCategorie());
        } catch (SQLException ex) {
            System.out.println("Erreur");
        }
        id_cat.setCellValueFactory(new PropertyValueFactory<>("id_cat"));
        nom_cat.setCellValueFactory(new PropertyValueFactory<>("nom_cat"));
        table1.setItems(data);
    }/*data.clear(); 
        try {
           data= FXCollections.observableArrayList(sp.afficherProduit());
        } catch (SQLException ex) {   
            System.out.println("Erreur");}
    id_produit.setCellValueFactory(new PropertyValueFactory<>("id_pdt"));
    image_produit.setCellValueFactory(new PropertyValueFactory<>("icone"));
    nom_produit.setCellValueFactory(new PropertyValueFactory<>("nom_pdt"));
    prix_produit.setCellValueFactory(new PropertyValueFactory<>("prix"));
    cat_produit.setCellValueFactory(new PropertyValueFactory<>("description"));
    
    table.setItems(data);
    }*/
    @FXML
    private void ajouterCat(ActionEvent event) throws SQLException {
       String nom= tfnom.getText();
       
        Categorie cat = new Categorie(nom);
        ServiceCategorie sp= new ServiceCategorie();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            try {
            sp.ajouterCat(cat);
            /*tfnom.setText("");
            refreshlist();*/
           } catch (SQLException ex){
           alert.setAlertType(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("Erreur d'ajout!!");
           alert.setContentText(ex.getMessage());
           }
            
    }

    private void back(ActionEvent event) throws IOException {
    root = FXMLLoader.load(getClass().getResource("ListeChoix.fxml"));
            stage= (Stage)((Node)event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
    
    }

    @FXML
    private void SupprimerCat(ActionEvent event)throws SQLException  {
    Connection connexion = MyConnexion.getInstance().getCnx();        
String sql="delete from categorie where id_cat=?";
        try {
         PreparedStatement ps = connexion.prepareStatement(sql);
         ps.setString(1,id_cat.getText());
           ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Categorie Supprimée");
           refreshlist();
        }
        catch(SQLException ex){} 
    }


    @FXML
    private void modifierCat(ActionEvent event)throws SQLException  {
     try{
Connection connexion = MyConnexion.getInstance().getCnx();
    String value2=nom_cat.getText();
    String sql="Update categorie set nom_pdt='"+value2+"''" ;
    PreparedStatement ps = connexion.prepareStatement(sql);
    ps.execute();
    JOptionPane.showMessageDialog(null, "categorie modifiée avec sucées");
            refreshlist();}
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }}

    @FXML
    private void back(MouseEvent event)throws IOException {
    root = FXMLLoader.load(getClass().getResource("ListeChoix.fxml"));
            stage= (Stage)((Node)event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
    
    }
    
}
