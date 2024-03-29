package com.erion.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.erion.helpdesk.services.DBService;

@Configuration
@Profile("test")
public class TesteConfig {

    @Autowired
    private DBService dbService;

    public void instanciaDB() {
        this.dbService.instanciaDB();
    }
    
}
