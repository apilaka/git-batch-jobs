package com.pilaka.springjwt.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	JwtService jwtService;

	@Override
	protected void doFilterInternal(
			HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain)
			throws ServletException, IOException {
		
		final String authHeader =request.getHeader("Authorization");
		final String jwt;
		final String userEmaail;
		if(authHeader==null||authHeader!="" ||authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
			
		}
		jwt = authHeader.substring(7);
		userEmaail =jwtService.extractUsername(jwt);
		
	 
		
	}

}
