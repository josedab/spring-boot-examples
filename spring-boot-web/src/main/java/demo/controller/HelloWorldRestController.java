package demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Message;

@RestController
@RequestMapping("/hellorest")
public class HelloWorldRestController {

    @RequestMapping("/world/string")
    public String helloWorld(){
        return "hello rest World";
    }
    
    @RequestMapping("/world/message")
    public Message helloWorldMessage(){
        return new Message("Wrapped hello world");
    }
}
