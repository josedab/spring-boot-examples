package org.josedab.kafka.config;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class KafkaConfig {
    
    @Value("${kafka.brokers}")
    private String kafkaBrokers;

    @Bean
    public Producer<String, String> producer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", kafkaBrokers);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("acks", "1");
        Producer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        return kafkaProducer;
    }
    
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
