package demo.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import demo.domain.Greeting;
import demo.service.greeting.GreetingService;

@Component
public class PrintTaskSchedulerDelay {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private GreetingService greetingService;
    
    @Scheduled(fixedDelay = 1000)
    public void reportCurrentTimeDelayed() {
        Greeting greeting = greetingService.getGreeting(1);
        System.out.println("The time is now " + dateFormat.format(new Date()) + 
                           "New greeting retrieved -> " + greeting);
    }
}