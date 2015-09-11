package demo.controller;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Greeting;
import demo.service.greeting.GreetingService;

@RestController
@RequestMapping("/aspectcontroller")
public class GreetingAspectController {

    private static final String template = "Hello, %s!";
    private AtomicLong counter = new AtomicLong();

    @Autowired
    @Qualifier("greetingServiceAspectImpl")
    private GreetingService greetingService;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/greeting/{number}")
    public Greeting greetingByNumber(@PathVariable(value = "number") int number) {
        return greetingService.getGreeting(number);
    }
    
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoSuchElementException(NoSuchElementException e) {
        return e.getMessage();
    }
}
