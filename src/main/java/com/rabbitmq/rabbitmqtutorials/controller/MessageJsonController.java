package com.rabbitmq.rabbitmqtutorials.controller;

import com.rabbitmq.rabbitmqtutorials.dto.User;
import com.rabbitmq.rabbitmqtutorials.publisher.RabbitMQJSONProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    private RabbitMQJSONProducer jsonProducer;

    public MessageJsonController(RabbitMQJSONProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("JSON MESSAGE SENT TO RABBITMQ");

    }



}
