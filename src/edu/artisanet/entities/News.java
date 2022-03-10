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
public class News {
    
    private int id_act; 
    private String titre_act;
    private String text_act;
    private Date date_act;

    public News(int id_act, String titre_act, String text_act, Date date_act) {
        this.id_act = id_act;
        this.titre_act = titre_act;
        this.text_act = text_act;
        this.date_act = date_act;
    }

    public News(String titre_act, String text_act, Date date_act) {
        this.titre_act = titre_act;
        this.text_act = text_act;
        this.date_act = date_act;
    }

    public News() {
        
    }
    
    

    public int getId_act() {
        return id_act;
    }

    public void setId_act(int id_act) {
        this.id_act = id_act;
    }

    public String getTitre_act() {
        return titre_act;
    }

    public void setTitre_act(String titre_act) {
        this.titre_act = titre_act;
    }

    public String getText_act() {
        return text_act;
    }

    public void setText_act(String text_act) {
        this.text_act = text_act;
    }

    public Date getDate_act() {
        return date_act;
    }

    public void setDate_act(Date date_act) {
        this.date_act = date_act;
    }

    @Override
    public String toString() {
        return "News{" + "id_act=" + id_act + ", titre_act=" + titre_act + ", text_act=" + text_act + ", date_act=" + date_act + '}';
    }
    
    
    
    
}
