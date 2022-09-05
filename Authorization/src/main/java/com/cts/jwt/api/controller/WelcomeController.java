package com.cts.jwt.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.jwt.api.entity.AllAppUsers;
import com.cts.jwt.api.entity.AppUser;
import com.cts.jwt.api.entity.AuthRequest;
import com.cts.jwt.api.entity.JwtResponse;
import com.cts.jwt.api.entity.UserToken;
import com.cts.jwt.api.repository.UserRepository;
import com.cts.jwt.api.service.CustomUserDetailsService;
import com.cts.jwt.api.util.JwtUtil;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private CustomUserDetailsService service;
    
    @Autowired
   private UserRepository repository;
    
    
    
    
    @GetMapping("/save")
    public List<AppUser> save() {

		RestTemplate restTemplate=new RestTemplate();
		 AllAppUsers allAppUser= restTemplate.getForObject("http://localhost:9095/users", AllAppUsers.class);
		System.out.println("asasaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println(allAppUser.getAllAppUser());
		for (AppUser appUser : allAppUser.getAllAppUser()) {
			repository.save(appUser);
		}
		return service.getUsers() ;
    }
    
    @PutMapping("/update")
	public AppUser updateStudent(@RequestBody AppUser appUser)  {
		return  service.updateUser(appUser);	
	}
    @PostMapping("/authenticate")
    public ResponseEntity<UserToken> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        AppUser appuser=service.getUser(authRequest.getUserName());
		return new ResponseEntity<>(new UserToken(appuser.getId(),jwtUtil.generateToken(authRequest.getUserName())),
				HttpStatus.OK);
    }
    
    @RequestMapping(value = "/validate", method = RequestMethod.GET)
	public ResponseEntity<JwtResponse> getValidity(@RequestHeader("Authorization") final String token) {
		String newToken = token.substring(7);
		JwtResponse jwtResponse = new JwtResponse();
		AppUser user=repository.findByUserName(jwtUtil.extractUsername(newToken));
		org.springframework.security.core.userdetails.User userDetails=new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),new ArrayList<>());
		if (jwtUtil.validateToken(newToken,userDetails)) {
			//jwtResponse.setUserName(jwtUtil.extractUsername(newToken));
			jwtResponse.setValid(true);
			//jwtResponse
					//.setUsername((userservice.findById(jwtutil.extractUsername(newToken)).orElse(null).getUsername()));
		} else {
			jwtResponse.setValid(false);
		}
		return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
	}
    
    
    
}
