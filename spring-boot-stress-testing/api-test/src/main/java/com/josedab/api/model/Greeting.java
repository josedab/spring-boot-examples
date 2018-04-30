package com.josedab.api.model;

public class Greeting {

    private long id = -1;
    private String content = "default";

    public Greeting() {
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
