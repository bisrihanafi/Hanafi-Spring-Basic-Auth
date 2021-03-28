package com.hanafi.join_table.config;

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
public class ConfigurationMyApp extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("hanafi")
                .password(passwordEncoder().encode("hanafi"))
                .roles("ADMIN")
                .and()
                .withUser("eko")
                .password(passwordEncoder().encode("eko"))
                .roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/").hasAnyRole("ADMIN")
                .antMatchers("/buku").hasAnyRole("USER", "ADMIN")
                .and()
                .csrf()
                .disable()
                //in product this is must be enabled
                .headers()
                .frameOptions()
                .disable()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout");

    }


}
