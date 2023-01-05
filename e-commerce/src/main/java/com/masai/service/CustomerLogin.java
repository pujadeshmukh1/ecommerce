package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.Login;

public interface CustomerLogin {
	
	public String logIntoAccount(Login dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
