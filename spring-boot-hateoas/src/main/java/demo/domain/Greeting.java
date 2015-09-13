package demo.domain;

import org.springframework.hateoas.ResourceSupport;

public class Greeting extends ResourceSupport {

    private final long number;
    private final String content;

    public Greeting(long number, String content) {
        this.number = number;
        this.content = content;
    }

    public long getNumber() {
        return number;
    }

    public String getContent() {
        return content;
    }
}
