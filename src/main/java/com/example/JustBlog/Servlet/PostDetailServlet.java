package com.example.JustBlog.Servlet;

import com.example.JustBlog.Dao.PostDao;
import com.example.JustBlog.Entity.Posts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "PostDetailServlet")
public class PostDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostDao postDao = new PostDao();

        try {
            int postId = 0;

            if (request.getParameter("postId") != null) {
                postId = Integer.parseInt(request.getParameter("postId"));
            }
            Posts post = postDao.getPostById(postId);

            request.setAttribute("post", post);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("postDetail.jsp");
            requestDispatcher.forward(request, response);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
    }
}
