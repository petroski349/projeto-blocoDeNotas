package com.example.blocodenotas.controllers.security.filters;

import com.example.blocodenotas.controllers.security.JWTTokenProvider;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AccessFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("Authorization");
        System.out.println("token -> "+token);
        if (token == null || !JWTTokenProvider.verifyToken(token)) {
            ((HttpServletResponse)response).setStatus(500);
            response.getOutputStream().write("Não autorizado ".getBytes());
        } else {
            chain.doFilter(request, response);
        }
    }
}
