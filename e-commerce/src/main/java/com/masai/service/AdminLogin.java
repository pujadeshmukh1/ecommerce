package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.Login;

public interface AdminLogin {
	
	public String adminLog(Login dto)throws LoginException;

	public String adminLogOut(String key)throws LoginException;

}
