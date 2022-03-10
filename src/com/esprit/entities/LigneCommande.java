/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;



/**
 *
 * @author ameni
 */
public class LigneCommande {
    private int nolc;
    private int nocmd;
    private int nop;
    
    private double montant_cmd;
    private int delaiLivr_cmd;
    private String etat_cmd;
    private String lieuLivr_cmd;
    private float PrixTotal;
    private String modePaiement ;

    
    public LigneCommande(int nolc,int nocmd,int nop, double montant_cmd,int delaiLivr_cmd,String etat_cmd
    ,String lieuLivr_cmd,float PrixTotal,String modePaiement) {
        this.nolc = nolc;
        this.nocmd = nocmd;
        this.nop=nop;
        this.montant_cmd = montant_cmd;
        this.delaiLivr_cmd = delaiLivr_cmd;
        this.etat_cmd = etat_cmd;
        this.lieuLivr_cmd = lieuLivr_cmd;
        this. PrixTotal = PrixTotal;
        this.modePaiement = modePaiement;
    }
    public LigneCommande(){
    
}
    public double getMontant_cmd() {
        return montant_cmd;
    }

    public void setMontant_cmd(double montant_cmd) {
        this.montant_cmd = montant_cmd;
    }

    public int getDelaiLivr_cmd() {
        return delaiLivr_cmd;
    }

    public void setDelaiLivr_cmd(int delaiLivr_cmd) {
        this.delaiLivr_cmd = delaiLivr_cmd;
    }

    public String getEtat_cmd() {
        return etat_cmd;
    }

    public void setEtat_cmd(String etat_cmd) {
        this.etat_cmd = etat_cmd;
    }

    public String getLieuLivr_cmd() {
        return lieuLivr_cmd;
    }

    public void setLieuLivr_cmd(String lieuLivr_cmd) {
        this.lieuLivr_cmd = lieuLivr_cmd;
    }

    public float getPrixTotal() {
        return PrixTotal;
    }

    public void setPrixTotal(float PrixTotal) {
        this.PrixTotal = PrixTotal;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public int getNolc() {
        return nolc;
    }

    public void setNolc(int nolc) {
        this.nolc = nolc;
    }

    public int getNocmd() {
        return nocmd;
    }

    public void setNocmd(int nocmd) {
        this.nocmd = nocmd;
    }

    public int getNop() {
        return nop;
    }

    public void setNop(int nop) {
        this.nop = nop;
    }

    
     @Override
    public String toString() {
        return "LigneCommande{" + "nolc=" + nolc + ", nocmd=" + nocmd + ", nop=" + nop 
                +",montant_cmd="+montant_cmd
                +", delaiLivr_cmd"+delaiLivr_cmd 
                +", etat_cmd"+etat_cmd
                +",lieuLivr_cmd"+lieuLivr_cmd
                +", PrixTotal"+PrixTotal
                +", modePaiement"+modePaiement+'}';
    }
    
}
