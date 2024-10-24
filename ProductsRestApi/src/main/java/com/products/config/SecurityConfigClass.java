package com.products.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigClass {
	
	@Bean
	static PasswordEncoder passencoder() //Encoding the String Value (admin@123) to a Password. 
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
	{ 
		httpSecurity.csrf((csrf)->csrf.disable())        //we dont want to give csrf configurations that's why I disabled it. 
		            .authorizeHttpRequests((authorize)->{
		            authorize.requestMatchers(HttpMethod.POST, "/products/**").hasAnyRole("Admin", "Manager");  //Only Admin and Manager Post The data.
		            authorize.requestMatchers(HttpMethod.PUT, "/products/**").hasRole("Manager"); //Only Manager Update The Product. username("Siddharth")&password("Bhagwan_Jane")
		            authorize.anyRequest().authenticated(); //Only Authenticated Users Should be allowed to Access.
		            
		            }).httpBasic(Customizer.withDefaults());
		return httpSecurity.build();
	}
	
	@Bean
	UserDetailsService userDetailsService()
	{
		UserDetails admin = User.builder()
				.username("Zudio")
				.password(passencoder().encode("admin@123"))
				.roles("Admin")
				.build();
		
		UserDetails user1 = User.builder()
				.username("Kp")
				.password(passencoder().encode("Kp@123"))
				.roles("User")
				.build();
		
		UserDetails manager = User.builder()
				.username("Siddharth")
				.password(passencoder().encode("Bhagwan_Jane"))
				.roles("Manager")
				.build();
		
		return new InMemoryUserDetailsManager(admin, user1, manager);
		
		
	}

}
