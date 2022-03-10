/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.gui;

import com.jfoenix.controls.JFXTextArea;
import edu.artisanet.entities.Commentaire;
import edu.artisanet.entities.News;
import edu.artisanet.service.MyListener2;
import edu.artisanet.service.NewsCrud;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Bayrem
 */
public class ClientNewsFXMLController implements Initializable {

    @FXML
    private VBox selectedCom;
    @FXML
    private Label nomCom;
    @FXML
    private JFXTextArea contCom;
    @FXML
    private ScrollPane scroll1;
    @FXML
    private GridPane grid1;

    /**
     * Initializes the controller class.
     */
    
    private NewsCrud newscrud = new NewsCrud();
    
    private List<News> news = new ArrayList<>();
    
    private MyListener2 myListener;
    
    
    private List<News> getData() throws SQLException{
        List<News> comss = new ArrayList<>();
        
    
        
   
   
    //    Commentaire com;
    //    Calendar c = Calendar.getInstance();
    //    Date d = new Date(c.getTime().getTime());
        
 
    //    com = new Commentaire();
    //    com.setNom_com("bayrem");
    //   com.setText_com("T3eeeeeeeeeebt");
    //   com.setDate_com(d);
    //    comss.add(com);
        comss = newscrud.getALL();
        
        return comss;
    }
    
    private void setChosenCom(News news) throws SQLException{
        
        nomCom.setText(news.getTitre_act());
        contCom.setText(news.getText_act());
       
    }
    
    private void showPost(){
        try {
            // TODO

            
            if(news.size() > 0){
            setChosenCom(news.get(0));
            myListener = new MyListener2() {
                @Override
                public void onClickListener(News news) {
                    try {
                        setChosenCom(news);
                    } catch (SQLException ex) {
                        Logger.getLogger(ClientComFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
        }
        } catch (SQLException ex) {
            Logger.getLogger(ClientComFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int col=0;
        int lin=1;
        try {
        for(int i=0 ; i<news.size() ; i++){
            FXMLLoader fx = new FXMLLoader();
            fx.setLocation(getClass().getResource("NewsFXML.fxml"));
            AnchorPane ap = fx.load();
     //       scroll1.setContent(ap);
            
            NewsFXMLController newController = fx.getController();
            newController.setData(news.get(i), myListener);
            
            if(col == 3){
                col = 0;
                lin++;
            }
            
            grid1.add(ap, col++, lin);
            
            grid1.setMaxWidth(Region.USE_COMPUTED_SIZE);
            grid1.setPrefWidth(Region.USE_COMPUTED_SIZE);
            grid1.setMinWidth(Region.USE_COMPUTED_SIZE);
            
            grid1.setMaxHeight(Region.USE_COMPUTED_SIZE);
            grid1.setPrefHeight(Region.USE_COMPUTED_SIZE);
            grid1.setMinHeight(Region.USE_COMPUTED_SIZE);
            
            GridPane.setMargin(ap, new Insets(10));
        }
        } catch (IOException ex) {
                Logger.getLogger(ClientComFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            news.addAll(getData());
        } catch (SQLException ex) {
            Logger.getLogger(ClientNewsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        showPost();
        // TODO
    }    

    @FXML
    private void add(ActionEvent event) throws SQLException {
        news.addAll(newscrud.getRecent());
  
        showPost();
    }

    @FXML
    private void update(ActionEvent event) throws SQLException {
        news.addAll(newscrud.getOld());
        showPost();
        
  
    }
    
}
