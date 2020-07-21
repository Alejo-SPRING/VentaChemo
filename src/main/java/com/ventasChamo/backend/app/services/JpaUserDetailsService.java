package com.ventasChamo.backend.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ventasChamo.backend.app.model.entity.UsuarioHasRol;
import com.ventasChamo.backend.app.model.entity.UsuarioLogin;

@Transactional(readOnly = true)
@Service
public class JpaUserDetailsService implements UserDetailsService{

	@Autowired
	private IUsuarioLoginService usuarioLoginService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioLogin user = usuarioLoginService.findForUsername(username);
		if(user != null) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			for(UsuarioHasRol rol : user.getUsuarioHasRolList()) {
				authorities.add(new SimpleGrantedAuthority(rol.getAuthority()));
			}
			return new User(user.getId().toString(), user.getPass(), true, true, true, true, authorities);
		}
		return null;
	}

}
