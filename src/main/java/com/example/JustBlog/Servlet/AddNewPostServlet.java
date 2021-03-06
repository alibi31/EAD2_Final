package com.example.JustBlog.Servlet;

import com.example.JustBlog.Dao.PostDao;
import com.example.JustBlog.Dao.UserDao;
import com.example.JustBlog.Entity.Posts;
import com.example.JustBlog.Entity.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AddNewPostServlet")
public class AddNewPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean status;
        PrintWriter out = response.getWriter();
        String theme = request.getParameter("theme");
        String body = request.getParameter("body");
        try {
            Integer userId = Integer.parseInt(request.getParameter("userId"));
            String post = request.getParameter("post");
            Users user = new UserDao().getUserById(userId);

            Posts newPost = new Posts();
            newPost.setTheme(theme);
            newPost.setBody(body);
            newPost.setUserid(userId);
            status = new PostDao().newPost(newPost);
            if(status){
                out.println("<script>alert('Model.Post successfully added!')</script>");
                request.setAttribute("post", post);
                RequestDispatcher dispatcher =request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }else{
                out.println("<script>alert('Error ! This kind of post already exists in the base')</script>");
                response.sendRedirect("index.jsp");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
