/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

/**
 *
 * @author ameni
 */
public class Remise {
    private int id_remise;
    private int nop;
    private String libelle;
    private float pourcentage;
    private float ancienPrix;
    private float nouveauPrix;

    public Remise(int id_remise,int nop,String libelle, float pourcentage,float ancienPrix,float nouveauPrix) {
        this.id_remise=id_remise;
       this.nop = nop;
        this.libelle=libelle;
        this.pourcentage = pourcentage;
        this.ancienPrix=ancienPrix;
        this.nouveauPrix=nouveauPrix;
    }
    public Remise(int nop,String libelle, float pourcentage,float ancienPrix,float nouveauPrix) {
        
        this.nop = nop;
        this.libelle=libelle;
        this.pourcentage = pourcentage;
        this.ancienPrix=ancienPrix;
        this.nouveauPrix=nouveauPrix;
    }

    public Remise() {
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    

    public int getId_remise() {
        return id_remise;
    }

    public void setId_remise(int id_remise) {
        this.id_remise = id_remise;
    }

    public int getNop() {
        return nop;
    }

    public void setNop(int nop) {
        this.nop = nop;
    }

    public float getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(float pourcentage) {
        this.pourcentage = pourcentage;
    }

    public float getAncienPrix() {
        return ancienPrix;
    }

    public void setAncienPrix(float ancienPrix) {
        this.ancienPrix = ancienPrix;
    }

    public float getNouveauPrix() {
        return nouveauPrix;
    }

    public void setNouveauPrix(float nouveauPrix) {
        this.nouveauPrix = nouveauPrix;
    }
 @Override
    public String toString() {
        return "Remise{" + "id_remsie=" + id_remise + ", nop=" + nop
                + ", libelle=" + libelle
                + ", pourcentage=" + pourcentage 
                + ", ancienPrix=" + ancienPrix + ", nouveauPrix=" + nouveauPrix + '}';
    }
}
