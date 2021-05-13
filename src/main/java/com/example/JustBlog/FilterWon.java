package com.example.JustBlog;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/won")
public class FilterWon implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        PrintWriter out = response.getWriter();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (login.equals("alibi") && password.equals("123"))
            chain.doFilter(request, response);
        else
            out.println("Sorry. you don't won anything");
    }
}
