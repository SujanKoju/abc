package com.example.abc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("test")
    public String test() {
        System.out.println("HERE I AM");
        return "HELLO WORLD MY NAME IS SUJAN Koju HERO OF NEPAL";
    }

}
