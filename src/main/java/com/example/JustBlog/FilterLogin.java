package com.example.JustBlog;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/login")
public class FilterLogin implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        PrintWriter out = response.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        req.setAttribute("username", username);
        req.setAttribute("password", password);
        response.getWriter().write(req.getParameter("username"));

        if(username.equals("admin"))
            out.println("You are Admin");
        else
            req.getRequestDispatcher("result.jsp").forward(req, response);
            chain.doFilter(request, response);

    }
}
