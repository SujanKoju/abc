package com.example.abc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("test")
    public String test() {
        logger.info("HERE I AM SUJAN");
        return "HELLO WORLD ..Maaro mujhe  DOOOOOOOG";
    }

}
