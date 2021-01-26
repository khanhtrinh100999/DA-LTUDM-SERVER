/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuce.edu.ltudm.demo.config;

import nuce.edu.ltudm.demo.services.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@Configurable
@EnableWebSecurity
// Modifying or overriding the default spring boot security.
public class WebConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AppUserDetailsService appUserDetailsService;

	// This method is for overriding the default AuthenticationManagerBuilder.
	// We can specify how the user details are kept in the application. It may
	// be in a database, LDAP or in memory.

    /**
     *
     * @param auth
     * @throws Exception
     */

	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurerAdapter() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**").allowedOrigins("http://localhost:4200");
	          
	        }
	    };
	}
        @Bean
        public UserDetailsService userDetailService (){
            return new AppUserDetailsService();
        }
        @Bean 
        public BCryptPasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService()).passwordEncoder(passwordEncoder());
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
                .csrf().disable()
                .httpBasic().and()
		// starts authorizing configurations
		.authorizeRequests()
		// ignoring the guest's urls "
                 .antMatchers(HttpMethod.OPTIONS , "/**").permitAll()
		.antMatchers("/account/register","/account/login","/logout").permitAll()
		.antMatchers("/account/test","/detail/add","/detail/all/*","/detail/delete/*","/detail/put/*","/detail/get/*").permitAll()
                .antMatchers("/wallet/add","/wallet/get/*","/wallet/put/*").permitAll()
                // authenticate all remaining URLS
		.anyRequest().authenticated();
      
	}

}
