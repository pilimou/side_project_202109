package com.web.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.web.entity.AppUserEntity;

@Service
public class SpringUserService implements UserDetailsService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AppUserService appUserService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUserEntity user = appUserService.getAppUser(username);
		List<SimpleGrantedAuthority> simpleGrantedAuthorities = createAuthorities(user.getRoleId());
		return new User(user.getAccount(), user.getPassword(), simpleGrantedAuthorities);
	}
	
	private List<SimpleGrantedAuthority> createAuthorities(String roleStr){
        String[] roles = roleStr.split(",");
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (String role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return simpleGrantedAuthorities;
    }

}
