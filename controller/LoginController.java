package com.inn.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inn.ecommerce.global.GlobalData;
import com.inn.ecommerce.model.Role;
import com.inn.ecommerce.model.User;
import com.inn.ecommerce.repo.RoleRepo;
import com.inn.ecommerce.repo.UserRepo;

@Controller
public class LoginController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	@GetMapping("/login")
	public String login() {
		GlobalData.cart.clear();
		return "login";
	}
	
	@GetMapping("/register")
	public String registerGet() {
		return "register";
	}
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException{
		String password = user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepo.findById(2).get());
		user.setRoles(roles);
		userRepo.save(user);
		request.login(user.getEmail(), password);
		return "redirect:/";
	}
//	@PostMapping("/admin-login")
//	public String loginUser(@ModelAttribute("user") User user,@RequestParam("email") String email, @RequestParam("password") String password) {
//	    // Check if email and password match the admin credentials
//	    if (email.equals("admin@gmail.com") && password.equals("123456")) {
//	        // Redirect to adminPanel upon successful login
//	        return "redirect:/adminHome"; 
//	    } else {
//	        // If credentials are incorrect, redirect back to the login page with an error message
//	        return "redirect:/adminLogin?error=true";
//	    }
//	}


}
