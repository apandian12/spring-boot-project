package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Login;
import com.example.demo.repository.LoginRepository;

@Controller
public class LoginController {
 
	@Autowired
	private LoginRepository loginRepository;
	
	@GetMapping("/Signup")
	public String signupform(Model model) {
		model.addAttribute("login", new Login());
		return "signup_form";
	}
	
	@PostMapping("/register")
	public String saveLogin(Login login) {
		loginRepository.save(login);
		return "sucess";
	}
}
