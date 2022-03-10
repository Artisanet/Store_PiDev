/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.services;

import com.esprit.entities.LigneCommande;
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
public class LigneCommandeService implements ILigneCommande<LigneCommande> {

    Connection connexion;
    Statement stm;
    ResultSet rst;

    public LigneCommandeService() {
        connexion = Connexion.getInstance().getConnexion();
    }

    @Override
    public void ajouterLigneCommande(LigneCommande lc) throws SQLException {
        String req = "INSERT INTO `lignecommande` ('nolc','nocmd','nop','montant_cmd','delaiLivr_cmd','etat_cmd','lieuLivr_cmd','PrixTotal','modePaiement')"
                + "VALUES ( ?, ?,?,?, ?,?,?, ?,?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1, lc.getNolc());
        ps.setInt(2, lc.getNocmd());
        ps.setInt(3, lc.getNop());
        ps.setDouble(4,lc.getMontant_cmd());
        ps.setInt(5, lc.getDelaiLivr_cmd());
        ps.setString(6, lc.getEtat_cmd());
        ps.setString(7, lc.getLieuLivr_cmd());
        ps.setFloat(8, lc.getPrixTotal());
        ps.setString(9, lc.getModePaiement());
        ps.executeUpdate();

    }

    @Override
    public void SupprimerLigneCommande(LigneCommande lc) throws SQLException {
        String req = "Delete FROM lignecommande WHERE nolc=?";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1, lc.getNolc());
        ps.executeUpdate();

    }

    @Override
    public void RechercherLigneCommande(LigneCommande lc) throws SQLException {
        String req = "SELECT * FROM lignecommande WHERE nolc=" + lc.getNolc();

        stm = connexion.createStatement();
        rst = stm.executeQuery(req);
        rst.last();
        int nbrRow = rst.getRow();
        if (nbrRow != 1) {
            System.out.println("Ligne commande non trouvée");
        } else {
            System.out.println("Ligne commande trouvée");
        }
    }

    @Override
    public void ModifierLigneCommande(LigneCommande lc) throws SQLException {
        String req = "  UPDATE commande SET nocmd=?,nop=?,montant_cmd=?,delaiLivr_cmd=?,etat_cmd=?,lieuLivr_cmd=?,prixTotal=?,modePaiement=? WHERE nolc=?";

        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(9, lc.getNolc());
        ps.setInt(1, lc.getNocmd());
        ps.setInt(2, lc.getNop());
        ps.setDouble(3, lc.getMontant_cmd());
        ps.setInt(4, lc.getDelaiLivr_cmd());
        ps.setString(5, lc.getEtat_cmd());
        ps.setString(6, lc.getLieuLivr_cmd());
        ps.setFloat(7, lc.getPrixTotal());
        ps.setString(8, lc.getModePaiement());
        ps.executeUpdate();
        

    }

    @Override
    public List<LigneCommande> afficherLigneCommande() throws SQLException {
        List<LigneCommande> lignes = new ArrayList<>();
        String req = "select * from lignecommande";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            LigneCommande lc = new LigneCommande(rst.getInt("nolc"),//or rst.getInt(1)

                    rst.getInt("nocmd"),
                    rst.getInt("nop"),
                    rst.getFloat("montant_cmd"),
                    rst.getInt("delaiLivr_cmd"),
                    rst.getString("etat_cmd"),
                    rst.getString("lieuLivr_cmd"),
                    rst.getFloat("PrixTotal"),
                    rst.getString("ModePaiement"));
            lignes.add(lc);
        }
        return lignes;
    }

    
}
