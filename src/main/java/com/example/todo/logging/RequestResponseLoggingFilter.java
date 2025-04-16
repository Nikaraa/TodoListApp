package com.example.todo.logging;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class RequestResponseLoggingFilter extends OncePerRequestFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Logga i dettagli della richiesta
        logger.info("Request Method: {}, Request URI: {}", request.getMethod(), request.getRequestURI());

        // Continuare con la catena di filtri
        filterChain.doFilter(request, response);

        // Logga i dettagli della risposta (dopo che la risposta è stata generata)
        logger.info("Response Status: {}", response.getStatus());
    }
}
