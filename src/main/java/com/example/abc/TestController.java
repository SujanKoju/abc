package com.example.abc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("test")
    public String test() {
        System.out.println("HERE I AM SUJAN");
        return "HELLO WORLD .. DEPLOYED FROM AYO JENKINS--------> MAARO MUJH E";
    }

}
