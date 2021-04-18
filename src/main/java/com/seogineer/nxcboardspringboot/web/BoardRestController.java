package com.seogineer.nxcboardspringboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardRestController {
    @GetMapping("/hello")
    public String Hello(){
        return "HelloWorld";
    }
}
