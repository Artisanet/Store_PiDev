/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.service;

import edu.artisanet.entities.News;
import edu.artisanet.utils.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bayrem
 */
public class NewsCrud implements Crud<News> {

    private Connection connect;
    private Statement stat;

    public NewsCrud() {
        connect = DataBase.getInstance().getConnection();
    } 

    
    public void add(News t) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("INSERT INTO news (titre_act,text_act,date_act)VALUES (?,?,?);");
        pre.setString(1, t.getTitre_act());
        pre.setString(2, t.getText_act());
        pre.setDate(3, t.getDate_act());
        pre.executeUpdate();
    }

    
    public boolean update(News t, int id) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("UPDATE news SET titre_act=?, text_act=?, date_act=? WHERE id_act=? ;");

        pre.setInt(4, id);
        pre.setString(1, t.getTitre_act());
        pre.setString(2, t.getText_act());
        pre.setDate(3, t.getDate_act());

        if (pre.executeUpdate() != 0) {
            System.out.println(" reclamation updated");
            return true;
        } else {
            return false;
        }
    }

    
    public boolean delete(int id) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("Delete from news where id_act=? ;");
        pre.setInt(1, id);
        if (pre.executeUpdate() != 0) {
            System.out.println("News Deleted");
            return true;
        }
        System.out.println("id News not found!!!");
        return false;
    }

    
    public List<News> getALL() throws SQLException {
        List<News> lu = new ArrayList<>();
        stat = connect.createStatement();
        ResultSet rs = stat.executeQuery("select id_act ,titre_act,text_act,date_act from news");
        while (rs.next()) {
            int id_act = rs.getInt("id_act");
            String titre_act = rs.getString("titre_act");
            String text_act = rs.getString("text_act");
            Date date_act = rs.getDate("date_act");
       //     String status_rec = rs.getString("status_rec");

            News c = new News(id_act, titre_act, text_act, date_act);
            lu.add(c);
        }
        return lu;
    }

   public List<News> getRecent() throws SQLException {
        List<News> lu = new ArrayList<>();
        stat = connect.createStatement();
        ResultSet rs = stat.executeQuery("SELECT id_act ,titre_act,text_act,date_act FROM news ORDER BY date_act ASC");
        while (rs.next()) {
            int id_act = rs.getInt("id_act");
            String titre_act = rs.getString("titre_act");
            String text_act = rs.getString("text_act");
            Date date_act = rs.getDate("date_act");
       //     String status_rec = rs.getString("status_rec");

            News c = new News(id_act, titre_act, text_act, date_act);
            lu.add(c);
        }
        return lu;
    }
   
   public List<News> getOld() throws SQLException {
        List<News> lu = new ArrayList<>();
        stat = connect.createStatement();
        ResultSet rs = stat.executeQuery("SELECT id_act ,titre_act,text_act,date_act FROM news ORDER BY date_act DESC");
        while (rs.next()) {
            int id_act = rs.getInt("id_act");
            String titre_act = rs.getString("titre_act");
            String text_act = rs.getString("text_act");
            Date date_act = rs.getDate("date_act");
       //     String status_rec = rs.getString("status_rec");

            News c = new News(id_act, titre_act, text_act, date_act);
            lu.add(c);
        }
        return lu;
    }
    
}
