package com.example.MovieApplication.jwt;

import com.example.MovieApplication.Repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        final String jwtToken;
        final String username;

        if(authHeader == null || !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }

        //Extract JWT token from header...

        jwtToken = authHeader.substring(7);
        username = jwtService.extractUsername(jwtToken);

        //Check if have a username and no authentication exsist yet.

        if (username!= null && SecurityContextHolder.getContext().getAuthentication() == null){

            var userdetails = userRepository.findByUsername(username)
                    .orElseThrow(()-> new RuntimeException("User not found"));

            //validate token

            if (jwtService.isTokenValid(jwtToken, userdetails)){
                //create authentication with user roles

                List<SimpleGrantedAuthority> authorities = userdetails.getRoles().stream()
                        .map(SimpleGrantedAuthority:: new).collect(Collectors.toList());

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userdetails,null,authorities);

                //set the authentication details
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                //Update security context
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);

    }
}
