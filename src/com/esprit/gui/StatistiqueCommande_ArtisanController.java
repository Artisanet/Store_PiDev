/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.esprit.gui;
import com.esprit.entities.LigneCommande;
import com.esprit.services.LigneCommandeService;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ameni
 */
public class StatistiqueCommande_ArtisanController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /*public void loadData() {
        tabStat.getChildren().clear();
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        LigneCommandeService slc = new LigneCommandeService();
        List<LigneCommandeService.Stat> listStat = slc.AfficherLigneCommande();
        Iterator iterator = listStat.iterator();
        while (iterator.hasNext()) {
            LigneCommandeService.Stat stat = (ServiceCommande.Stat) iterator.next();
            lista.add(new PieChart.Data(stat.getGroup(), stat.getNombre()));
        }
        PieChart piechat = new PieChart(lista);
        piechat.setTitle("Formations les plus commandées");


        lista.forEach(data
                -> data.nameProperty().bind(
                        Bindings.concat(
                               (data.pieValueProperty().intValue()), " formation(s) ", data.getName() 
                        )
                )
        );

        paneStat.getChildren().add(piechat);

    }

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
          
        if (event.getSource() == btn_Commandes) {
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Back_ConsulterCommande.fxml")));
            stage.setScene(scene);
            stage.show();
        }
        if (event.getSource() == btn_Stats) {
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Back_StatCommande.fxml")));
            stage.setScene(scene);
            stage.show();
        }
    }
*/
}
