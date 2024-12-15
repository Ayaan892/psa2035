package com.crm.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration                   //configuration class is the ultimate class that  dont need to be called separately it, automatically


public class ConfigClass {
    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();

    }
}
