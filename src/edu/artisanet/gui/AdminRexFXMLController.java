/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import edu.artisanet.entities.News;
import edu.artisanet.entities.Reclamation;
import edu.artisanet.service.ReclamationCrud;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Bayrem
 */
public class AdminRexFXMLController implements Initializable {

    @FXML
    private TableColumn<?, ?> titreCol;
    @FXML
    private TableColumn<?, ?> conCol;
    @FXML
    private TableColumn<?, ?> dateCol;
    @FXML
    private JFXButton updateButton;
    @FXML
    private JFXButton deleteButton;
    @FXML
    private JFXTextArea Extra;
    
    ObservableList<Reclamation> RecList = FXCollections.observableArrayList();
    @FXML
    private TableView<Reclamation> RecTable;
    @FXML
    private TableColumn<?, ?> statusCol;
    
    private Reclamation catItem; 
    private int id;

    /**
     * Initializes the controller class.
     */
    
    private void refreshTable() {
        try {
            RecList.clear();
            ReclamationCrud ccrud = new ReclamationCrud();

            List<Reclamation> Newss = ccrud.getALL();
            RecList.setAll(Newss);
            RecTable.setItems(RecList);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void loadData() {
        refreshTable();

        titreCol.setCellValueFactory(new PropertyValueFactory<>("nom_rec"));
        conCol.setCellValueFactory(new PropertyValueFactory<>("text_rec"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date_rec"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status_rec"));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }    

    @FXML
    private void Select(MouseEvent event) {
        catItem = RecTable.getSelectionModel().getSelectedItem();
        Extra.setText(catItem.getText_rec());
        id = catItem.getId_rec();
    }

    @FXML
    private void Update(ActionEvent event) throws SQLException {
        ReclamationCrud r = new ReclamationCrud();
        r.updatestatus(id);
        refreshTable();
    }

    @FXML
    private void Delete(ActionEvent event) throws SQLException {
        ReclamationCrud r = new ReclamationCrud();
        r.delete(id);
        refreshTable();
    }
    
}
