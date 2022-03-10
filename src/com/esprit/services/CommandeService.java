/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;
/*import entities.Personne;*/
import com.esprit.entities.Commande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.esprit.utils.Connexion;
/**
 *
 * @author ameni
 */
public class CommandeService implements ICommande <Commande> {

    Connection connexion;
    Statement stm;
    ResultSet rst;
    
    

    public CommandeService() {
        connexion = Connexion.getInstance().getConnexion();
    }

    
    /*@Override
    public void ajouterCommande(Commande c) throws SQLException {
        String req = "INSERT INTO `commande` (`datecmd`, `noclt`) VALUES ( '"
                + c.getDatecmd() + "', '" + c.getNoclt() + "') ";
        stm = connexion.createStatement();
        stm.executeUpdate(req);

    }*/

    @Override
    public void ajouterCommande(Commande c) throws SQLException {
        String req = "INSERT INTO `command` (`id_client`,`id_produit`,`id_commande`,`date_commande`, `adresse`,`prix`,`statut`,) "
                + "VALUES ( ?, ?,?,?,?,?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setDate(1, c.getDate_commande());
        ps.setInt(2, c.getId_commande());
        ps.setInt(2, c.getId_produit());
        ps.setInt(2, c.getId_client());
        ps.setString(2, c.getStatut());
        ps.setFloat(2, c.getPrix());
        ps.setInt(2, c.getId_commande());
        ps.setString(2, c.getAdresse());
        ps.executeUpdate();
    }

   
    @Override
 public void SupprimerCommande(Commande c) throws SQLException {
   String req="DELETE FROM command WHERE date_commande=?";
           PreparedStatement ps = connexion.prepareStatement(req);
           ps.setDate(1, c.getDate_commande());
            ps.executeUpdate();
            
 }
    @Override
 public void RechercherCommande(Commande c) throws SQLException{
  String req="SELECT * FROM command WHERE date_commande="+c.getDate_commande();

            stm=connexion.createStatement();
            rst=stm.executeQuery(req);
            rst.last();
            int nbrRow=rst.getRow();
            if(nbrRow!=1){
                System.out.println("Commande non trouvée");
            }
                 else{
                        System.out.println("Commande trouvée");
                        }
 }
    @Override
 public void ModifierCommande(Commande c) throws SQLException{
 String req="  UPDATE command SET adresse=?,id_produit=?,id_client=?,prix=?,statut=?,id_prix=?,date_commande=?, WHERE id_commande=?";
                    
                   PreparedStatement ps = connexion.prepareStatement(req);
                   ps.setInt(7, c.getId_commande());
                   ps.setDate(6, c.getDate_commande());
                   ps.setString(5, c.getAdresse());
                   ps.setString(4, c.getStatut());
                   ps.setFloat(3, c.getPrix());
                   ps.setInt(2, c.getId_client());
                   ps.setInt(1, c.getId_produit());
                   ps.executeUpdate();
              
 }
    @Override
    public List<Commande> afficherCommande() throws SQLException {
        List<Commande> commandes = new ArrayList<>();
        String req = "select * from command";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Commande c = new Commande(rst.getInt("id_commande"),//or rst.getInt(1)
                    rst.getInt("id_produit"),
                    rst.getInt("id_client"),
                     rst.getDate("date_commande"),
                    rst.getString("adresse"),
                    rst.getString("statut"),
                   
                    
                    rst.getFloat("prix")
                    
                   );
            commandes.add(c);
        }
        return commandes;
    }

    

   
}

    

