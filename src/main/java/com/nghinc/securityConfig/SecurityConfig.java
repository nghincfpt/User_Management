package com.nghinc.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.nghinc.securityConfig.oauth2github.UserOauth2UserServiceGithub;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public AuthenticationSuccessHandler customSuccessHandler;

	@Bean
	public UserDetailsService getUserDetailsService() {
		return new UserDetailServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider getDaoAuProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());

		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(getDaoAuProvider());
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	 http.authorizeHttpRequests()
//	 .antMatchers("/admin/**").hasRole("ADMIN")
//	 .antMatchers("/user/**").hasRole("USER")
//	 .antMatchers("/teacher/**").hasRole("TEACHER")
//	 .antMatchers("/oauth2/**").permitAll()
//	 .antMatchers("/**").permitAll().and().formLogin().loginPage("/signin").loginProcessingUrl("/login")
//	 .successHandler(customSuccessHandler).and().csrf().disable();
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("USER")
				.antMatchers("/teacher/**").hasRole("TEACHER")
				
				.antMatchers("/oauth2/**").permitAll().antMatchers("/**")
				.permitAll().and().oauth2Login().loginPage("/signin").userInfoEndpoint()
				.userService(oauth2UserServiceGithub).and()
				// .and().defaultSuccessUrl("/user/")
				.and().formLogin().loginPage("/signin").loginProcessingUrl("/login")
				.successHandler(customSuccessHandler).and().csrf().disable();
	}

//github
	@Autowired
	private UserOauth2UserServiceGithub oauth2UserServiceGithub;

}
