package com.josedab.reactiveApi.controller;

import com.josedab.reactiveApi.model.Greeting;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Mono<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return Mono.just(new Greeting(counter.incrementAndGet(),
                String.format(template, name)));
    }

    @RequestMapping("/greetingWithoutCounter")
    public Mono<Greeting> greetingsWithoutCounter(@RequestParam(value = "name", defaultValue = "World") String name) {
        return Mono.just(new Greeting(1,
                String.format(template, name)));
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.POST)
    public
    @ResponseBody
    Mono<Greeting> greetingsWithoutCounter(@Validated Greeting greeting) {
        return Mono.just(greeting);
    }
}


