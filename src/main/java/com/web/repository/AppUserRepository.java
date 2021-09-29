package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.AppUserEntity;

@Repository
public interface AppUserRepository extends JpaRepository<AppUserEntity, String>{
	
	AppUserEntity findByAccount(String account);
}
