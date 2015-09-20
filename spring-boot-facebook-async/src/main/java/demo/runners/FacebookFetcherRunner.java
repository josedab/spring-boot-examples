package demo.runners;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import demo.domain.Page;
import demo.service.greeting.FacebookService;

@Component
public class FacebookFetcherRunner implements CommandLineRunner {

    @Autowired
    private FacebookService facebookService;
    
    @Override
    public void run(String... arg0) throws Exception {

        String [] facebookPages = new String []{
                "Pivotal-Software-Inc",
                "Google"
        };
        
        //fetchFacebookPages(facebookPages);
        fetchFacebookPagesRawContent(facebookPages);
        
    }
    
    private void fetchFacebookPages(String[] facebookPages) throws InterruptedException, ExecutionException {
        List<Future<Page>> futureResults = new LinkedList<Future<Page>>();
        boolean[] finishedTasks = new boolean[facebookPages.length];
        
        for (String facebookPage:facebookPages) {
            Future<Page> page = facebookService.findPage(facebookPage);
            futureResults.add(page);
        }
        
        
        boolean completed = false;

        while (!completed) {
            completed = true;
            int index = 0;
            for (Future<Page> futureResult : futureResults) {
                if (futureResult.isDone() && !finishedTasks[index]) {
                    System.out.println(facebookPages[index] + " is done");
                    finishedTasks[index] = true;
                }
                completed = completed && finishedTasks[index];
                index++;
            }
        }
        System.out.println("Finished facebook async cli");
    }

    private void fetchFacebookPagesRawContent(String[] facebookPages) throws InterruptedException, ExecutionException {
        List<Future<String>> futureResults = new LinkedList<Future<String>>();
        boolean[] finishedTasks = new boolean[facebookPages.length];
        
        for (String facebookPage:facebookPages) {
            Future<String> page = facebookService.getPageRawResponse(facebookPage);
            futureResults.add(page);
        }
        
        
        boolean completed = false;

        while (!completed) {
            completed = true;
            int index = 0;
            for (Future<String> futureResult : futureResults) {
                if (futureResult.isDone() && !finishedTasks[index]) {
                    System.out.println(facebookPages[index] + " is done");
                    finishedTasks[index] = true;
                }
                completed = completed && finishedTasks[index];
                index++;
            }
        }
        System.out.println("Finished facebook async cli");
    }
}
