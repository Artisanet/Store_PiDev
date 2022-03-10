/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.gui;

import edu.artisanet.entities.News;
import edu.artisanet.service.MyListener2;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Bayrem
 */
public class NewsFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     private MyListener2 myListener;
     
    private News news;
    
    @FXML
    private Label areaTitle;
    @FXML
    private Label areaDate;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void click(MouseEvent event){
        myListener.onClickListener(news);
    }
    
    public void setData(News com, MyListener2 myListener){
        this.news = com;
        this.myListener = myListener;
        areaTitle.setText(com.getTitre_act());
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
        String strDate = formatter.format(com.getDate_act());  
        areaDate.setText(strDate);
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
