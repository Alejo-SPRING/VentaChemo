package com.ventasChamo.backend.app.auth.service;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ventasChamo.backend.app.auth.GrantedAuthorityMixin;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTServiceImpl implements IJWTService{

	public static final Key SECRET_KEY = new SecretKeySpec("alguna.clave.radom.segura.123456789".getBytes(), SignatureAlgorithm.HS256.getFamilyName()); 
	public static final String PREFIX_TOKEN = "Bearer ";
	
	@Override
	public String create(Authentication auth) throws JsonProcessingException {
		Claims payloads = Jwts.claims();
		payloads.put("Authorities", new ObjectMapper().writeValueAsString(auth.getAuthorities()));
		String token = Jwts.builder()
				.setClaims(payloads)
				.setSubject(auth.getName())
				.signWith(SECRET_KEY)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 190000 * 6))
				.compact();
		return token;
	}

	@Override
	public boolean valid(String token) {
		try {
			getPayloads(token);
			return true;
		} catch (JwtException e) {
			return false;
		}
	}

	@Override
	public Claims getPayloads(String token) {
		Claims payloads = Jwts.parserBuilder()
				.setSigningKey(SECRET_KEY)
				.build()
				.parseClaimsJws(token.replace(PREFIX_TOKEN, ""))
				.getBody();
		return payloads;
	}

	@Override
	public String getUsername(String token) {
		return getPayloads(token).getSubject();
	}

	@Override
	public Collection<? extends GrantedAuthority> getRoles(String token) throws JsonMappingException, JsonProcessingException {
		Object roles = getPayloads(token).get("Authorities");
		Collection<? extends GrantedAuthority> roles2 = Arrays.asList(new ObjectMapper().addMixIn(SimpleGrantedAuthority.class, GrantedAuthorityMixin.class).readValue(roles.toString(), SimpleGrantedAuthority[].class));
		return roles2;
	}

}
