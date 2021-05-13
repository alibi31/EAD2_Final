package com.example.JustBlog.Dao;

import com.example.JustBlog.Entity.Comments;
import com.example.JustBlog.Entity.Posts;
import com.example.JustBlog.Entity.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
    private Connection getConnection() throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JavaEE_Endterm", "postgres", "alibi2001");
        return con;
    }

    public List<Posts> getPosts()
            throws SQLException, ClassNotFoundException {
        List<Posts> posts = new ArrayList<>();
        UserDao userDao = new UserDao();

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM posts");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int posid = rs.getInt("postid");
            String theme = rs.getString("theme");
            String body = rs.getString("body");
            int userId = rs.getInt("userid");
            Users user = userDao.getUserById(userId);

            Posts post = new Posts(posid,userId,theme,body,user);
            posts.add(post);
        }

        rs.close();
        ps.close();
        con.close();

        return posts;
    }

    public boolean newPost(Posts post) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO posts (theme, body, userid) " +
                    "VALUES (?, ?, ?)");

            ps.setString(1, post.getTheme());
            ps.setString(2, post.getBody());
            ps.setInt(3,post.getUserid());

            ps.executeUpdate();
            con.close();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Posts getPostById(Integer id) throws SQLException, ClassNotFoundException {

        UserDao userDao = new UserDao();

        Connection con = getConnection();

        Posts post = new Posts();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM posts WHERE postid = ? LIMIT 1");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        post.setUserid(rs.getInt("userid"));
        post.setTheme(rs.getString("theme"));
        post.setBody(rs.getString("body"));
        post.setUsers(userDao.getUserById(rs.getInt("userid")));
        post.setUserid(id);
        post.setComments(getAllByPostId(id));

        return post;
    }

    public List<Comments> getComments()
            throws SQLException, ClassNotFoundException {
        List<Comments> comments = new ArrayList<>();
        UserDao userDao = new UserDao();

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM comments");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("commentid");
            int likes = rs.getInt("likes");
            int dislikes = rs.getInt("dislikes");
            int postId = rs.getInt("postid");
            int userId = rs.getInt("userid");
            String comment = rs.getString("comment");

            Users user = userDao.getUserById(userId);

            Comments com = new Comments(id,postId,userId,likes,dislikes,comment,user);

            comments.add(com);
        }

        rs.close();
        ps.close();
        con.close();

        return comments;
    }

    public List<Comments> getAllByPostId(Integer pId) throws SQLException, ClassNotFoundException {
        List<Comments> comments = new ArrayList<>();
        UserDao userDao = new UserDao();

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM comments WHERE postid = ?");
        ps.setInt(1, pId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("commentid");
            int likes = rs.getInt("likes");
            int dislikes = rs.getInt("dislikes");
            int postId = rs.getInt("postid");
            int userId = rs.getInt("userid");
            String comment = rs.getString("comment");

            Users user = userDao.getUserById(userId);

            Comments com = new Comments(id,postId,userId,likes,dislikes,comment,user);

            comments.add(com);
        }

        return comments;
    }

    public int newComment(Comments comment) {

        int res = 0;

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO comments (comment, likes, dislikes, postid,userid) " +
                    "VALUES (?, ?, ?, ?, ?)");

            ps.setString(1, comment.getComment());
            ps.setInt(2,comment.getLikes());
            ps.setInt(3, comment.getDislikes());
            ps.setInt(4, comment.getPostid());
            ps.setInt(5, comment.getUserid());

            res = ps.executeUpdate();

            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return res;
    }

    public boolean likeComment(Comments comment) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement("UPDATE comments SET likes = ?, dislikes = ? WHERE commentid = ?");
        ps.setInt(1, comment.getLikes());
        ps.setInt(2, comment.getDislikes());
        ps.setInt(3, comment.getCommentid());

        boolean liked = ps.executeUpdate() > 0;
        ps.close();
        con.close();

        return liked;
    }

    public Comments getCommentById(Integer id) throws SQLException, ClassNotFoundException {

        Connection con = getConnection();

        Comments comment = new Comments();

        PreparedStatement statement = con.prepareStatement("SELECT * FROM comments WHERE commentid = ? LIMIT 1");
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();
        rs.next();

        comment.setCommentid(id);
        comment.setUserid(rs.getInt("userid"));
        comment.setComment(rs.getString("comment"));
        comment.setLikes(rs.getInt("likes"));
        comment.setDislikes(rs.getInt("dislikes"));
        comment.setPostid(rs.getInt("postid"));

        return comment;
    }

}
