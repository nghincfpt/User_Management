package com.nghinc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nghinc.model.User;
import com.nghinc.service.UsersService;



@Controller
public class HomeController {

	@Autowired
	private UsersService usersService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/createUser")
	public String createUser(@ModelAttribute User user,HttpSession session ) {

		boolean f = usersService.checkemail(user.getEmail());
		if (f) {
			session.setAttribute("msg", "email is alreday exits");
		} else {

			User userDT = usersService.createUser(user);
			if (userDT != null) {
				session.setAttribute("msg", "Register Successfully");
			} else {
				session.setAttribute("msg", "somethinh wrong on server");
			}
		}
		return "redirect:/register";

	}
}