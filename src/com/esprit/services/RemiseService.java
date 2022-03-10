/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;


import com.esprit.entities.Remise;
import com.esprit.utils.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ameni
 */

/**
 *
 * @author ameni
 */
public class RemiseService implements IRemise<Remise>{
 
Connection connexion;
    Statement stm;
    ResultSet rst;

    public RemiseService() {
        connexion = Connexion.getInstance().getConnexion();
    }
    
    @Override
    public void AjouterRemise(Remise r) throws SQLException {
       
            String req ="Insert into remise(nop,libelle,pourcentage,ancienPrix,nouveauPrix) values(?,?,?,?)";
            
            PreparedStatement ps = connexion.prepareStatement(req);
            float f = selectPrix(r.getNop());
            float remise = f*r.getPourcentage() ;
            float nvpr =f-remise;
            
            ps.setInt(1, r.getNop());
            ps.setFloat(2, r.getPourcentage());
            ps.setFloat(3, f);
            
            
            ps.setFloat(4,f-remise);
            ps.executeUpdate();
            String req1 ="update produit set nouveauPrix ="+ nvpr + " where nop ="+r.getNop();
            ps.executeUpdate(req1);
       
    }
@Override
    public List<Remise> ConsulterRemise() throws SQLException {
        List<Remise> remises= new ArrayList<>();
        String req = "select * from remise";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Remise r = new Remise(rst.getInt("id_remise"),//or rst.getInt(1)

                    rst.getInt("nop"),
                    rst.getString("libelle"),
                    rst.getFloat("pourcentage"),
                    rst.getFloat("ancienPrix"),
                    rst.getFloat("nouveauPrix"));
            remises.add(r);
        }
        return remises;
    }

    @Override
    public void SupprimerRemise(Remise r) throws SQLException{
        
        
            float pourcentage = selectPourcentage(r.getId_remise());
            int nop= selectId_remise(r.getId_remise());
            
            float var = 1-pourcentage;
            float nvpr =  selectPrix(nop)/var;
            String req = " delete  from remise where id_remise="+r.getId_remise();
            String req1 ="update  produit set nouveauPrix ="+ nvpr + " where nop ="+nop;
            PreparedStatement s = connexion.prepareStatement(req);
            PreparedStatement s1 = connexion.prepareStatement(req1);
        
            s.executeUpdate();
            s1.executeUpdate();
            System.out.println("remise supprimée");
 
    }
 
    @Override
    public float selectPrix(int id_remise) throws SQLException {
       
            String req = "select ancienPrix from remise where id_remise ="+id_remise;
            stm = connexion.createStatement();
            
            rst = stm.executeQuery(req);
            rst.next();
            
            return rst.getFloat("nouveauPrix");
            
        
        
    }

    
    @Override
    public int selectId_remise(int id_remise) throws SQLException {
       
            
            String req = "select nop from remise where id_remise ="+id_remise;
             stm = connexion.createStatement();
            
            rst = stm.executeQuery(req);
            rst.next();
            
            return rst.getInt("nop");
    
    }
@Override
    public float selectPourcentage(int id_remise) throws SQLException {
      
            
            String req = "select pourcentage from remise where id_remise ="+id_remise;
           stm = connexion.createStatement();
        
           rst = stm.executeQuery(req);
            rst.next();
            
            return rst.getFloat("pourcentage");
            
     
    
}
@Override
    public List<Remise> afficherRemise() throws SQLException {
        List<Remise> remises = new ArrayList<>();
        String req = "select * from remise";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Remise r = new Remise(rst.getInt("id_remise"),//or rst.getInt(1)
                    rst.getInt("nop"),
                    rst.getString("libelle"),
                     rst.getFloat("pourcentage"),
                     rst.getFloat("ancienPrix"),
                    rst.getFloat("nouveuPrix"));
            remises.add(r);
        }
        return remises;
    }

    
    

    }
  

