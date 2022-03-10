/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author ameni
 */
public class Connexion {
   
    
    final String url ="jdbc:mysql://localhost:3306/pidevv";
    final String login ="root";
    final String pwd="";
    private static Connexion instance;
    Connection connexion;
    
    
    
    private Connexion(){
        
        try {
            connexion =  DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion Bien établie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public static Connexion getInstance(){
    if (instance == null)
        instance = new Connexion();
    return instance;
    }

    public Connection getConnexion() {
        
        return connexion;
    }
    
    
}


