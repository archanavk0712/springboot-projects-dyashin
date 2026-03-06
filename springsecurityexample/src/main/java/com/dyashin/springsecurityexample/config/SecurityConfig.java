package com.dyashin.springsecurityexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.authentication.AuthenticationProviderBeanDefinitionParser;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dyashin.springsecurityexample.filter.JwtFilter;

//own configuration for spring security
@Configuration

//Tells the spring to use our configuration instead of the default one
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		//builder design pattern
		return httpSecurity
				.csrf(customizer -> customizer.disable()) // disable csrf
				.authorizeHttpRequests(req -> req
						.requestMatchers("register","login")
						.permitAll()	//only the register and login apis will be permitted the rest will be authenticated
						.anyRequest().authenticated()) // authenticate the site

				// form login is implemented with defaults
//				.formLogin(Customizer.withDefaults()) // login form visible in browser
				.httpBasic(Customizer.withDefaults()) // to get the output in postman

				// Stateless = Spring Security will not create or use HttpSession
				// we are making it stateless , i.e do not create HttpSession (or) do not store authentication in session (or) every request must authenticate again
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class )
				.build(); // build() returns the object of the securityChain
	}
	
	//returning our own userdetailservice
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		UserDetails user1= User
//				.withDefaultPasswordEncoder()
//				.username("arc")
//				.password("123")
//				.roles("user")
//				.build();
//		
//		UserDetails user2= User
//				.withDefaultPasswordEncoder()
//				.username("abc")
//				.password("456")
//				.roles("admin")
//				.build();
//				
//		return new InMemoryUserDetailsManager(user1, user2);
//	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		//authentication provider for database
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
}
