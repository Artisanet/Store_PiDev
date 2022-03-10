/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.entities;

import java.sql.Date;



/**
 *
 * @author Bayrem
 */
public class Commentaire {
    private int id_com;
    private String nom_com;
    private String text_com;
    private Date date_com;
    private int id_post;

    public Commentaire(int id_com, String nom_com, String text_com, Date date_com, int id_post) {
        this.id_com = id_com;
        this.nom_com = nom_com;
        this.text_com = text_com;
        this.date_com = date_com;
        this.id_post = id_post;
    }

    public Commentaire(String nom_com, String text_com, Date date_com, int id_post) {
        this.nom_com = nom_com;
        this.text_com = text_com;
        this.date_com = date_com;
        this.id_post = id_post;
    }

    public Commentaire() {
        
    }
    


    public int getId_com() {
        return id_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public String getNom_com() {
        return nom_com;
    }

    public void setNom_com(String nom_com) {
        this.nom_com = nom_com;
    }

    public String getText_com() {
        return text_com;
    }

    public void setText_com(String text_com) {
        this.text_com = text_com;
    }

    public Date getDate_com() {
        return date_com;
    }

    public void setDate_com(Date date_com) {
        this.date_com = date_com;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id_com=" + id_com + ", nom_com=" + nom_com + ", text_com=" + text_com + ", date_com=" + date_com + ", id_post=" + id_post + '}';
    }
    
    
}
