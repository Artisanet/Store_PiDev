/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.entities.Commande;
import com.esprit.entities.panier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.esprit.utils.Connexion;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author pc doctor
 */
public class PanierService implements IPanier <panier> {

    Connection connexion;
    Statement stm;
    ResultSet rst;


    public PanierService() {
       connexion = Connexion.getInstance().getConnexion();
    }
    @Override
    public void ajouterPanier(panier p) throws SQLException {
        String req = "INSERT INTO `panier` ('nop','libelle','quantite','prix_produit','prix') "
                + "VALUES ( ?, ?,?,?,?,?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1, p.getNop());
        ps.setString(2, p.getLibelle());
        ps.setInt(3, p.getQuantite());
        ps.setFloat(4, p.getPrix_produit());
        ps.setFloat(5, p.getPrix());
        ps.executeUpdate();
    }
   
    @Override
 public void SupprimerProduitPanier(panier p) throws SQLException {
   String req="Delete FROM panier WHERE libelle=?";
           PreparedStatement ps = connexion.prepareStatement(req);
           ps.setString(1, p.getLibelle());
            ps.executeUpdate();
            
            
 }
 /*@Override
    public void SupprimerProduitPanier(Produit p,Client c) throws SQLException {
       
            String req= "DELETE FROM panier WHERE nop=? AND id_client=?";
            PreparedStatement ps = connexion.prepareStatement(req);
            int nop = getNop(p);
            ps.setInt(1, c.getId_client());
            ps.setInt(2, nop);
            ps.executeUpdate();
            System.out.println("Produit du panier");
        }*/
     @Override
 public void ModifierPanier(panier p) throws SQLException{
 String req="  UPDATE commande SET nop=?,libelle=?,quantite=?,prix_produit=?,prix=? WHERE nopanier=?";
                    
                   PreparedStatement ps = connexion.prepareStatement(req);
                   ps.setInt(6, p.getNopanier());
                   ps.setInt(5, p.getNop());
                   ps.setString(4, p.getLibelle());
                   ps.setInt(3, p.getQuantite());
                   ps.setFloat(2, p.getPrix_produit());
                   ps.setFloat(1, p.getPrix());
                   ps.executeUpdate();
              
 }
    @Override
 public void ModifierQuantitePanier(panier p) throws SQLException{
 String req="  UPDATE panier SET quantite=? WHERE nop=?AND nopanier=? ";
                    
                   PreparedStatement ps = connexion.prepareStatement(req);
                   ps.setInt(1, p.getQuantite());
                   ps.setInt(2, p.getNopanier());
                   ps.setInt(3, p.getNop());
                   ps.setString(4, p.getLibelle());
                   ps.setFloat(5, p.getPrix_produit());
                   ps.setFloat(6, p.getPrix());
                   ps.executeUpdate();
                   modifierPrixTotal(p);
              
 }
  
  @Override
    public List<panier> afficherPanier() throws SQLException {
        List<panier> paniers = new ArrayList<>();
        String req = "select * from panier";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            panier p = new panier(rst.getInt("nopanier"),//or rst.getInt(1)
                    rst.getInt("nop"),
                    rst.getString("libelle"),
                    rst.getInt("quantite"),
                    rst.getFloat("prix_produit"),
                    rst.getFloat("prix"));
            paniers.add(p);
        }
        return paniers;
    }
    
    @Override
    public int NombreProduit() throws SQLException{
       int nbp=0;
        
            String req= "SELECT * FROM panier ";
            
            stm = connexion.createStatement();
            ResultSet rst = stm.executeQuery(req);
            while(rst.next())
            {
            nbp++;
            }
       return nbp;
    }
    @Override
    public float PrixPanier()throws SQLException {
        float total=0;
          String req= "SELECT * FROM panier ";
           PreparedStatement ps = connexion.prepareStatement(req);
            ResultSet rst = stm.executeQuery(req);
            
            while(rst.next())
            {
                float tot = rst.getFloat("prix_produit");
                total= total+tot;
            }   
        return total;
    }
         /*  public float calcultotalpanier(int nopanier) throws SQLException{
          
           String  req="SELECT SUM(`prix_produit`) FROM `panier` WHERE `nopanier`='"+nopanier+"'";
           float Total=0;
            stm = connexion.createStatement();
           ResultSet rst = stm.executeQuery(req); 
            while(rst.next()){
            Total =  (rst.getFloat(nopanier));
        }   
            return Total;
        }*/
    @Override
    public void modifierPrixTotal(panier p)throws SQLException {

        
            String req= "UPDATE panier SET prix=? WHERE nop=? AND nopanier=? ";
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setFloat(1, p.getQuantite()*p.getPrix() );
            ps.setInt(2, p.getNop());
            ps.setInt(3, p.getNopanier());
            
            ps.executeUpdate();
            System.out.println("Prix total mise à jour");
    }
     
    
    @Override
    public void ViderPanier(panier p) throws SQLException{
        
            String req= "TRUNCATE TABLE panier ";
            stm = connexion.createStatement();
             rst = stm.executeQuery(req);
            System.out.println("Panier vidé");
        
    }

   
   
}
