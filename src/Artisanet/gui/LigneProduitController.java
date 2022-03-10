/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Artisanet.gui;

import Artisanet.models.Produit;
import Artisanet.services.ServiceProduit;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author nourb
 */

public class LigneProduitController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tfprix;
    @FXML
    private ImageView image;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    ServiceProduit sp =new ServiceProduit();
   ObservableList<Produit> data=FXCollections.observableArrayList();
    @FXML
    private Button fxBack;
    @FXML
    private TableColumn<Produit, String> nom_produit;
    @FXML
    private TableColumn<Produit, Float> prix_produit;
    @FXML
    private TableColumn<Produit, String> desc_produit;
    @FXML
    private TableView<Produit> table;
  
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
           data= FXCollections.observableArrayList(sp.afficherProduit());
        } catch (SQLException ex) {   
            System.out.println("Erreur");
        }
   // image_produit.setCellValueFactory(new PropertyValueFactory<>("icone"));
    nom_produit.setText("Sac");
    prix_produit.setText("340.000");
    desc_produit.setText("desc de sac");
  //image=URL"sac.jpg";
    table.setItems(data);
    }  

  /*  @FXML
    private void favoris(ActionEvent event) throws IOException{
     try {
            Parent parent = FXMLLoader.load(getClass().getResource("GestionProduit.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
        }
     }*/
  @FXML
    private void back(ActionEvent event)  throws IOException {
    root = FXMLLoader.load(getClass().getResource("GestionProduitV.fxml"));
            stage= (Stage)((Node)event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
  
}
