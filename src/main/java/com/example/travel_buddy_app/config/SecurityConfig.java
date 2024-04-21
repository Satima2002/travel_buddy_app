package com.example.travel_buddy_app.config;

import com.example.travel_buddy_app.services.CustomUserDetailsServices;
import org.apache.catalina.authenticator.SpnegoAuthenticator;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    CustomUserDetailsServices customUserDetailsServices;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/signup").permitAll() // Public resources
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/signin").permitAll()
                        .anyRequest().authenticated() // All other requests require authentication

                )
                .formLogin(form -> form
                        .loginPage("/signin") // Custom login page
                        .permitAll() // Allow access to login page
                        .successForwardUrl("/home")
                        .defaultSuccessUrl("/home",true).permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/index") // Redirect to home page after logout
                        .permitAll() // Allow access to logout endpoint
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/signin?logout").permitAll()

                );

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{

        auth.userDetailsService(customUserDetailsServices).passwordEncoder(passwordEncoder());

    }
}
