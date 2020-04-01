package com.airlines.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.airlines.model.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserDetailService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new PasswordEncoder() {

			@Override
			public String encode(CharSequence charseq) {
				// TODO Auto-generated method stub
				return charseq.toString();
			}

			@Override
			public boolean matches(CharSequence arg0, String arg1) {
				// TODO Auto-generated method stub
				return true;
			}
			
		});
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
            .antMatchers("/", "/home", "/index").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
        .failureUrl("/login?error")
        	.permitAll()
        	.and()
        .logout()
        	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        	.logoutSuccessUrl("/")
        	.invalidateHttpSession(true)
            .permitAll();
    
    http.csrf().disable();
	}

	
	
}
