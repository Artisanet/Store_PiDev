/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.sql.Date;

/**
 *
 * @author ameni
 */
public class Produit {
    private int nop;
    private String libelle;
    private float prix_produit;
    private int qte_stock;
    
            

    
    public Produit(int nop,String libelle,float prix_produit,int qte_stock) {
        this.nop=nop;
        this.libelle=libelle;
        this.prix_produit=prix_produit;
        this.qte_stock=qte_stock;
        
    }
    public Produit(String libelle,float prix_produit,int qte_stock) {
        
        this.libelle=libelle;
        this.prix_produit=prix_produit;
        this.qte_stock=qte_stock;
    }
    public Produit() {
      
    }

    public int getNop() {
        return nop;
    }

    public void setNop(int nop) {
        this.nop = nop;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPrix_produit() {
        return prix_produit;
    }

    public void setPrix_produit(float prix_produit) {
        this.prix_produit = prix_produit;
    }

    public int getQte_stock() {
        return qte_stock;
    }

    public void setQte_stock(int qte_stock) {
        this.qte_stock = qte_stock;
    }
    @Override
    public String toString() {
        return "Produit{nop=" + nop 
                + ", lbelle=" + libelle 
                + ", prix_produit=" + prix_produit 
                + ", qte_stock=" + qte_stock
                +'}';
    }
}
