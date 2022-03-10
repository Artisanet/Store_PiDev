/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.gui;

import edu.artisanet.entities.Commentaire;
import edu.artisanet.service.MyListener;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Bayrem
 */
public class CommentFXMLController implements Initializable {

    @FXML
    private Label nomCom2;
    
    private Commentaire com1;
    @FXML
    private Label nomCom21;
    
    
    
    private MyListener myListener;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void click(MouseEvent event){
        myListener.onClickListener(com1);
    }
    
    public void setData(Commentaire com, MyListener myListener){
        this.com1 = com;
        this.myListener = myListener;
        nomCom2.setText(com.getNom_com());
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
        String strDate = formatter.format(com.getDate_com());  
        nomCom21.setText(strDate);
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


}
