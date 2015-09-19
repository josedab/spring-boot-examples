package demo.service.greeting;

import java.util.concurrent.Future;

import demo.domain.Greeting;


public interface GreetingServiceAsync {
    public Future<Greeting> getGreeting(int number);
}
