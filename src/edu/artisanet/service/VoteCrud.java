/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.service;

import edu.artisanet.entities.Vote;
import edu.artisanet.utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bayrem
 */
public class VoteCrud {
    
    private Connection connect;
    private Statement stat;
    
    public VoteCrud(){
        connect = DataBase.getInstance().getConnection();
    };
    
    
    public void addLike(Vote t) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("INSERT INTO vote (id_vote,like_vote,dislike_vote,id_com)VALUES (?,?,?,?);");
        
        pre.setInt(1, t.getId_vote());    
        pre.setInt(2, t.getLike_vote());
        pre.setInt(3, t.getDislike_vote());
        pre.setInt(4, t.getId_com());
        pre.executeUpdate();
    };
    
    public void addDislike(Vote t) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("INSERT INTO vote (id_vote,like_vote,dislike_vote,id_com)VALUES (?,?,?,?);");
        pre.setInt(2, t.getLike_vote());
        pre.setInt(3, t.getDislike_vote());
        pre.setInt(1, t.getId_vote());
        pre.setInt(4, t.getId_com());
        pre.executeUpdate();
    };
    
    
    public int countLike(int id) throws SQLException {
        int likeCounter = 0;
        stat = connect.createStatement();
        ResultSet rs = stat.executeQuery("select like_vote  from vote where id_com= "+ id);
       
        while (rs.next()) {
            int x = rs.getInt("like_vote");
            likeCounter = likeCounter+x;
            }
    return likeCounter;
    };
    
    public int countDislike(int id) throws SQLException {
        int dislikeCounter = 0;
        stat = connect.createStatement();
        ResultSet rs = stat.executeQuery("select dislike_vote  from vote where id_com= "+ id);
        while (rs.next()) {
            int x = rs.getInt("dislike_vote");
            dislikeCounter = dislikeCounter+x;
            }
    return dislikeCounter;
    };
    
    
}