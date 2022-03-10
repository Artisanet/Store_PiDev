/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Artisanet.gui;

import Artisanet.models.Produit;
import Artisanet.services.ServiceProduit;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nourb
 */
public class AcceuilProduitController implements Initializable {

    @FXML
    private Button fxBack;
    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    //@FXML
    //private ImageView= insertImg;
    @FXML
    private ComboBox<?> CbCat;
    @FXML
    private TextField tfrechercher;
    @FXML
    private Button insertImg;
    @FXML
    private TableView<Produit> table;
    @FXML
    private TableColumn<Produit, Integer > id_produit;
    @FXML
    private TableColumn<Produit, String> nom_produit;
    @FXML
    private TableColumn<Produit, String> image_produit;
    @FXML
    private TableColumn<Produit, Float > Prix_produit;
    @FXML
    private TableColumn<Produit, Integer > Stock_produit;
    @FXML
    private TableColumn<Produit, String> Description_produit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
       // refreshlist(); 
    }  
   /* ServiceProduit sp =new ServiceProduit();
    ObservableList<Produit> data=FXCollections.observableArrayList();
    public void refreshlist(){
        data.clear();
        try {
            data= FXCollections.observableArrayList(sp.afficherPdt());
        } catch (SQLException ex) {    
        }
    id_produit.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
    nom_produit.setCellValueFactory(new PropertyValueFactory<>("Nom"));
    Prix_produit.setCellValueFactory(new PropertyValueFactory<>("Prix"));
    Description_produit.setCellValueFactory(new PropertyValueFactory<>("Description"));
    Stock_produit.setCellValueFactory(new PropertyValueFactory<>("Stock"));
    table.setItems(data);

    }*/
    int i=0;
    @FXML
    private void ajouterProduit(ActionEvent event) throws SQLException {
        
        int id_produit= i++ ;
        String nom= nom_produit.getText();
        float prix= Float.valueOf(Prix_produit.getText()) ;
        String stock= nom_produit.getText();
        //Stock_produit= Integer.valueOf(Stock_produit.getText()) ;
        String description= Description_produit.getText();
        String icone= image_produit.getText();
       
       /*     FileChooser open = new FileChooser();
        Stage stage = (stage)left_main.getScene().getWindow();
        File file = open.showOpenDialog(stage);
        if (file != null){
        Image icone = new Image(file.toURL().toString(),110,110,false,true) {
            }else{
                    System.out.println("no data exist");}
                
        };*/
       
        
        Produit pdt = new Produit(nom,prix,stock,description);
        ServiceProduit sp= new ServiceProduit();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            try {
            sp.ajouterPdt(pdt);
            alert.setTitle("Le produit est ajouter avec succes");
            
            alert.setHeaderText("Added");
            alert.setContentText("Le produit est ajouter avec succes!");
           } catch (SQLException ex){
           alert.setAlertType(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("Erreur d'ajout!!");
           alert.setContentText(ex.getMessage());
           }
            finally{
            stage.show();
            alert.showAndWait();
            //FXMLLoader loader =new FXMLLoader(getClass().getResource("./List.fxml"));
            new Alert(Alert.AlertType.INFORMATION, "sucess").show();

            }
    }

    private void modifierProduit(Produit pdt) {
        try {
            ServiceProduit sp= new ServiceProduit();
            
            sp.updatePdt(pdt);
        } catch (SQLException ex) {
        }
    }
    @FXML
    private void supprimerProduit(ActionEvent event) {
        try {
            ServiceProduit sp= new ServiceProduit();
            sp.supprimerPdt(0);
        } catch (SQLException ex) {
        }
    }

    @FXML
    private void clear(ActionEvent event) {
        id_produit.setText("");
        nom_produit.setText("");
        Prix_produit.setText("");
        Description_produit.setText("");
        Stock_produit.setText("");
        //Icone_produit.setText("");

    }

    @FXML
    private void modifierProduit(ActionEvent event) {
    } 
    
    
     private Produit rechercher(String nom) throws SQLException {
        Produit p = rechercher(nom);
         return p;
       
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
    root = FXMLLoader.load(getClass().getResource("ListeChoix.fxml"));
            stage= (Stage)((Node)event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void ComboBox(ActionEvent event) {
    
    List<String> list = new ArrayList<>();
        Iterable<String> comboGender = null;
        
        for(String data: comboGender){
            
            list.add(data);
        }
        ObservableList dataList = FXCollections.observableArrayList(list);
        gender.setItems(dataList);
        
    
    }

    @FXML
    private void rechercher(ActionEvent event) {
    }

    @FXML
    private void insertImage(ActionEvent event) {
    }

   /* @FXML
    private void insertImage(ActionEvent event) throws IOException{
        FileChooser open = new FileChooser();
        Stage stage1 = (Stage)left_main.getScene().getWindow();
        File file = open.showOpenDialog(stage1);
        if(file != null){
            String path = file.getAbsolutePath();
            path = path.replace("\\", "\\\\");
            file_path.setText(path);
            Image image = new Image(file.toURI().toString(), 110, 110, false, true) {};
            image_view.setImage(image);
        }else{
            System.out.println("NO DATA EXIST!");
        }
    }*/

    private static class gender {

        private static void setItems(ObservableList dataList) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public gender() {
        }
    }

    private static class file_path {

        private static void setText(String path) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public file_path() {
        }
    }

    private static class image_view {

        public image_view() {
        }
    }
    


}
