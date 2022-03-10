/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;

import com.esprit.entities.Remise;
import com.esprit.entities.panier;
import com.esprit.utils.Connexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author ameni
 */
public class RemiseController implements Initializable {

    @FXML
    private TableView<Remise> remiseTable;
    @FXML
    private TableColumn<Remise, String> col_libelle;
    @FXML
    private TableColumn<Remise, String> col_pourcentage;
    @FXML
    private TableColumn<Remise, String> col_ancienprix;
    @FXML
    private TableColumn<Remise, String> col_nouveauprix;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button imprimer;
    @FXML
    private Button quitter;

      
String query = null;
    Connection connexion = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Remise r = null ;
    
    ObservableList<Remise>  RemiseList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Remise, String> editCol;
    @FXML
    private Button supprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadDate();
    }    
    
    
    

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void getAddView(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("AjoutRemise.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RemiseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void refreshTable() {
        try {
            RemiseList.clear();
            
            query = "SELECT * FROM `remise`";
            preparedStatement = connexion.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                RemiseList.add(new Remise(
                        resultSet.getInt("id_remise"),
                        resultSet.getInt("nop"),
                        resultSet.getString("libelle"),
                        resultSet.getFloat("pourcentage"),
                        resultSet.getInt("ancienPrix"),
                        resultSet.getInt("nouveauPrix")));
                remiseTable.setItems(RemiseList);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RemiseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    @FXML
    private void print(MouseEvent event) {
    }

    private void loadDate() {
        
        connexion = Connexion.getInstance().getConnexion();
        refreshTable();
        
        col_libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        col_pourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
        col_ancienprix.setCellValueFactory(new PropertyValueFactory<>("ancienPrix"));
        col_nouveauprix.setCellValueFactory(new PropertyValueFactory<>("NouveauPrix"));
        
        
        //add cell of button edit 
         Callback<TableColumn<Remise, String>, TableCell<Remise, String>> cellFoctory = (TableColumn<Remise, String> param) -> {
            // make cell containing buttons
            final TableCell<Remise, String> cell = new TableCell<Remise, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        Button supprimer = new Button();
                        Button modifier = new Button();

                        /*supprimer.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        modifier.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );*/
                        supprimer.setOnMouseClicked((MouseEvent event) -> {
                            
                            try {
                                r = remiseTable.getSelectionModel().getSelectedItem();
                                query = "DELETE FROM `remise` WHERE libelle  ="+r.getLibelle();
                                connexion = Connexion.getInstance().getConnexion();
                                preparedStatement = connexion.prepareStatement(query);
                                preparedStatement.execute();
                                refreshTable();
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(RemiseController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                           

                          

                        });
                        modifier.setOnMouseClicked((MouseEvent event) -> {
                            
                            r = remiseTable.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("AjoutRemise.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(RemiseController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            AjoutRemiseController ajoutRemiseController = loader.getController();
                            ajoutRemiseController.setUpdate(true);
                            ajoutRemiseController.setTextField(r.getId_remise(),
                                    r.getNop(),r.getLibelle(), r.getPourcentage(),r.getAncienPrix(),r.getNouveauPrix()
                                    );
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            

                           

                        });

                        HBox managebtn = new HBox(modifier, supprimer);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(supprimer, new Insets(2, 2, 0, 3));
                        HBox.setMargin(modifier, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
         editCol.setCellFactory(cellFoctory);
         remiseTable.setItems(RemiseList);
         
         
    }
    
}

