package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/world")
    @ResponseBody
    public String helloWorld(){
        return "hello World";
    }
}
