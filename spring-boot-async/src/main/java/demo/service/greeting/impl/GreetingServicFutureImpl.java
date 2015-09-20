package demo.service.greeting.impl;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import demo.domain.Greeting;
import demo.service.greeting.GreetingService;
import demo.service.greeting.GreetingServiceAsync;

@Service
public class GreetingServicFutureImpl implements GreetingServiceAsync {

    private static final String[] GREETINGS = { "Yo!", "Hello", "Good day", "Hi", "Hey" };

    @Async
    @Override
    public Future<Greeting> getGreeting(int number) {
        
        int module = number % 5;
        simulateSlowService(module * 1000);
        
        return new AsyncResult<Greeting>( 
                    new Greeting(number, GREETINGS[module]));
    }

    // Don't do this at home. Only for demo purposes
    private void simulateSlowService(int timeInMilliseconds) {
        try {
            Thread.sleep(timeInMilliseconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
