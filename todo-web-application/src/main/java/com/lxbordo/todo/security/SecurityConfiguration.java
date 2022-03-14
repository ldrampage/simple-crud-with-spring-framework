package com.lxbordo.todo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lxbordo.todo.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService userDetailsService;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService);
		
//		auth.inMemoryAuthentication().withUser("test").password(passwordEncoder().encode("test")).roles("USER",
//				"ADMIN");
//		auth.inMemoryAuthentication().withUser("test2").password("test2").roles("USER", "ADMIN");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

//		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers("/", "/*todo*/**", "/*welcome*/**")
//				.hasAnyRole("ADMIN", "USER").and().formLogin();

		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/", "/*todo*/**", "/welcome")
				.hasAnyAuthority("ADMIN", "USER").and().formLogin();

//		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/", "/*todo*/**", "/*welcome*/**")
//				.access("hasRole('USER')").and().formLogin();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
