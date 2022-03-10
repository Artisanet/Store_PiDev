package com.esprit.tests;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.esprit.entities.Commande;
import com.esprit.entities.LigneCommande;
import java.sql.SQLException;
import com.esprit.services.CommandeService;
import com.esprit.services.LigneCommandeService;

/**
 *
 * @author ameni
 */
public class TestLigneCommande {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        /*Commande lc = new LigneCommande(1,2,3,60,45,"neuf","sousse",40.3f,"à la livraison");*//*ajouter*/
        /*Commande lc = new LigneCommande(1,2,3,60,45,"neuf","sousse",40.3f,"à la livraison");/*supprimer*/
        /*Commande lc = new LigneCommande(1,2,3,60,45,"neuf","sousse",40.3f,"à la livraison");/*modification*/
        
        LigneCommande lc = new LigneCommande(1,2,3,60,45,"neuf","sousse",40.3f,"à la livraison");/*rechercher*/
        LigneCommandeService lcs = new LigneCommandeService();
        /*try {
            lcs.ModifierCommande(lc);
            System.out.println("Commande modifié avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
        try {
            lcs.RechercherLigneCommande(lc);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        /*try {
            lcs.ajouterLigneCommande(lc);
            System.out.println("ajout avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
        /*try {
            lcs.SupprimerLigneCommande(lc);
            System.out.println("supprimé avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
        
        try {
            System.out.println(lcs.afficherLigneCommande());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    }
    


    

