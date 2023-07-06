package com.nghinc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/")
public class Usercontroller {

	@GetMapping("/")
	public String loginHome() {
		return "user/home";
	}
}
