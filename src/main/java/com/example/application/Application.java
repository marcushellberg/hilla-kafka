package com.example.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.Map;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@Theme(value = "hilla-reactive-kafka")
@Configuration
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

    @Value("${topic.name}")
    private String topicName;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    NewTopic chatTopic() {
        return TopicBuilder
                .name(topicName)
                .partitions(1)
                .replicas(1)
                .build();
    }

}
