package com.myproject.connections.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




public class SecurityConfigurerAdapter {
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	protected void configure() throws Exception {
		/*
		 * http .authorizeRequests()
		 * .antMatchers("/h2-console/**").hasRole("ADMIN")//allow h2 console access to
		 * admins only .anyRequest().authenticated()//all other urls can be access by
		 * any authenticated role
		 * .and().csrf().ignoringAntMatchers("/h2-console/**")//don't apply CSRF
		 * protection to /h2-console
		 * .and().headers().frameOptions().sameOrigin();//allow use of frame to same
		 * origin urls
		 */    }
}
