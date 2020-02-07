package com.ats.rusawebapi.security;
 
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; 

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// Authentication : User --> Roles
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//PasswordEncoder encoder = new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("MD5"); 
		//PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//System.out.println(encoder.encode("Aaryatech@1cr").toString());
		auth.inMemoryAuthentication().passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
				.withUser("user1").password("secret1").roles("USER").and().withUser("aaryatech")
				.password("Aaryatech@1234567").roles("USER", "ADMIN");

	}

	// Authorization : Role -> Access
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests().antMatchers("/**").hasRole("USER").antMatchers("/**")
				.hasRole("ADMIN").and().csrf().disable().headers().frameOptions().disable();
	}
	 

}
