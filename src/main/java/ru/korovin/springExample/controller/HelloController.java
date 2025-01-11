package ru.korovin.springExample.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/site")
public class HelloController {

    @GetMapping
    public String saySome(){
        return "site/site";
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return "site/hello";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye(){
        return "site/goodbye";
    }



}
