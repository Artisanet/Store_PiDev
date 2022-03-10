/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Artisanet.gui;

import Artisanet.models.Produit;
import Artisanet.services.ServiceProduit;
import static java.awt.SystemColor.text;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nourb
 */
public class AcceuilProduitCLController implements Initializable {

     // produitTable.setItems(listdata.getproduit());
    //remplir les colonnes
     //fxnom.setCellvalueFactory(cell->cell.getValue().getNomProperty());
    @FXML
    private TextField tfrechercher;
    @FXML
    private Button tfBack;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableView<Produit> table;
    @FXML
    private TableColumn<Produit, Integer> id_produit;
    @FXML
    private TableColumn<Produit, String> image_produit;
    @FXML
    private TableColumn<Produit, String> nom_produit;
    @FXML
    private TableColumn<Produit, String> categorie_produit;
    @FXML
    private TableColumn<Produit, Float> prix_produit;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       refreshlist(); 
    }  
    ServiceProduit sp =new ServiceProduit();
    ObservableList<Produit> data=FXCollections.observableArrayList();
public void refreshlist(){
        data.clear();
        try {
            data= FXCollections.observableArrayList(sp.afficherProduit());
        } catch (SQLException ex) {    
        }
    id_produit.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
     image_produit.setCellValueFactory(new PropertyValueFactory<>("image"));
    nom_produit.setCellValueFactory(new PropertyValueFactory<>("Nom"));
    categorie_produit.setCellValueFactory(new PropertyValueFactory<>("Categorie"));
    prix_produit.setCellValueFactory(new PropertyValueFactory<>("Prix"));
   
    table.setItems(data);

    }

    @FXML
    private void ajouterPanier(ActionEvent event) {
         String req ="Select * from produit where nom=?";
         /*btn.setOnAction(event->{
         Produit pdt= new Produit(nom.getText(),prenom.getText());
         ProduitDao pdao = ProduitDao.getInstance();
         pdao?insert(p):
         })*/
    }

    @FXML
    private void rechercher(ActionEvent event) {
        String rech= tfrechercher.getText();
        ServiceProduit sp= new ServiceProduit();
        sp.findproduittByNom(rech); 
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
    root = FXMLLoader.load(getClass().getResource("ListeChoix.fxml"));
            stage= (Stage)((Node)event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    
}
