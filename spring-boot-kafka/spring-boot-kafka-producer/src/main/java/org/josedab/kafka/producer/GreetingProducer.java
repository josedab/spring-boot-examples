package org.josedab.kafka.producer;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.josedab.kafka.domain.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class GreetingProducer {

    private static Logger logger = LoggerFactory.getLogger(GreetingProducer.class);

    @Value("${kafka.topic}")
    private String kafkaTopic;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Producer<String, String> producer;

    public void sendGreetingToKafka(Greeting greeting) {

        String message;
        try {
            message = objectMapper.writeValueAsString(greeting);
            ProducerRecord<String, String> data = new ProducerRecord<String, String>(kafkaTopic,
                                                                                     message);
            producer.send(data);

        } catch (JsonProcessingException e) {
            logger.error("Error converting the greeting into Json");
        }

    }

}
