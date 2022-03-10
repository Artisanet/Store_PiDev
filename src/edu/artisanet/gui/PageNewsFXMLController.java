/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import edu.artisanet.entities.News;
import edu.artisanet.service.NewsCrud;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Bayrem
 */
public class PageNewsFXMLController implements Initializable {

    @FXML
    private JFXButton addButton;
    @FXML
    private JFXButton updateButton;
    @FXML
    private JFXButton deleteButton;
    
    ObservableList<News> NewsList = FXCollections.observableArrayList();
    @FXML
    private JFXTextArea areaTitle;
    @FXML
    private TableView<News> NewsTable;
    @FXML
    private TableColumn<?, ?> titreCol;
    @FXML
    private TableColumn<?, ?> conCol;
    @FXML
    private TableColumn<?, ?> dateCol;
    @FXML
    private JFXTextArea areaCon;
    
    
    private News catItem; 
    private int id;
    
    Calendar c = Calendar.getInstance();
    Date d = new Date(c.getTime().getTime());
    
    
    
    private void refreshTable() {
        try {
            NewsList.clear();
            NewsCrud ccrud = new NewsCrud();

            List<News> Newss = ccrud.getALL();
            NewsList.setAll(Newss);
            NewsTable.setItems(NewsList);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void loadData() {
        refreshTable();

        titreCol.setCellValueFactory(new PropertyValueFactory<>("titre_act"));
        conCol.setCellValueFactory(new PropertyValueFactory<>("text_act"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date_act"));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }    

    @FXML
    private void Select(MouseEvent event) {
        catItem = NewsTable.getSelectionModel().getSelectedItem();
        areaTitle.setText(catItem.getTitre_act());
        areaCon.setText(catItem.getText_act());
        id = catItem.getId_act();
    }

    @FXML
    private void Add(ActionEvent event) throws SQLException {
        
        if(areaTitle.getText().isEmpty() | areaCon.getText().isEmpty() == true){
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Blank field detected, please write your name and comment");
                alert.showAndWait();
        }
        else {
        News n = new News(areaTitle.getText(),areaCon.getText(),d);
        NewsCrud nn = new NewsCrud();
        nn.add(n);
        refreshTable();
        }
    }

    @FXML
    private void Update(ActionEvent event) throws SQLException {
        if(areaTitle.getText().isEmpty() | areaCon.getText().isEmpty() == true){
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Blank field detected, please write your name and comment");
                alert.showAndWait();
        }
        else {
        News n = new News(areaTitle.getText(),areaCon.getText(),d);
        NewsCrud nn = new NewsCrud();
        nn.update(n, id);
        refreshTable();
        }
    }

    @FXML
    private void Delete(ActionEvent event) throws SQLException {
        NewsCrud nn = new NewsCrud();
        nn.delete(id);
        refreshTable();
    }
    
}
