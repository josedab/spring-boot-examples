package demo.service.greeting.impl;


import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import demo.domain.Page;
import demo.service.greeting.FacebookService;

@Service
public class FacebookServiceImpl implements FacebookService {

    private static final String FACEBOOK_GRAPH_URL = "https://graph.facebook.com/v2.4/";
    private static final String FACEBOOK_ACCESS_TOKEN = "INSERT TOKEN ;)";
    
    @Autowired
    private RestTemplate restTemplate;

    @Async
    public Future<Page> findPage(String page) throws InterruptedException {
        System.out.println("Looking up for facebook page: " + page);
        
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(FACEBOOK_GRAPH_URL + page)
                                                           .queryParam("access_token", FACEBOOK_ACCESS_TOKEN);
        
        Page results = restTemplate.getForObject(builder.toUriString(), Page.class);
        return new AsyncResult<Page>(results);
    }
    
    @Async
    public Future<String> getPageRawResponse(String page) throws InterruptedException {
        System.out.println("Looking up for facebook page: " + page);
        
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(FACEBOOK_GRAPH_URL + page)
                                                           .queryParam("access_token", FACEBOOK_ACCESS_TOKEN);
        
        String rawContent = restTemplate.getForObject(builder.toUriString(), String.class);
        return new AsyncResult<String>(rawContent);
    }

}