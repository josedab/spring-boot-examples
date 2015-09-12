package demo.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Greeting;
import demo.service.greeting.GreetingService;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

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
