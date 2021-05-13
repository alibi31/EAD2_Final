package com.example.JustBlog.Entity;

import java.io.Serializable;

public class Comments implements Serializable {
    private int commentid, postid, userid;
    private int likes, dislikes;
    private String comment;
    private Users users;


    public Comments(int commentid, int postid, int userid, int likes, int dislikes, String comment, Users users) {
        this.commentid = commentid;
        this.postid = postid;
        this.userid = userid;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comment = comment;
        this.users = users;
    }

    public Comments(){}

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
