/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.entities;

/**
 *
 * @author Bayrem
 */
public class Vote {
    
    private int id_vote;
    private int like_vote;
    private int dislike_vote;
    private int id_com;

    public Vote(int id_vote, int like_vote, int dislike_vote, int id_com) {
        this.id_vote = id_vote;
        this.like_vote = like_vote;
        this.dislike_vote = dislike_vote;
        this.id_com = id_com;
    }

    public Vote(int like_vote, int dislike_vote, int id_com) {
        this.like_vote = like_vote;
        this.dislike_vote = dislike_vote;
        this.id_com = id_com;
    }
    
    

    public int getId_vote() {
        return id_vote;
    }

    public void setId_vote(int id_vote) {
        this.id_vote = id_vote;
    }

    public int getLike_vote() {
        return like_vote;
    }

    public void setLike_vote(int like_vote) {
        this.like_vote = like_vote;
    }

    public int getDislike_vote() {
        return dislike_vote;
    }

    public void setDislike_vote(int dislike_vote) {
        this.dislike_vote = dislike_vote;
    }

    public int getId_com() {
        return id_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    @Override
    public String toString() {
        return "Vote{" + "id_vote=" + id_vote + ", like_vote=" + like_vote + ", dislike_vote=" + dislike_vote + ", id_com=" + id_com + '}';
    }
    
    
}
