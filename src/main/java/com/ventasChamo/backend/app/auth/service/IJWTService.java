package com.ventasChamo.backend.app.auth.service;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.jsonwebtoken.Claims;

public interface IJWTService {

	public String create(Authentication auth) throws JsonProcessingException;
	
	public boolean valid(String token);
	
	public Claims getPayloads(String token);
	
	public String getUsername(String token);
	
	public Collection<? extends GrantedAuthority> getRoles(String token) throws JsonMappingException, JsonProcessingException;
	
}
