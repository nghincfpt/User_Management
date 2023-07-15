package com.nghinc.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nghinc.configemail.Utility;
import com.nghinc.exception.UserNotFountException;
import com.nghinc.model.User;
import com.nghinc.service.UsersService;

import net.bytebuddy.utility.RandomString;

@Controller

public class ForgotPasswordController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/forgot_password")
	public String showForgotPasswordForm(Model model) {
	
		model.addAttribute("pageTitle","Forgot Password");
		return "password/forgot_password_form";
	}
	@PostMapping("/forgot_password")
	public String processFormPasswordForm(HttpServletRequest request,
			Model model) {
		String email = request.getParameter("email");
	//kieu in mysql
		String  token = RandomString.make(45);
		System.out.println("Email :" +email);
		System.out.println("Token :" +token);
		
		  try {
			usersService.updateResetPasswordToken(token, email);
			
			String resetPasswordLink=Utility.getSiteURL(request)+"/reset_password?token="+token;

			
			
			sendEmai(email,resetPasswordLink);
			model.addAttribute("message","we have sent a reset password link yo your email, Plean check");
			
		} catch (UserNotFountException ex) {
			model.addAttribute("error",ex.getMessage());
			
		} catch (UnsupportedEncodingException |MessagingException e) {
			
			model.addAttribute("error","Error while sending email.");
		} 
		
			model.addAttribute("pageTitle","Forgot Password");
		return "password/forgot_password_form";
	}
	
	private void sendEmai(String email,String resetPasswordLink )   throws MessagingException, UnsupportedEncodingException {
		 MimeMessage message = mailSender.createMimeMessage();              
		    MimeMessageHelper helper = new MimeMessageHelper(message);
		    
		   helper.setFrom("Nghinc2pd05001@fpt.edu.vn","Nghinc Support");
		   helper.setTo(email);  
		   
		    String subject = "Here's the link to reset your password";
		     
		    String content = "<p>Hello,</p>"
		            + "<p>You have requested to reset your password.</p>"
		            + "<p>Click the link below to change your password:</p>"
		            + "<p><a href=\"" + resetPasswordLink + "\">Change my password</a></p>"
		            + "<br>"
		            + "<p>Ignore this email if you do remember your password, "
		            + "or you have not made the request.</p>";
		     
		    helper.setSubject(subject);
		     
		    helper.setText(content, true);
		     
		    mailSender.send(message);
	}
	
	@GetMapping("/reset_password")
	public String showResetPasswordForm(@Param(value = "token") String token,
			Model model) {
		
		
			User user = usersService.get(token);
		    if (user== null) {
		    	model.addAttribute("title","Reset your password");
				model.addAttribute("message","Invalid Token");
			
					
		      return "message";

			}
		    
		    model.addAttribute("token",token);
			model.addAttribute("pageTitle","Reset your Password");
		    
		    return "password/reset_password_form2";
	}
	
	@PostMapping("/reset_password")
	public String processRessPassword(HttpServletRequest request,Model model) {
		String token = request.getParameter("token");
		
		String password = request.getParameter("password");
		
		User user = usersService.get(token);
		 if (user== null) {
		    	model.addAttribute("title","Reset your password");
				model.addAttribute("message","Invalid Token");
				
		      return "message";
			}else {
				usersService.updatePassword(user, password);
				model.addAttribute("message","You have successfully change your password.");
				
			}
		  return "message";
	}
	
}
