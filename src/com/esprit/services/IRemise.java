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
public interface IRemise<T> {
    public void AjouterRemise(T r)throws SQLException;
    public List<T>ConsulterRemise()throws SQLException;
    public void SupprimerRemise(T r)throws SQLException;
    public float selectPrix(int id)throws SQLException;
     public int selectId_remise(int id_remise)throws SQLException;
     public float selectPourcentage(int id_remise)throws SQLException;
     public List<T> afficherRemise() throws SQLException;
}

