package com.example.authBasic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.authBasic.security.user.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;
    
    // Authentication : User --> Roles
    // protected void configure(AuthenticationManagerBuilder auth) throws
    // Exception {
    // auth.inMemoryAuthentication().passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
    // .withUser("user").password("user").roles("USER").and().withUser("admin").password("admin").roles("USER",
    // "ADMIN");
    // }
    
    // Authorization : Role -> Access httpBasic
    
    // protected void configure(HttpSecurity http) throws Exception {
    // http.httpBasic().and().authorizeRequests().antMatchers("/students/**").hasRole("USER").antMatchers("/**").hasRole("ADMIN").and()
    // .formLogin().loginPage("/login").permitAll().and().logout().permitAll().and().csrf().disable().headers().frameOptions()
    // .disable();
    // }
    
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/login/*").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login")
                .permitAll().and().logout().permitAll();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    
}