package demo.service.greeting.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

import demo.domain.Greeting;
import demo.service.greeting.GreetingService;

@Service("greetingServiceAspectImpl")
public class GreetingServiceAspectImpl implements GreetingService {

    private static final String[] GREETINGS = { "Yo!", "Hello", "Good day", "Hi", "Hey" };

    @Autowired
    private CounterService counterService;

    @Override
    public Greeting getGreeting(int number) {
        if (number < 1 || number > GREETINGS.length) {
            throw new NoSuchElementException(String.format("No greeting #%d", number));
        }
        return new Greeting(number, GREETINGS[number - 1]);
    }
}
