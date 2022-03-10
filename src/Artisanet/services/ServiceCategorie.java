/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Artisanet.services;

import Artisanet.models.Categorie;
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
public class ServiceCategorie implements ICategorie<ICategorie> {
    Connection connexion;
    Statement stm;

    
    public ServiceCategorie() {
        connexion = MyConnexion.getInstance().getCnx();
    }

    public void ajouterCat(Categorie cat) throws SQLException {
        Statement stm;
        stm = connexion.createStatement();
        String req = "INSERT INTO `categorie` (`nom`) VALUES ( '"
                + cat.getNom_cat() + "') ";

        PreparedStatement sp = connexion.prepareStatement(req);
        sp.setString(1, cat.getNom_cat());
        sp.executeUpdate();
    }
      
    public List<Categorie> afficherCategorie() throws SQLException {
        List<Categorie> categorie = new ArrayList<>();
        String req = "select * from categorie";
        stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Categorie cat = new Categorie(
                    rst.getInt("id_cat"),
                    rst.getString("nom"));
            categorie.add(cat);}
        return categorie;
    }
 
     
}
