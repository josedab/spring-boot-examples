package demo.runners;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import demo.domain.Greeting;
import demo.service.greeting.GreetingService;
import demo.service.greeting.GreetingServiceAsync;

@Component
public class GreetingServiceAsyncRunner implements CommandLineRunner {

    @Autowired
    private GreetingServiceAsync greetingService;
    
    @Override
    public void run(String... arg0) throws Exception {

        runNonAsyncMethods();
        
    }
    
    /*
     * Example of use when printing elements calling to async methods.
     * Use of futures
     */
    private void runNonAsyncMethods() throws InterruptedException, ExecutionException {
        List<Future<Greeting>> futureResults = new LinkedList<Future<Greeting>>();
        for (int i = 0; i < 10; i++) {
            Future<Greeting> greeting = greetingService.getGreeting(i);
            futureResults.add(greeting);
        }
        
        boolean[] finishedTasks = new boolean[futureResults.size()];
        boolean completed = false;

        while (!completed) {
            completed = true;
            int index = 0;
            for (Future<Greeting> futureResult : futureResults) {
                if (futureResult.isDone() && !finishedTasks[index]) {
                    Greeting greeting = futureResult.get();
                    System.out.println(greeting + " is done");
                    finishedTasks[index] = true;
                }
                completed = completed && finishedTasks[index];
                index++;
            }
        }
        System.out.println("Finished async cli");
    }

}
