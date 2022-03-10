/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.esprit.services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ameni
 * @param <T>
 */
public interface ILigneCommande<T> {
    public void ajouterLigneCommande(T c) throws SQLException;
    public void SupprimerLigneCommande(T c) throws SQLException;
    public void RechercherLigneCommande(T c) throws SQLException;
    public void ModifierLigneCommande(T c) throws SQLException;
    public List<T> afficherLigneCommande() throws SQLException;
    
}
