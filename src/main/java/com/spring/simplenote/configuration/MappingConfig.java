package com.spring.simplenote.configuration;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MappingConfig {

    @Bean
    public ModelMapper modelMapper(List<Converter> listConverters) {
        ModelMapper modelMapper = new ModelMapper();
        for (Converter converter : listConverters) {
            modelMapper.addConverter(converter);
        }
        return modelMapper;
    }
}