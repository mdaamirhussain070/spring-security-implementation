package com.security.controller;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.User;
import com.security.payload.Contact;
import com.security.payload.UserDto;
import com.security.payload.UserResponse;
import com.security.userservice.UserService;



@RestController
@RequestMapping("/rest")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/home")
	public String home() {
		return "WelCome to Home";
	}
	
	@GetMapping("/getbalance")
	public String getBalance() {
		String bal="Your current balance is 2222000";
		
		return bal;
	}
	@GetMapping("/getstatement")
	public String getStatement() {
		String statement="you statement is sent to your email id";
		return statement;
	}
	
	@GetMapping("/contact")
	public String getContact() {
		String contact="Our team will contact you in your contact Number";
		return contact;
	}
	
	@PostMapping("/registeruser")
//	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<UserResponse> registerUser(@RequestBody  UserDto user) {
		
		System.out.println("Inside HomeController");

		 UserDto userD=this.userService.registerUser(user);
		 
		 UserResponse usr=UserResponse.builder()
				 .UserName(userD.getUserName())
				 .message("User Registred Successfully")
				 .build();
		return new ResponseEntity<>(usr,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/contacts")

	@ResponseStatus(code = HttpStatus.CREATED)
	public String getContactcreate(@RequestBody Contact contact) {
		
		String name=contact.getName();
		String contact1="Our team will contact you in your contact Number   "+name;
		
		return contact1;
	}
	
	
	
	
}
