package com.josedab.reactive;

import com.josedab.reactive.greetings.GreetingWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingsReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreetingsReactiveApplication.class, args);
        GreetingWebClient gwc = new GreetingWebClient();
        System.out.println(gwc.getResult());
    }
}
