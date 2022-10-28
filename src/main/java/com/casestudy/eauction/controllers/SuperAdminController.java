package com.casestudy.eauction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.eauction.configurations.security.SecurityService;
import com.casestudy.eauction.configurations.security.roles.IsSuper;
import com.casestudy.eauction.configurations.security.roles.RoleService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;



@RestController
@RequestMapping("super")
public class SuperAdminController {

	@Autowired
	RoleService securityRoleService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	FirebaseAuth firebaseAuth;

	@GetMapping("user")
	@IsSuper
	public UserRecord getUser(@RequestParam String email) throws Exception {
		return firebaseAuth.getUserByEmail(email);
	}
	
	@GetMapping("data")
	@IsSuper
	public String getSuperData() throws FirebaseAuthException {
		String name = securityService.getUser().getName();
		firebaseAuth.getUser(securityService.getUser().getUid()).getCustomClaims().forEach( (x,Object)-> System.out.println(x));
		return name.split("\\s+")[0] + ", you have accessed super data from spring boot";
	}

}
