package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.Login;
import com.masai.service.CustomerLogin;

@RestController
@RequestMapping("/userlogin")
public class UserLoginController {
	
	@Autowired
	private CustomerLogin customerlogin;
	
	@PostMapping("/login")
	public ResponseEntity<String> userLogin(@RequestBody Login dto) throws LoginException{
		
		String lonin= customerlogin.logIntoAccount(dto);
		
		return new ResponseEntity<String>(lonin,HttpStatus.ACCEPTED);
		
	}
	
	
	
	@PostMapping("/logout")
	public ResponseEntity<String> userLogout(@RequestParam(required = false)String key) throws LoginException{
		
		String lonin= customerlogin.logOutFromAccount(key);
		
		return new ResponseEntity<String>(lonin,HttpStatus.ACCEPTED);
		
	}

}
