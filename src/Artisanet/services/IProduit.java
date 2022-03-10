/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Artisanet.services;

import Artisanet.models.Produit;
import java.sql.SQLException;
import java.util.List;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author nourb
 */
public interface IProduit<T> {
    public void ajouterPdt(Produit pdt) throws SQLException;
    public List<Produit> afficherProduit() throws SQLException ;
    public Produit rechercher(String nom) throws SQLException ;
    public void updatePdt(Produit pdt) throws SQLException;
    public void supprimerPdt(int id_pdt) throws SQLException;
    public Produit findproduittByNom(String nom)throws SQLException ;
            
 /* public void ajouterPdt(T p) throws SQLException;
    public List<T> afficherPdt() throws SQLException;
    public List<T> updatePdt() throws SQLException;
    public void supprimerPdt() throws SQLException;
    public Produit findpdttById() throws SQLException;
    public Produit findproduittByNom() throws SQLException;
*/

    

    
    
}
