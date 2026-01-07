package com.example.Dynamic_Routes.config;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelJmsConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory factory =
                new ActiveMQConnectionFactory("tcp://localhost:61616");
        factory.setUserName("admin");
        factory.setPassword("admin");
        return factory;
    }

    @Bean
    public JmsComponent jmsComponent(ConnectionFactory connectionFactory) {
        return JmsComponent.jmsComponentAutoAcknowledge(connectionFactory);
    }
}
