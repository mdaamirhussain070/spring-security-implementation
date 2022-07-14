package com.security.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	private DataSource dataSource;
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			

			// default security
//			http.authorizeRequests().anyRequest().authenticated();
//			http.formLogin();
//			http.httpBasic();
			
			// providing customize security
			
			http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/rest/getstatement").authenticated()
			.antMatchers("/rest/getbalance").authenticated()
			.antMatchers("/rest/contact").authenticated()
			.antMatchers("/rest/home").permitAll()
			.antMatchers("/rest/contacts").permitAll()
			.and()
			.formLogin()
			.and()
			.httpBasic()
			.and()
			.logout()
			;
			}
		// In memeory credentials
//			@Override
//			protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//				auth.inMemoryAuthentication()
//					.withUser("hussain").password("password").authorities("admin").and()
//					.withUser("Aamir").password("pass1").authorities("read").and()
//					.withUser("aakif").password("pass123").authorities("read").and()
//					.passwordEncoder(NoOpPasswordEncoder.getInstance());
//			}
		
			// JDBC Authentication 
		
			@Override
			protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				auth.jdbcAuthentication().passwordEncoder(passwordEncoder())
					.dataSource(dataSource)
					.usersByUsernameQuery("select user_name,user_password,user_enable from user where user_name=?")
					
					.authoritiesByUsernameQuery("select user_name,user_role from user where user_name=?")
					;
			}
		
			
			@Bean
			public PasswordEncoder passwordEncoder() {
				return new  BCryptPasswordEncoder();
			}
}
