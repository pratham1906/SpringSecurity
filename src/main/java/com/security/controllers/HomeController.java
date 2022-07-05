package com.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping("/home")
	@ResponseBody
	public String home() {
		return "this is home page";
	}
	
	@GetMapping("/signin")
	public String signin() {
		return "login";
	}
	@GetMapping("/register")
	@ResponseBody
	public String register() {
		return "this is register page";
	}
}
