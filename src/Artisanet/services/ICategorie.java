/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Artisanet.services;

import Artisanet.models.Categorie;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author nourb
 */
interface ICategorie<T> {
          public void ajouterCat(Categorie cat) throws SQLException ;
          public List<Categorie> afficherCategorie() throws SQLException;

}
