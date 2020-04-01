package com.airlines.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
	
	@GetMapping({ "/", "/index", "/home" })
	public String homePage() {
		return "home";
	}
	
	
	@GetMapping({ "/secure" })
	public String securePage(@AuthenticationPrincipal final UserDetails userdetails, Model model) {
		
		// get user name here ...
		String username = userdetails.getUsername();
		Collection<? extends GrantedAuthority> roles = userdetails.getAuthorities();
		GrantedAuthority arole = roles.stream().findFirst().get();
		String role = arole.toString();
		System.out.println("Role: "+role);
		System.out.println("Username: "+username);
		
		
		//Get person object by email
		model.addAttribute("username", username);
		
				
		if (role.equals("ROLE_USER")) {
			return "user-page";
		} else if (role.equals("ROLE_ADMIN")) {
			return "admin-page";
		} else {
			return "redirect:/home";
		}
	}

}
