package com.tawseel.clients_server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfigProduction extends WebSecurityConfigurerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfigProduction.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.info("Run PRODUCTION Security Configuration");
        http.requiresChannel().anyRequest().requiresSecure();
        http.cors().and().csrf().disable();
    }

}