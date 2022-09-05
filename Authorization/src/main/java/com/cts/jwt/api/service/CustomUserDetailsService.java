package com.cts.jwt.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cts.jwt.api.entity.AppUser;
import com.cts.jwt.api.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
   
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = repository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }
    
    public List<AppUser> getUsers(){
		return (List<AppUser>) repository.findAll();		 
	}
    
    public AppUser getUser(String username) throws UsernameNotFoundException{
    	return   repository.findByUserName(username);
    }
public AppUser updateUser(AppUser appUser) {
		
		
		Integer id = appUser.getId();
		AppUser us =  repository.findById(id).orElse(appUser);
		us.setmailId(appUser.getmailId());
		us.setMobile(appUser.getMobile());
		us.setUserName(appUser.getUserName());
		us.setPassword(appUser.getPassword());
		us.setRedgDate(appUser.getRedgDate());
		
		return repository.save(us);
	}
}
