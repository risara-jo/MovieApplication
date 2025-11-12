package com.example.MovieApplication.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Input validation filter to detect and block common injection attack patterns
 * Implements defense-in-depth against SQL injection, XSS, and command injection
 */
@Component
public class InputValidationFilter extends OncePerRequestFilter {

    // Patterns for detecting malicious input
    private static final Pattern SQL_INJECTION_PATTERN = Pattern.compile(
        "('.*(--|;|/\\*|\\*/|xp_|sp_|exec|execute|select|insert|update|delete|drop|create|alter|union|script).*)",
        Pattern.CASE_INSENSITIVE
    );
    
    private static final Pattern XSS_PATTERN = Pattern.compile(
        "(<script|javascript:|onerror=|onload=|<iframe|eval\\(|alert\\()",
        Pattern.CASE_INSENSITIVE
    );
    
    private static final Pattern PATH_TRAVERSAL_PATTERN = Pattern.compile(
        "(\\.\\./|\\.\\.\\\\|%2e%2e/|%2e%2e\\\\)",
        Pattern.CASE_INSENSITIVE
    );

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Check query parameters
        if (request.getQueryString() != null) {
            String queryString = request.getQueryString();
            if (containsMaliciousPattern(queryString)) {
                sendSecurityError(response, "Malicious input detected in query parameters");
                return;
            }
        }

        // Check request URI
        String uri = request.getRequestURI();
        if (containsMaliciousPattern(uri)) {
            sendSecurityError(response, "Malicious input detected in request URI");
            return;
        }

        filterChain.doFilter(request, response);
    }

    private boolean containsMaliciousPattern(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        
        return SQL_INJECTION_PATTERN.matcher(input).find() ||
               XSS_PATTERN.matcher(input).find() ||
               PATH_TRAVERSAL_PATTERN.matcher(input).find();
    }

    private void sendSecurityError(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json");
        response.getWriter().write("{\"error\":\"" + message + "\"}");
    }
}
