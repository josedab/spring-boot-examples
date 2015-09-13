package demo.service.greeting.impl;

import org.springframework.stereotype.Service;

import demo.domain.Greeting;
import demo.service.greeting.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

    private static final String[] GREETINGS = { "Yo!", "Hello", "Good day", "Hi", "Hey" };

    @Override
    public Greeting getGreeting(int number) {
        
        simulateSlowService();
        
        int module = number % 5;
        return new Greeting(number, GREETINGS[module]);
    }

    // Don't do this at home. Only for demo purposes
    private void simulateSlowService() {
        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
