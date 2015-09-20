package demo.service.greeting;

import java.util.concurrent.Future;

import demo.domain.Page;

public interface FacebookService {

    public Future<Page> findPage(String page) throws InterruptedException;
    public Future<String> getPageRawResponse(String page) throws InterruptedException;
}
