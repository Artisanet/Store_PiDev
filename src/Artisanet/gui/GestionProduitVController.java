/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Artisanet.gui;

import Artisanet.models.Produit;
import Artisanet.services.ServiceProduit;
import Artisanet.utils.MyConnexion;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.management.Notification;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author nourb
 */
public class GestionProduitVController implements Initializable {
  

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button fxBack;
    @FXML
    private TableView<Produit> table;
    @FXML
    private TableColumn<Produit, String> id_produit;
    @FXML
    private TableColumn<Produit, String> image_produit;
    @FXML
    private TableColumn<Produit, String> nom_produit;
    @FXML
    private TableColumn<Produit, String> prix_produit;
    @FXML
    private TableColumn<Produit, String> cat_produit;
    
    @FXML
    private TextField tfid;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfstock;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tfprix;
    @FXML
    private Button btn_ajout;
    @FXML
    private Button btn_modifier;
    @FXML
    private Button btn_Supprimer;
    @FXML
    private Button btn_annuler;
    @FXML
    private ComboBox cbcat;
    @FXML
    private ImageView image;
    
    /**
     * Initializes the controller class.
     */
   ServiceProduit sp =new ServiceProduit();
   ObservableList<Produit> data=FXCollections.observableArrayList();
    @FXML
    private TextField tficone;
    private Produit clic;
    @FXML
    private DatePicker date;
    @FXML
    private TextField tfrechercher;
      @FXML
    private void selectCat(ActionEvent event) {
    String s= cbcat.getSelectionModel().getSelectedItem().toString();
    cat_produit.setText(s);}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list= FXCollections.observableArrayList("Accessoires","Vetements","Sac","Portefeuille");
        cbcat.setItems(list);
        refreshlist();
      }
    public void refreshlist() {
    data.clear(); 
        try {
           data= FXCollections.observableArrayList(sp.afficherProduit());
        } catch (SQLException ex) {   
            System.out.println("Erreur");
        }
    id_produit.setCellValueFactory(new PropertyValueFactory<>("id_pdt"));
    image_produit.setCellValueFactory(new PropertyValueFactory<>("icone"));
    nom_produit.setCellValueFactory(new PropertyValueFactory<>("nom_pdt"));
    prix_produit.setCellValueFactory(new PropertyValueFactory<>("prix"));
   // cat_produit.setText(s);
    cat_produit.setCellValueFactory(new PropertyValueFactory<>("description"));
    
    table.setItems(data);
    }
   
 /*@FXML
   private void notification(ActionEvent event) throws IOException {
        Notification notificationBulder= Notification.create().title("Alert").text("produit ajoute avec succes").graphic(null).
                hideAfter(javaFx.util.Duration.seconds(5)).position(pos.CENTER_LEFT)
                .onAction(new EventHandler<ActionEvent>(){
                public void handle(ActionEvent event)
                        {System.out.println("cliquer ici");
                        }});
        notificationBulder.darkStyle();
        notificationBulder.show;}*/

    @FXML
    private void back(ActionEvent event) throws IOException {
    root = FXMLLoader.load(getClass().getResource("ListeChoix.fxml"));
            stage= (Stage)((Node)event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void ajouterProduit(ActionEvent event) throws SQLException {
     /* Connection  connexion = MyConnexion.getInstance().getCnx();
        String sql = "insert into produit (nom_pdt,prix,description,stock,icone)values(?,?,?,?,?)";
        try {
            PreparedStatement ps = connexion.prepareStatement(sql);
            ps.setString(1, nom_produit.getText());
            ps.setString(2, prix_produit.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "produit ajoutée avec sucées");
            refreshlist();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } */
        String nom= tfnom.getText();
        float prix = 1;
        //   float prix= Float.valueOf(tfprix.getText()) ;
        String description= tfdesc.getText();
        Integer stock= Integer.valueOf(tfstock.getText()) ;
        String icone= tficone.getText();
        
 //ChoiceBox cb = new ChoiceBox();
 //cb.getItems().addAll("item1", "item2", "item3");
 //String cbcat=("item1", "item2", "item3");
       // Image image = new Image(input);
        //ImageView imageView = new ImageView(image);
        Produit pdt = new Produit(nom,prix,description,stock,icone);
        ServiceProduit sp= new ServiceProduit();
         sp.ajouterPdt(pdt);
         JOptionPane.showMessageDialog(null, "produit ajouter avec sucées");
            refreshlist();
        //  table.setItems(data);
       /* Alert alert = new Alert(Alert.AlertType.INFORMATION);
            try {
            sp.ajouterPdt(pdt);
            /*tfnom.setText("");
            tfprix.setText("");
            tfdesc.setText("");
            tfstock.setText("");
            refreshlist();
        alert.setTitle("Le produit est ajouter avec succes");
            alert.setHeaderText("Added");
            alert.setContentText("Ajouter un produit!");
           } catch (SQLException ex){
           alert.setAlertType(Alert.AlertType.ERROR);
           alert.setTitle("Error");
           alert.setHeaderText("Erreur d'ajout!!");
           alert.setContentText(ex.getMessage());
           }
            finally{
            
    alert.setHeaderText(null);
    alert.setContentText("produit ajouter avec succes");
    alert.show();           }*/ 
    }
    @FXML
    private void modifierProduit(ActionEvent event) {
     try{
Connection connexion = MyConnexion.getInstance().getCnx();
//String tfid=id_produit.getText();
//String tfnom=nom_produit.getText();
//String tfprix=prix_produit.getText();
//String tdesc=cat_produit.getText();

    String sql="Update produit set `nom_pdt`='"+tfnom.getText()+"',`stock`='"+tfstock.getText()+"',`description`='"+tfdesc.getText()+"',`prix`='"+tfprix.getText()+"' where `id_pdt`='"+tfid.getText()+"'" ;
    Statement ps = connexion.createStatement();
    ps.executeUpdate(sql);
    JOptionPane.showMessageDialog(null, "produit modifiée avec sucées");
            refreshlist();}
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }}

    @FXML
    private void supprimerProduit(ActionEvent event) {
Connection connexion = MyConnexion.getInstance().getCnx();        
String sql="delete from produit where `id_pdt`='"+ tfid.getText() +"'" ;
        try {
         Statement s = connexion.createStatement();
         //s.setString(1,id_produit.getText());
           s.executeUpdate(sql);
          JOptionPane.showMessageDialog(null, "Produit Supprimée");
           refreshlist();
        }
        catch(SQLException ex){} 
    }
 @FXML
    private void annulerProduit(ActionEvent event) {
        tfnom.setText("");
        tfprix.setText("");
        tfdesc.setText("");
        tfstock.setText("");
    }

    @FXML
    private void handleMouseAction(MouseEvent event) throws IOException {
       Produit p= table.getSelectionModel().getSelectedItem();
       
        tfid.setText(String.valueOf(p.getId_pdt()));
        tfnom.setText(p.getNom_pdt());
        tfstock.setText(String.valueOf(p.getStock()));
        tfprix.setText(String.valueOf(p.getPrix()));
        tfdesc.setText(p.getDescription());
        tficone.setText(p.getIcone());
     /*     clic= table.getSelectionModel().getSelectedItem();
      tfnom.setText(clic.getNom_pdt());
      tfprix.setText.parseFloat(clic.getPrix());
      tfdesc.setText(clic.getDescription());
      tfstock.setText(clic.getStock());*/   
    } 

    @FXML
    private void recherche(ActionEvent event) {
        String rech= tfrechercher.getText();
        ServiceProduit sp= new ServiceProduit();
        sp.findproduittByNom(rech); 
    }
    

  
 
}
