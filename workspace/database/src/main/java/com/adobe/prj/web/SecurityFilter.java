package com.adobe.prj.web;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

// intercepts all requests comming to JSP page
@WebFilter("*.jsp")
public class SecurityFilter implements Filter {

    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //
        // condition
        // if valid
        chain.doFilter(request, response); // invoke next resource
        // else response.sendRedirect("login.html");
    }
}
