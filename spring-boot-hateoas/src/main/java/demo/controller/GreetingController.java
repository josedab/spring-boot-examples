package demo.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Greeting;
import demo.service.greeting.GreetingService;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @RequestMapping("/greetings/{number}")
    public List<Greeting> greetings(@PathVariable(value = "number") int number) {
        List<Greeting> greetings = new LinkedList<Greeting>();

        for (int i = 0; i < number; i++) {
            Greeting greeting = greetingService.getGreeting(i);

            // Use of explicit link generation
            greeting.add(linkTo(methodOn(GreetingController.class)
                    .greetingByNumber(number - 1))
                    .withRel("previous"));
            greeting.add(linkTo(methodOn(GreetingController.class)
                    .greetingByNumber(number))
                    .withSelfRel());
            greeting.add(linkTo(methodOn(GreetingController.class)
                    .greetingByNumber(number + 1))
                    .withRel("next"));

            greetings.add(greeting);
        }

        return greetings;
    }

    @RequestMapping("/greetings2/{number}")
    public List<Greeting> greetings2(@PathVariable(value = "number") int number) {
        List<Greeting> greetings = new LinkedList<Greeting>();

        for (int i = 0; i < number; i++) {
            // Rely on explicit link generation
            Greeting greeting = greetingByNumber(i);
            greetings.add(greeting);
        }

        return greetings;
    }

    @RequestMapping("/greeting/{number}")
    public Greeting greetingByNumber(@PathVariable(value = "number") int number) {
        Greeting greeting = greetingService.getGreeting(number);

        greeting.add(linkTo(methodOn(GreetingController.class)
                .greetingByNumber(number - 1))
                .withRel("previous"));
        greeting.add(linkTo(methodOn(GreetingController.class)
                .greetingByNumber(number))
                .withSelfRel());
        greeting.add(linkTo(methodOn(GreetingController.class)
                .greetingByNumber(number + 1))
                .withRel("next"));

        return greeting;
    }
}
