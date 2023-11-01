package com.example.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("XODIM").password(passwordEncoder().encode("1234")).roles("XODIM")
                .and()
                .withUser("BOLIM").password(passwordEncoder().encode("1234")).roles("BOLIM")
                .and()
                .withUser("DIREKTOR").password(passwordEncoder().encode("1234")).roles("DIREKTOR");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                 csrf().
                 disable().
                 headers().
                 frameOptions().
                 disable()
                 .and().
                 authorizeRequests()
                .antMatchers("bolim/**").hasAnyRole("DIREKTOR")
                .antMatchers("xodim/**").hasAnyRole("BOLIM")
                .antMatchers("pasport/**").permitAll()
                .antMatchers("/hisobot/**").hasAnyRole("DIREKTOR","BOLIM")
                .anyRequest().authenticated()
                .and().httpBasic();
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
