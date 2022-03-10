/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.service;

import edu.artisanet.entities.Reclamation;
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
public class ReclamationCrud implements Crud<Reclamation> {
    
    private Connection connect;
    private Statement stat;
    
    public ReclamationCrud(){
        connect = DataBase.getInstance().getConnection();
    };

 
    public void add(Reclamation t) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("INSERT INTO reclamation (nom_rec,text_rec,date_rec)VALUES (?,?,?);");
        pre.setString(1, t.getNom_rec());
        pre.setString(2, t.getText_rec());
        pre.setDate(3, t.getDate_rec());
        pre.executeUpdate();
    }

 
    public boolean update(Reclamation t, int id) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("UPDATE reclamation SET nom_rec=?, text_rec=?, date_rec=? WHERE id_rec=? ;");

        pre.setInt(4, id);
        pre.setString(1, t.getNom_rec());
        pre.setString(2, t.getText_rec());
        pre.setDate(3, t.getDate_rec());

        if (pre.executeUpdate() != 0) {
            System.out.println(" reclamation updated");
            return true;
        } else {
            return false;
        }
    }

    
    public boolean delete(int id) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("Delete from reclamation where id_rec=? ;");
        pre.setInt(1, id);
        if (pre.executeUpdate() != 0) {
            System.out.println("Reclamation Deleted");
            return true;
        }
        System.out.println("id reclamation not found!!!");
        return false;
    }

    
    public List<Reclamation> getALL() throws SQLException {
        List<Reclamation> lu = new ArrayList<>();
        stat = connect.createStatement();
        ResultSet rs = stat.executeQuery("select id_rec ,nom_rec,text_rec,date_rec,status_rec  from reclamation");
        while (rs.next()) {
            int id_rec = rs.getInt("id_rec");
            String nom_rec = rs.getString("nom_rec");
            String text_rec = rs.getString("text_rec");
            Date date_rec = rs.getDate("date_rec");
            String status_rec = rs.getString("status_rec");

            Reclamation c = new Reclamation(id_rec, nom_rec, text_rec, date_rec, status_rec);
            lu.add(c);
        }
        return lu;
    
    }
    
    public boolean updatestatus( int id) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("UPDATE reclamation SET status_rec=? WHERE id_rec=? ;");

        pre.setInt(2, id);
        pre.setString(1, "Solved");
  //      pre.setString(1, t.getNom_rec());
  //      pre.setString(2, t.getText_rec());
  //      pre.setDate(3, t.getDate_rec());

        if (pre.executeUpdate() != 0) {
            System.out.println(" reclamation updated");
            return true;
        } else {
            return false;
        }
    }
    
}
