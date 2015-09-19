package demo.runners;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import demo.domain.Greeting;
import demo.service.greeting.GreetingService;

@Component
public class GreetingServiceRunner implements CommandLineRunner {

    @Autowired
    private GreetingService greetingService;
    
    @Override
    public void run(String... arg0) throws Exception {

        // Uncomment if the non async method is needed
        // runNonAsyncMethods();
        
    }
    
    /*
     * Example of use when printing elements calling to async methods.
     * No use of futures
     */
    private void runNonAsyncMethods(){
        for (int i = 0; i < 5; i++) {
            Greeting greeting = greetingService.getGreeting(i);
            System.out.println(greeting);
        }
    }

}
