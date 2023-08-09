package br.com.criandoapi.projeto.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public void configure(HttpSecurity httpSec) throws Exception {
        // Enable h2 console //
        httpSec.headers().frameOptions().disable();
        httpSec.csrf().disable()
                .authorizeHttpRequests()
//                .antMatchers(HttpMethod.POST, "/usuarios/login").permitAll()
                .antMatchers( "/usuarios/**").permitAll();
//                .anyRequest().authenticated().and().cors();
        httpSec.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
