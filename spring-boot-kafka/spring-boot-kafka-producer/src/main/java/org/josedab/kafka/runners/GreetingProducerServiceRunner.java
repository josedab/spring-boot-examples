package org.josedab.kafka.runners;

import org.josedab.kafka.domain.Greeting;
import org.josedab.kafka.producer.GreetingProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GreetingProducerServiceRunner implements CommandLineRunner {
    
    private static Logger logger = LoggerFactory.getLogger(GreetingProducerServiceRunner.class);
    
    @Autowired
    private GreetingProducer greetingProducer;
    
    @Override
    public void run(String... arg0) throws Exception {

        generateRandomGreetings();
        
    }
    
    private void generateRandomGreetings() {
        for (int i = 0; i < 50; i++) {
            long timestamp = System.currentTimeMillis();
            Greeting greeting = new Greeting(timestamp, 
                                             "Current timestamp for the greeting is " + timestamp);
            
            logger.debug("Sending greeting {}", greeting.getId());
            greetingProducer.sendGreetingToKafka(greeting);
            logger.debug("Sent greeting with id {}", greeting.getId());
            
        }
    }

}
