/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author ameni
 */

 

public class Offre {
    private int id_offre;
    private String nomoffre;
    private String description;
    private int pourcentage;
    private int nop;
    
    

    
    public Offre(int id_offre,String nomoffre,String description,int pourcentage, int nop) {
        this.id_offre=id_offre;
        this.nomoffre = nomoffre;
        this.description = description;
        this.pourcentage=pourcentage;
        this.nop = nop;
        
        
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public String getNomoffre() {
        return nomoffre;
    }

    public void setNomoffre(String nomoffre) {
        this.nomoffre = nomoffre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public int getNop() {
        return nop;
    }

    public void setNop(int nop) {
        this.nop = nop;
    }

    
     @Override
    public String toString() {
        return "Categorie{" +"id_offre"+id_offre
                + "nomoffre=" + nomoffre 
                + ", Desciption=" + description 
                + ", Pourcentage=" + pourcentage
                + ", nop=" + nop +
 
                '}';
    }
}


