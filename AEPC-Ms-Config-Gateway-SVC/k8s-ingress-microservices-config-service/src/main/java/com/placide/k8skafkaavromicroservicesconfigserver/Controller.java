package com.placide.k8skafkaavromicroservicesconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ms-config-svc")
public class Controller {
    @Value("${welcome.message}")
    private String message;
    @GetMapping(value = "")
    public String getWelcome(){
        return message;
    }
}