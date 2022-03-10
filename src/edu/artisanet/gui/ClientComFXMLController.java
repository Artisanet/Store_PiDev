/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.gui;

import com.jfoenix.controls.JFXTextArea;
import edu.artisanet.entities.Commentaire;
import edu.artisanet.entities.News;
import edu.artisanet.entities.Vote;
import edu.artisanet.service.CommentaireCrud;
import edu.artisanet.service.MyListener;
import edu.artisanet.service.VoteCrud;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Bayrem
 */
public class ClientComFXMLController implements Initializable {

    @FXML
    private VBox selectedCom;
    @FXML
    private Label nomCom;
    @FXML
    private JFXTextArea contCom;
    @FXML
    private Label likes;
    @FXML
    private Label dislikes;
    @FXML
    private ScrollPane scroll1;
    @FXML
    private GridPane grid1;
    private MyListener myListener;
    
    private int id;
    private VoteCrud vote = new VoteCrud();
    private CommentaireCrud comments = new CommentaireCrud();
    @FXML
    private JFXTextArea areaNom;
    @FXML
    private JFXTextArea areaCon;
    
    private List<Commentaire> coms = new ArrayList<>();
    @FXML
    private AnchorPane anchor;
    private ScrollPane scroll2;
    @FXML
    private AnchorPane anchor1;
    
    
    private List<Commentaire> getData() throws SQLException{
        List<Commentaire> comss = new ArrayList<>();
        
    
        
   
   
    //    Commentaire com;
    //    Calendar c = Calendar.getInstance();
    //    Date d = new Date(c.getTime().getTime());
        
 
    //    com = new Commentaire();
    //    com.setNom_com("bayrem");
    //   com.setText_com("T3eeeeeeeeeebt");
    //   com.setDate_com(d);
    //    comss.add(com);
        comss = comments.getALL();
        
        return comss;
    }
    
    private void setChosenCom(Commentaire com) throws SQLException{
        id = com.getId_com();
        nomCom.setText(com.getNom_com());
        contCom.setText(com.getText_com());
        
        likes.setText(Integer.toString(vote.countLike(com.getId_com())));
        dislikes.setText(Integer.toString(vote.countDislike(com.getId_com())));
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        showPost();
        
    }    
    
    private void showPost(){
        try {
            // TODO

            coms.addAll(getData());
            if(coms.size() > 0){
            setChosenCom(coms.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Commentaire commentaire) {
                    try {
                        setChosenCom(commentaire);
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
        for(int i=0 ; i<coms.size() ; i++){
            FXMLLoader fx = new FXMLLoader();
            fx.setLocation(getClass().getResource("CommentFXML.fxml"));
            AnchorPane ap = fx.load();

            
            CommentFXMLController commentController = fx.getController();
            commentController.setData(coms.get(i), myListener);
            
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
    
    

    @FXML
    private void like(MouseEvent event) throws SQLException {
        Vote v = new Vote(1,0,id);
        vote.addLike(v);
        coms.clear();
        showPost();
    }

    @FXML
    private void dislike(MouseEvent event) throws SQLException {
        Vote v = new Vote(0,1,id);
        vote.addDislike(v);
        coms.clear();
        showPost();
    }

    @FXML
    private void add(ActionEvent event) throws SQLException {
        Calendar c = Calendar.getInstance();
        Date d = new Date(c.getTime().getTime());
        
        
        if(!(areaNom.getText().matches("^[a-z]*$")) && !(areaNom.getText().matches("^[A-Z]*$"))) 
            {
              Alert alert = new Alert(AlertType.ERROR);
              
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid name!");
                alert.showAndWait();
                
                
            }
        if(areaNom.getText().isEmpty() | areaCon.getText().isEmpty() == true){
                
                Alert alert = new Alert(AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Blank field detected, please write your name and comment");
                alert.showAndWait();
        }
        else {
        Commentaire cc = new Commentaire(areaNom.getText(),areaCon.getText(),d,15);
        comments.add(cc);
        coms.clear();
        showPost();
        }
    }

    @FXML
    private void update(ActionEvent event) throws SQLException {
        Calendar c = Calendar.getInstance();
        Date d = new Date(c.getTime().getTime());
        if(!(areaNom.getText().matches("^[a-z]*$")) && !(areaNom.getText().matches("^[A-Z]*$"))) 
            {
              Alert alert = new Alert(Alert.AlertType.ERROR);
              
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid name!");
                alert.showAndWait();
                
                
            }
        if(areaNom.getText().isEmpty() | areaCon.getText().isEmpty() == true){
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Blank field detected, please write your name and comment");
                alert.showAndWait();
        }
        else {
        Commentaire cc = new Commentaire(areaNom.getText(),areaCon.getText(),d,15);
        comments.update(cc,id);
        coms.clear();
        showPost();
        }
    }

    @FXML
    private void delete(ActionEvent event) throws SQLException, IOException {
        comments.delete(id);
      //  scroll1.setContent(scroll1.getChildrenUnmodifiable());
      
      
        coms.clear();
   //     scroll2.setContent(null); 
        
        showPost();
       
      //  scroll2.setContent(scroll1);
        
//          FXMLLoader fx = new FXMLLoader();
//          fx.setLocation(getClass().getResource(""));
//  //        AnchorPane ap = fx.load();
//    //      scroll1.setContent(ap);
//        
//          anchor = fx.load();
    
     
        
        
        
    }
    
}
