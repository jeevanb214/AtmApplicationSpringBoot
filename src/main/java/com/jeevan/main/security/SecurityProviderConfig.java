package com.jeevan.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.jeevan.main.controller.CustController;

@Configuration // as we want to make this class as configuration(we can configure Spring boot
				// application by the class )
@EnableWebSecurity // it will enable security, basically offers you a configuration DSL/methods.
					// With those methods, you can specify what URIs in your application to protect
					// or what exploit protections to enable/disable.
public class SecurityProviderConfig extends WebSecurityConfigurerAdapter {

	@Autowired // Service class communicates with DAO
	private UserDetailsService userDetailsService;

	@Bean // As we are using the AuthenticationProvider(returning obj) this object bean so we have to
			// annotate as @Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		// here we need to follow configuration class communicate with service class and
		// service with DAO
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http.authorizeRequests().antMatchers("/").hasAnyRole("ADMIN", "USER")
								.antMatchers("/").permitAll()
							    .antMatchers("/balance").hasRole("ADMIN")
							    .antMatchers("/fundtransfer").hasRole("ADMIN")
							    .antMatchers("/withdraw").hasRole("ADMIN")
							    .antMatchers("/customerList").access("hasRole('ADMIN')") //just to know that it is also way to give role
							    .antMatchers("/deposit").permitAll()
							    .antMatchers("/CreateAccount").permitAll()
							    .and().formLogin();		
		}
}
