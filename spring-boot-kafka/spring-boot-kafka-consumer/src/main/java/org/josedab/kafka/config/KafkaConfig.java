package org.josedab.kafka.config;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class KafkaConfig {

    @Value("${zookeeper.quorum:localhost:2181}")
    private String zookeeperConnect;
    
    @Value("${kafka.brokers}")
    private String kafkaBrokers;
    
    @Bean
    public Consumer<String, String> consumer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", kafkaBrokers);
        properties.put("zookeeper.connect", zookeeperConnect);
        properties.put("group.id", "stream-0");
        properties.put("zookeeper.session.timeout.ms", "400");
        properties.put("zookeeper.sync.time.ms", "200");
        properties.put("auto.commit.interval.ms", "1000");
        Consumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
        return kafkaConsumer;
    }
    
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
