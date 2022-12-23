package com.element.springboot.javaWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate (String username, String password) {
		
		boolean isValidUsername = username.equalsIgnoreCase("element");
		boolean isValidPassword = password.equalsIgnoreCase("eme080ka");
		
		return isValidUsername && isValidPassword;
		
	}
	
}
