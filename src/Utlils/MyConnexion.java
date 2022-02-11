/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author raslen
 */
public class MyConnexion {
   final String URL="jdbc:mysql://127.0.0.1:3306/Artisanet";
    final String USER ="root";
    final String PWD ="";
  private static Connection cnx ;
  private static MyConnexion instance ;
  

    private  MyConnexion() {
    
       try {
                cnx = DriverManager.getConnection(URL, USER, PWD);
                System.out.println("connexion etablie ......");
        } catch (SQLException ex) {
           
           System.out.println(ex.getMessage());
        }
    }
  public static MyConnexion getInstance(){
      
      if (instance == null){
            instance = new MyConnexion();
        }
      
      return instance;
  }
         public static Connection getCnx (){
             return cnx;
         }
  
}