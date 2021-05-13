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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        PostDao postDao = new PostDao();

        try {
            Users user = userDao.validate(username, password);

            String direct = "";

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(30*60);
                List<Posts> postList = postDao.getPosts();
                request.setAttribute("postList", postList);
                direct = "index.jsp";
            } else {
                String message = "Incorrect username or password";
                request.setAttribute("message", message);
                direct = "login.jsp";
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(direct);
            dispatcher.forward(request, response);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
