package org.josedab.kafka.producer;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.josedab.kafka.domain.Greeting;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class GreetingProducerTest {

    private static final String KAFKA_TOPIC = "greeting.stream";
    private static final String GREETING_SERIALIZED_BODY = "{\"id\":1444428532713,\"content\":\"Current timestamp for the greeting is 1444428532713\"}";
    
    @Mock
    private Greeting greeting;
    
    @Mock
    private Future<RecordMetadata> futureGreetingResult; 
    
    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private Producer<String, String> producer;

    @InjectMocks
    private GreetingProducer greetingProducer;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(greetingProducer, "kafkaTopic", KAFKA_TOPIC);
    }
    
    @Test
    public void givenGreetingSent_whenSerializedObject_sendsMessageToKafka() throws JsonProcessingException {
        when(producer.send(any(ProducerRecord.class))).thenReturn(futureGreetingResult);
        when(objectMapper.writeValueAsString(greeting)).thenReturn(GREETING_SERIALIZED_BODY);
        
        greetingProducer.sendGreetingToKafka(greeting);
        
        verify(producer).send(any(ProducerRecord.class));

    }

    @Test
    public void givenGreetingSent_whenSerializeObjectFails_noMessageToKafkaIsSent()
            throws JsonProcessingException {
        when(objectMapper.writeValueAsString(greeting)).thenThrow(JsonProcessingException.class);
        greetingProducer.sendGreetingToKafka(greeting);
        
        verifyZeroInteractions(producer);
    }
}
