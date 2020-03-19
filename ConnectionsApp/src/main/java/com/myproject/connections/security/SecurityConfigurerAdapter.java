package com.myproject.connections.security;

public class SecurityConfigurerAdapter  {

	
	  protected void configure() throws Exception {
	  
		/*
		 * http .authorizeRequests() //allow h2 console access to
		 * .anyRequest().authenticated()//all other urls can be access by any
		 * authenticated role .and().csrf()//don't apply CSRF protection to /h2-console
		 * .and().headers().frameOptions().sameOrigin();//allow use of frame to sam
		 * origin urls
		 */	  }
	 
	
	
	/*
	 * @Bean public UrlBasedCorsConfigurationSource corsConfigurationSource() {
	 * CorsConfiguration configuration = new CorsConfiguration();
	 * configuration.setAllowedOrigins(Arrays.asList("*"));
	 * configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH",
	 * "DELETE", "OPTIONS"));
	 * configuration.setAllowedHeaders(Arrays.asList("authorization",
	 * "content-type", "x-auth-token"));
	 * configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
	 * configuration); return source; }
	 */
}
