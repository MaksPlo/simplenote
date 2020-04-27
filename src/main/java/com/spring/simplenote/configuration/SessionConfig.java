package com.spring.simplenote.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.session.data.mongo.JdkMongoSessionConverter;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

import java.time.Duration;

@EnableMongoHttpSession
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {

    public class HttpSessionConfig {

        @Bean
        public JdkMongoSessionConverter jdkMongoSessionConverter() {
            return new JdkMongoSessionConverter(Duration.ofMinutes(30));
        }
    }
}
