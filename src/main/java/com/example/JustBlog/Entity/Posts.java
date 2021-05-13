package com.example.JustBlog.Entity;

import java.io.Serializable;
import java.util.List;

public class Posts implements Serializable {
    private int postid, userid;
    private String theme, body;
    private Users users;
    private List<Comments> comments;

    public Posts(){}

    public Posts(int postid, int userid, String theme, String body, Users users) {
        this.postid = postid;
        this.userid = userid;
        this.theme = theme;
        this.body = body;
        this.users = users;
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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }


}
