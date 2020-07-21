package com.ventasChamo.backend.app.auth.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ventasChamo.backend.app.auth.service.IJWTService;
import com.ventasChamo.backend.app.model.entity.UsuarioLogin;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	private AuthenticationManager authenticationManager;
	private IJWTService jwtService;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, IJWTService jwtService) {
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
		setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login", "POST"));
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		if(username == null && password == null) {
			try {
				UsuarioLogin user = new ObjectMapper().readValue(request.getInputStream(), UsuarioLogin.class);
				username = user.getCorreo();
				password = user.getPass();
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password, null);
		return authenticationManager.authenticate(authToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String token = jwtService.create(authResult);
		Map<String, Object> body = new HashMap<>();
		body.put("Mensaje", "¡Token creado!");
		body.put("UserDatos", authResult.getName());
		body.put("Token", token);
		response.setHeader("Authorization", token);
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setContentType("application/json");
		response.setStatus(200);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		Map<String, Object> body = new HashMap<>();
		body.put("Mensaje", "¡Error en el usuario o contraseña!");
		response.getWriter().write(new ObjectMapper().writeValueAsString(body));
		response.setContentType("application/json");
		response.setStatus(401);
	}
	
}
