package com.ventasChamo.backend.app.auth.filter;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.ventasChamo.backend.app.auth.service.IJWTService;
import com.ventasChamo.backend.app.auth.service.JWTServiceImpl;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter{

	private IJWTService jwtService;
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, IJWTService jwtService) {
		super(authenticationManager);
		this.jwtService = jwtService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String token = request.getHeader("Authorization");
		if(token == null || !token.startsWith(JWTServiceImpl.PREFIX_TOKEN)) {
			chain.doFilter(request, response);
			return;
		}
		if(jwtService.valid(token)) {
			String username = jwtService.getUsername(token);
			Collection<? extends GrantedAuthority> authorities = jwtService.getRoles(token);
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
			SecurityContextHolder.getContext().setAuthentication(authToken);
		}
		chain.doFilter(request, response);
	}

}
