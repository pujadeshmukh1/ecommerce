package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Shopping.Exceptions.LoginException;
import com.Shopping.Model.CurrentUserSession;
import com.Shopping.Model.Login;
import com.Shopping.Services.LoginServices;

@RestController
public class LoginController {

	@Autowired
	private LoginServices loginservices;
	
	@PostMapping("/sellerLogin")
	public ResponseEntity<CurrentUserSession> sellerLoginHandler(@Valid @RequestBody Login login) throws LoginException{
		
		CurrentUserSession cust = loginservices.sellerlogin(login);
		
		return new ResponseEntity<CurrentUserSession>(cust,HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/adminLogin")
	public ResponseEntity<CurrentUserSession> adminLoginHandler(@Valid @RequestBody Login login) throws LoginException{
		
		CurrentUserSession cust = loginservices.adminlogin(login);
		
		return new ResponseEntity<CurrentUserSession>(cust,HttpStatus.ACCEPTED);
		
	}
	
	
	
	@PostMapping("/customerLogin")
	public ResponseEntity<CurrentUserSession> customerLoginHandler(@Valid @RequestBody Login login) throws LoginException{
		
		CurrentUserSession cust= loginservices.customerlogin(login);
		
		return new ResponseEntity<CurrentUserSession>(cust,HttpStatus.ACCEPTED);
		
	}
	
	
	
	@DeleteMapping("/Logout")
	public ResponseEntity<String> LogoutHandler(@RequestParam Integer id,@RequestParam String key) throws LoginException{
		
		String message= loginservices.Logout(id, key);
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
}
