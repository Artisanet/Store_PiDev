/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entities;

import java.util.Objects;
import javafx.scene.control.Button;

/**
 *
 * @author pc doctor
 */
public class panier {
    private int nopanier;
    private int nop;
    private String libelle;
    private int quantite;
    private float prix_produit;
    private float prix;
    

    public panier(int nopanier,int nop,String libelle,int quantite, float prix_produit,float prix) {
        this.nopanier = nopanier;
        this.nop = nop;
        this.libelle = libelle;
         this.prix_produit= prix_produit;
        this.prix = prix;
    }

   
        public panier(int nop,String libelle,int quantite, float prix_produit,float prix) {
       this.nop = nop;
        this.libelle = libelle;
         this.prix_produit= prix_produit;
        this.prix = prix;
    }

    public panier() {
        }

    
    

    public float getPrix_produit() {
        return prix_produit;
    }

    public void setPrix_produit(float prix_produit) {
        this.prix_produit = prix_produit;
    }
        
         public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getNopanier() {
        return nopanier;
    }

    public void setNopanier(int nopanier) {
        this.nopanier = nopanier;
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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final panier other = (panier) obj;
        if (this.nopanier != other.nopanier) {
            return false;
        }
        if (!Objects.equals(this.nop, other.nop)) {
            return false;
        }
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        if (!Objects.equals(this.quantite, other.quantite)) {
            return false;
        }
            if (!Objects.equals(this.prix_produit, other.prix_produit)) {
            return false;
        }
        if (!Objects.equals(this.prix, other.prix)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "panier{" + "nopanier=" + nopanier
                + ", noproduit=" + nop +
                ", libelle=" + libelle +
                 ", quantite=" + quantite +
                ", prix_produit=" + prix_produit +
                ", prix=" + prix + '}';
    }

  
    
    
}
