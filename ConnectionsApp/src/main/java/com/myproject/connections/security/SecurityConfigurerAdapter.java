package com.myproject.connections.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.myproject.connections.security.filter.JwtRequestFilter;
import com.myproject.connections.security.serviceimpl.CustomerSecurityServiceImpl;


/*@author Shridha S Jalihal
 * SecurityConfigurerAdapter for Spring Security Implementation
 */
@Configuration
@EnableWebSecurity
public class SecurityConfigurerAdapter extends WebSecurityConfigurerAdapter  {

	@Autowired
	BCryptPasswordEncoder  bCryptPasswordEncoder;
	
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
    private CustomerSecurityServiceImpl custService;
	
	/*Implementation method of WebSecurityConfigurerAdapter for authorization
	 *Provide access to matchers /**, restrict access (basic authentication)
	 *to /api/login
	 *@param http for configuring authorization.
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf()
		.disable()
		.httpBasic()
        .and()
        .authorizeRequests().antMatchers("/api/login/**").authenticated()
        .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().
        sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests().antMatchers("/**").permitAll();
        
		http.headers().frameOptions().disable();
		
		//Adding the jwtFilter before Username and Password AuthenticationFilter
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		http.cors();
    }
	

	/*Implementation method of WebSecurityConfigurerAdapter for authentication
	 *Here custom UserDetailsService is used to authenticate Customer
	 *@auth AuthenticationManagerBuilder to build auth.
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(custService).
		passwordEncoder(bCryptPasswordEncoder);
	}
	
}
