package com.ventasChamo.backend.app.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GrantedAuthorityMixin {

	@JsonCreator
	public GrantedAuthorityMixin(@JsonProperty("authority") String role) {
		
	}
	
}
