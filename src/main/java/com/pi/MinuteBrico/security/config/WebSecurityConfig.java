package com.pi.MinuteBrico.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.pi.MinuteBrico.services.AppUserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    

    public WebSecurityConfig(AppUserService appUserService,
    		BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.appUserService = appUserService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
           
           http .cors();
           
           http .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/signIn","/user","/missions","/registration/**")  ///"/login","/signIn","/user","/missions",
                    .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
           
           
               
               
        
                /*.and() 
                .rememberMe() 
                .and()
                .logout()
                .logoutUrl("/logout") 
                .logoutSuccessUrl("/login")
                .deleteCookies("remember-me");*/
                    
    }
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }
}
