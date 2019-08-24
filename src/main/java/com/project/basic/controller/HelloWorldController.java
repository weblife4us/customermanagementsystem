package com.project.basic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHelloWorldMessage() {


        return "<div style=\"text-align:center;\">" + "<h1>Hello world</h1>"
                + "<p> This is my first springboot page </p>"
                + "</div>";
    }

}
