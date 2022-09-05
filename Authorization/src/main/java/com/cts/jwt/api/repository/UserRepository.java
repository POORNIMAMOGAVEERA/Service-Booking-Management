package com.cts.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.jwt.api.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUserName(String username);

	//void save(AppUser appUser);
}
