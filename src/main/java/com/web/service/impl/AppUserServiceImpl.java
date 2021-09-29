package com.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.AppUserEntity;
import com.web.repository.AppUserRepository;
import com.web.service.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService{
	
	@Autowired
	private AppUserRepository appUserRepository;

	@Override
	public AppUserEntity getAppUser(String account) {	
		return appUserRepository.findByAccount(account);
	}
	
	
}
