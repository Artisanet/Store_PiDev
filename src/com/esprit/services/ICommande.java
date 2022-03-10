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
 */
public interface ICommande<T> {
    public void ajouterCommande(T c) throws SQLException;
    public void SupprimerCommande(T c) throws SQLException;
    public void RechercherCommande(T c) throws SQLException;
    public void ModifierCommande(T c) throws SQLException;
    public List<T> afficherCommande() throws SQLException;
    
}
