/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.test;

import edu.artisanet.entities.Commentaire;
import edu.artisanet.entities.News;
import edu.artisanet.entities.Reclamation;
import edu.artisanet.entities.Vote;
import edu.artisanet.service.CommentaireCrud;
import edu.artisanet.service.NewsCrud;
import edu.artisanet.service.ReclamationCrud;
import edu.artisanet.service.VoteCrud;
import edu.artisanet.utils.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Bayrem
 */
public class test {
    public static void main(String[] args) throws SQLException{
        
        // public Commentaire(int id_com, String nom_com, String text_com, Date date_com, int id_post) {
        Calendar c = Calendar.getInstance();
        Date d = new Date(c.getTime().getTime());
        
        Commentaire t = new Commentaire("test","test",d,5);
        Commentaire tt = new Commentaire(13,"dfdsdfsdfsdffdf","dfsdfdfdfsdsd",d,5);
        
        Reclamation r = new Reclamation(11,"dfdfdf","fdsfsfd",d,"dfsdfsdf");
        Reclamation rr = new Reclamation(11,"dfdfdfffff","fdfffsfsfd",d,"dfsdfsdf");
        
        
        CommentaireCrud cr = new CommentaireCrud();
        cr.update(t, 1);
        
        ReclamationCrud rc = new ReclamationCrud();
        
     //   rc.updatestatus(2);
     
        Vote v1 = new Vote(1,0,1);
        Vote v2 = new Vote(1,0,1);
        Vote v3 = new Vote(1,0,1);
        Vote v4 = new Vote(1,0,1);
        
        VoteCrud vc = new VoteCrud();
        
      //  vc.addLike(v4);
  //    int x=0;
    //   x = vc.countLike(1);
    //   System.out.println(x);
    
        News n = new News("dfsdfsdf","dfsdfsdfds",d);
        NewsCrud nn = new NewsCrud();
       
        List<News> listnews = new ArrayList<>();
        listnews = nn.getOld();
        for(News elem: listnews){
            
            System.err.println(elem);
        }
                }
    
}
