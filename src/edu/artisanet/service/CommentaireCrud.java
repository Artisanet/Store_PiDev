/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.service;

import edu.artisanet.entities.Commentaire;
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
public class CommentaireCrud implements Crud<Commentaire> {

    private Connection connect;
    private Statement stat;

    public CommentaireCrud() {
        connect = DataBase.getInstance().getConnection();
    }

    ;


    public void add(Commentaire t) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("INSERT INTO commentaire (nom_com,text_com,date_com,id_post)VALUES (?,?,?,?);");
        pre.setString(1, t.getNom_com());
        pre.setString(2, t.getText_com());
        pre.setDate(3, t.getDate_com());
        pre.setInt(4, t.getId_post());

        pre.executeUpdate();
    }

    public boolean update(Commentaire t, int id) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("UPDATE commentaire SET nom_com =? , text_com=?,date_com=? WHERE id_com=? ;");

        
        pre.setString(1, t.getNom_com());
        pre.setString(2, t.getText_com());
        pre.setDate(3, t.getDate_com());
        pre.setInt(4, id);

        if (pre.executeUpdate() != 0) {
            System.out.println(" commantaire updated");
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(int id) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("Delete from commentaire where id_com=? ;");
        pre.setInt(1, id);
        if (pre.executeUpdate() != 0) {
            System.out.println("commentaire Deleted");
            return true;
        }
        System.out.println("id commentaire not found!!!");
        return false;
    }

    
    public List<Commentaire> getALL() throws SQLException {
        List<Commentaire> lu = new ArrayList<>();
        stat = connect.createStatement();
        ResultSet rs = stat.executeQuery("select id_com ,nom_com,text_com,date_com,id_post  from commentaire");
        while (rs.next()) {
            int id_com = rs.getInt("id_com");
            String nom_com = rs.getString("nom_com");
            String text_com = rs.getString("text_com");
            Date date_com = rs.getDate("date_com");
            int id_post = rs.getInt("id_post");

            Commentaire c = new Commentaire(id_com, nom_com, text_com, date_com, id_post);
            lu.add(c);
        }
        return lu;
    }

}
