package com.example.JustBlog.Servlet;

import com.example.JustBlog.Dao.PostDao;
import com.example.JustBlog.Entity.Comments;
import com.example.JustBlog.Entity.Posts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LikesServlet")
public class LikesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostDao postDao = new PostDao();

        Boolean isLiked = Boolean.valueOf(request.getParameter("like"));
        Boolean disLiked = Boolean.valueOf(request.getParameter("dislike"));
        Integer commentId = Integer.parseInt(request.getParameter("commentId"));

        try {
            Comments comment = postDao.getCommentById(commentId);
            if (isLiked){
                comment.setLikes(comment.getLikes() + 1);
            postDao.likeComment(comment);}
            else if(disLiked){
                comment.setDislikes(comment.getDislikes() + 1);
                postDao.likeComment(comment);
            }

            Posts post = postDao.getPostById(comment.getPostid());

            request.setAttribute("post", post);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("postDetail.jsp");
            requestDispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
