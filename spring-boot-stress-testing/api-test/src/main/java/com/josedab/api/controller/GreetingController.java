package com.josedab.api.controller;

import com.josedab.api.model.Greeting;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/greetingWithoutCounter")
    public Greeting greetingsWithoutCounter(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(1,
                String.format(template, name));
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public @ResponseBody Greeting greetingsWithoutCounter(@Validated Greeting greeting) {
        return greeting;
    }
}


