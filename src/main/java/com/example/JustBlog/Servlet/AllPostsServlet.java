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
import java.util.List;

@WebServlet(name = "AllPostsServlet")
public class AllPostsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostDao postDao = new PostDao();

        try {
            List<Posts> postList = postDao.getPosts();
            request.setAttribute("postList", postList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("posts.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
