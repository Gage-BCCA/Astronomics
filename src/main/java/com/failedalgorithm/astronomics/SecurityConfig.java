package com.failedalgorithm.astronomics;

import com.failedalgorithm.astronomics.users.auth.ApiKeyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    ApiKeyFilter apiKeyFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http
                .addFilterBefore(apiKeyFilter, BasicAuthenticationFilter.class); // Add API Key Filter
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}

