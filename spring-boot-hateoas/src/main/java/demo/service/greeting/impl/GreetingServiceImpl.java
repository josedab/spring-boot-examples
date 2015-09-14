package demo.service.greeting.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

import demo.domain.Greeting;
import demo.service.greeting.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

    private static final String[] GREETINGS = { "Yo!", "Hello", "Good day", "Hi", "Hey" };

    @Autowired
    private CounterService counterService;

    @Override
    public Greeting getGreeting(int number) {
        
        int module = number % 5;
        return new Greeting(number, GREETINGS[module]);
    }
}
