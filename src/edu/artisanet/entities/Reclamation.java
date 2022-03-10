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
public class Reclamation {
    private int id_rec;
    private String nom_rec;
    private String text_rec;
    private Date date_rec;
    private String status_rec;

    public Reclamation(int id_rec, String nom_rec, String text_rec, Date date_rec, String status_rec) {
        this.id_rec = id_rec;
        this.nom_rec = nom_rec;
        this.text_rec = text_rec;
        this.date_rec = date_rec;
        this.status_rec = status_rec;
    }

    public Reclamation(String nom_rec, String text_rec, Date date_rec, String status_rec) {
        this.nom_rec = nom_rec;
        this.text_rec = text_rec;
        this.date_rec = date_rec;
        this.status_rec = status_rec;
    }
    
    

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public String getNom_rec() {
        return nom_rec;
    }

    public void setNom_rec(String nom_rec) {
        this.nom_rec = nom_rec;
    }

    public String getText_rec() {
        return text_rec;
    }

    public void setText_rec(String text_rec) {
        this.text_rec = text_rec;
    }

    public Date getDate_rec() {
        return date_rec;
    }

    public void setDate_rec(Date date_rec) {
        this.date_rec = date_rec;
    }

    public String getStatus_rec() {
        return status_rec;
    }

    public void setStatus_rec(String status_rec) {
        this.status_rec = status_rec;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_rec=" + id_rec + ", nom_rec=" + nom_rec + ", text_rec=" + text_rec + ", date_rec=" + date_rec + ", status_rec=" + status_rec + '}';
    }
    
    
}
