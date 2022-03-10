/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.panier;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ameni
 */
public interface IPanier<T> {
    public void ajouterPanier(T p) throws SQLException;
    public void SupprimerProduitPanier(T p) throws SQLException;
  
    public int NombreProduit() throws SQLException;
    public float PrixPanier()throws SQLException;
    public void ViderPanier(T p)throws SQLException ;
    public void ModifierPanier(T p)throws SQLException;
    public void modifierPrixTotal(T p)throws SQLException;
    public void ModifierQuantitePanier(T p) throws SQLException;
    /*public float calcultotalpanier(int nopanier)throws SQLException;*/
    public List<T> afficherPanier() throws SQLException;
    
}
