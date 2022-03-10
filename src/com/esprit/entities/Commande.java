/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.sql.Date;
import javafx.scene.chart.PieChart;

/**
 *
 * @author ameni
 */
public class Commande {

  
    private int id_commande;
    private int id_produit;
    private int id_client;
    private Date date_commande;
    private String statut;
    private String adresse;
    private float prix;
    
    
            

    
    public Commande(int id_commande,int id_produit,int id_client,Date date_commande,String statut,String adresse,float prix) {
        this.id_client=id_client;
        this.id_commande=id_commande;
        this.id_produit=id_produit;
        this.adresse=adresse;
        this.statut=statut;
        this.prix=prix;
        this.date_commande=date_commande;
        
    }
   
         public Commande(int id_produit,int id_client,Date date_commande,String statut,String adresse,float prix) {
        this.id_client=id_client;
        
        this.id_produit=id_produit;
        this.adresse=adresse;
        this.statut=statut;
        this.prix=prix;
        this.date_commande=date_commande;
        
    }
    

    public Commande() {
      
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    

    

    
    @Override
    public String toString() {
        return "Commande{id_commande=" + id_commande
                + ", id_produit=" + id_produit
                + ", id_client=" + id_client
                + ", date_commande=" + date_commande
                + ", prix=" + prix
                + ", statut=" + statut
                + ", adresse=" +adresse
                +'}';
    }

    public void setCenlter(PieChart pieChart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
    
    
    
    

