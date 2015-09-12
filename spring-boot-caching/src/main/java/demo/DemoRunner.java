package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import demo.service.greeting.GreetingService;

@Component
public class DemoRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(DemoRunner.class);

    @Autowired
    private GreetingService greetingService;
    
    @Override
    public void run(String... arg0) throws Exception {
        
        log.info(".... Getting greeting 1 several times");
        for (int i = 0; i < 10; i++) {
            log.info("greeting request" + i + " -->" + greetingService.getGreeting(1));
        }
        
        
    }

}
