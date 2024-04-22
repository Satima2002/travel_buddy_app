package com.example.travel_buddy_app.config;

import com.example.travel_buddy_app.services.CustomUserDetailsServices;
import org.apache.catalina.authenticator.SpnegoAuthenticator;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer {

    @Autowired
    CustomUserDetailsServices customUserDetailsServices;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {         registry                 .addResourceHandler("/static/**")                 .addResourceLocations("classpath:/static/");     }
        @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        //http.authorizeRequests().antMatchers(HttpMethod.GET, "/js/**", "/css/**", "/img/**" ,"/pressiplus", "/public/**", "/index", "/", "/login").permitAll();
        http
                .authorizeRequests(authorize -> authorize

                        .requestMatchers("/static/**").permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/signup").permitAll() // Public resources
                        .requestMatchers("/signin").permitAll()
                        .requestMatchers("/About").permitAll()
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
                        .logoutSuccessUrl("/signin").permitAll()

                );

        return http.build();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{

        auth.userDetailsService(customUserDetailsServices).passwordEncoder(passwordEncoder());

    }

}
