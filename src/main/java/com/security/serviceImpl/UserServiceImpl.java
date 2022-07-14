package com.security.serviceImpl;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.entity.User;
import com.security.payload.UserDto;
import com.security.userreposiory.UserRepo;
import com.security.userservice.UserService;



@Service
public class UserServiceImpl implements UserService  {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;

	public UserDto registerUser(UserDto userDto) {
		
		 User user = User.builder()
			     // .enabled(true)
			      .userName(userDto.getUserName())
			      .userPassword(passwordEncoder.encode(userDto.getUserPassword()))
			      .userRole("user")
			      .userEnable(1)
			      .build();
		
		
		
//		User user=this.modelMapper.map(userDetails,User.class);
//		String password2=userDetails.getUserPassword();
//		String password1=passwordEncoder.encode(password2);
//		userDetails.setUserPassword(password1);
		System.out.println("Inside Service Impl");
		User userSaved=this.userRepo.save(user);
		UserDto userDtos=this.modelMapper.map(userSaved,UserDto.class);
		return userDtos;
	}
	
}
