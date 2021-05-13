package com.example.JustBlog.Servlet;

import com.example.JustBlog.Dao.PostDao;
import com.example.JustBlog.Dao.UserDao;
import com.example.JustBlog.Entity.Comments;
import com.example.JustBlog.Entity.Posts;
import com.example.JustBlog.Entity.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.Comment;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CommentServlet")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        PostDao postDao = new PostDao();

        try {
            int postId = Integer.parseInt(request.getParameter("postId"));
            int userId = Integer.parseInt(request.getParameter("userId"));
            String com = request.getParameter("comment");
            Users user = userDao.getUserById(userId);

            Comments comment = new Comments();
            comment.setComment(com);
            comment.setUserid(userId); // comments post
            comment.setPostid(postId); // author
            comment.setUsers(user);
            comment.setLikes(0);
            comment.setDislikes(0);

            int res = 0;
            if (com != null) {
                res = postDao.newComment(comment);
            }

            Posts post = postDao.getPostById(postId);

            request.setAttribute("post", post);

            System.out.println(res);
            RequestDispatcher dispatcher =request.getRequestDispatcher("postDetail.jsp");
            dispatcher.forward(request, response);


        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
