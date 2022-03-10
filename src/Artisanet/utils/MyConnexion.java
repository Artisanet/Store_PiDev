/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Artisanet.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author nourb
 */
public class MyConnexion {
  final String URL="jdbc:mysql://localhost:3306/artisanet";
    final String USER="root";
    final String PWD="";
    private static Connection cnx;
    private static MyConnexion instance; 
    
    
private MyConnexion(){
    try{
    cnx=DriverManager.getConnection(URL,USER,PWD);
    System.out.print("connextion etablie avec succes! ");
    } catch (SQLException ex){
    System.out.print(ex.getMessage());
    }
}
 public static MyConnexion getInstance(){
     if(instance== null){
        instance = new MyConnexion();
     }
  return instance;
}
public static Connection getCnx(){
    return cnx;
}

  

   


}

