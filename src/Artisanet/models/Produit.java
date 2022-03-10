/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Artisanet.models;

import java.awt.Image;


/**
 *
 * @author nourb
 */
public class Produit {
    public int id_pdt ;
    public String nom_pdt ;
    public float prix ;
    public String description ;
    public int stock;
    public String icone ;

    public Produit() {
    }

    public Produit(String nom_pdt, float prix, String description, int stock, String icone) {
        this.nom_pdt = nom_pdt;
        this.prix = prix;
        this.description = description;
        this.stock = stock;
        this.icone = icone;
    }

    public Produit(int id_pdt, String nom_pdt, float prix, String description, int stock, String icone) {
        this.id_pdt = id_pdt;
        this.nom_pdt = nom_pdt;
        this.prix = prix;
        this.description = description;
        this.stock = stock;
        this.icone = icone;
    }

    public Produit(int id_pdt) {
        this.id_pdt = id_pdt;
    }
    
    public Produit( String nom_pdt, float prix, String description, String icone) {
        this.nom_pdt = nom_pdt;
        this.prix = prix;
        this.description = description;
        this.icone = icone;
    }

    public Produit(String nom, float prix, String description, int stock, Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public Produit( String nom_pdt, float prix, String description, int stock) {
        this.nom_pdt = nom_pdt;
        this.prix = prix;
        this.description = description;
        this.stock = stock;
    }
    public int getId_pdt() {
        return id_pdt;
    }

    public String getNom_pdt() {
        return nom_pdt;
    }

    public float getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public String getIcone() {
        return icone;
    }

    public void setId_pdt(int id_pdt) {
        this.id_pdt = id_pdt;
    }

    public void setNom_pdt(String nom_pdt) {
        this.nom_pdt = nom_pdt;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    @Override
    public String toString() {
        return "Produit{" + "num_pdt=" + id_pdt + ", nom=" + nom_pdt + ", prix=" + prix + ", description=" + description + ", stock=" + stock + ", icone=" + icone + '}';
    }
    
    
 
}
