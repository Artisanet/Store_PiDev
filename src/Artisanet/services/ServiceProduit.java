/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Artisanet.services;

import Artisanet.models.Produit;
import Artisanet.utils.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nourb
 */
public class ServiceProduit implements IProduit<Produit> {
    Connection connexion;
    Statement stm;

    public ServiceProduit() {
       connexion = MyConnexion.getInstance().getCnx();
    }
     public void ajouterPdt(Produit pdt) throws SQLException {
        stm = connexion.createStatement();
        String req = "INSERT INTO produit (nom_pdt, prix,description,stock, icone) VALUES(?,?,?,?,?) ";
PreparedStatement sp = connexion.prepareStatement(req);
sp.setString(1, pdt.getNom_pdt());
sp.setFloat(2, pdt.getPrix());
sp.setString(3, pdt.getDescription());
sp.setInt(4, pdt.getStock());
sp.setString(5, pdt.getIcone());
sp.executeUpdate();
        }
    
    
    @Override
    public List<Produit> afficherProduit() throws SQLException {
        List<Produit> produit = new ArrayList<>();
        String req = "select * from produit";
        stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Produit p = new Produit(
                    rst.getInt("id_pdt"),
                    rst.getString("nom_pdt"),
                    rst.getFloat("prix"),
                    rst.getString("description"),
                    rst.getInt("stock"),
                    rst.getString("icone")
            );
            produit.add(p);
        }
        return produit;
    }
    
    /**
     *
     * @param pdt
     * @throws SQLException
     */
    public Produit rechercher(String nom) throws SQLException {
        
        Produit pdt = new Produit();
        String query = "SELECT * FROM produit where nom_pdt='" + nom + "'";

        ResultSet rs = stm.executeQuery(query);
        while (rs.next()) {
            pdt.setId_pdt(rs.getInt("id_pdt"));
            pdt.setNom_pdt(rs.getString("name"));
            pdt.setPrix(rs.getInt("prix")); 
            pdt.setDescription(rs.getString("description"));
            pdt.setStock(rs.getInt("stock"));
            pdt.setDescription(rs.getString("description"));
            pdt.setIcone(rs.getString("icone"));
 }
        return pdt;
    }
     
 public void updatePdt(Produit pdt) throws SQLException {
    
    /*  String req = "update produit set nom=?, prix=?, description=?,stock=?,icone=? where id=?";
        try {
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setString(1, pdt.getNom_pdt());
            ps.setFloat(2, pdt.getPrix());
            ps.setString(3, pdt.getDescription());
            ps.setInt(4, pdt.getStock());
            ps.setString(5, pdt.getIcone());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }*/

  }
  public void supprimerPdt(int idp) throws SQLException {
         String req = "delete from produit where Id=?";
        try {
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setInt(1,idp);
            ps.executeUpdate();
            System.out.println("Produit supprimée avec succées");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

 /* public void findPdttById(Produit p) {
        Produit pdt = new Produit();
        String req = "select * from produit where Id=?";
        try {
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setInt(1, id_produit);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                pdt.setId_pdt(resultat.getInt(1));
                pdt.setNom_pdt(resultat.getString(2));
                pdt.setPrix(resultat.getFloat(3));
                pdt.setDescription(resultat.getString(4));
                pdt.setStock(resultat.getInt(5));
                pdt.setIcone(resultat.getString(6));
            }
            return pdt;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du produit " + ex.getMessage());
            return null;
        }
    }*/
   // 
    public Produit findproduittByNom(String nom_pdt) {
        Produit pdt = new Produit();
        String req = "select * from produit where nom_pdt=?";
        try {
            PreparedStatement ps = connexion.prepareStatement(req);
            ps.setString(1, nom_pdt);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                pdt.setId_pdt(resultat.getInt(1));
                pdt.setNom_pdt(resultat.getString(2));
            }
            return pdt;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du produit " + ex.getMessage());
            return null;
        }
    }

   
   
   
    

}
