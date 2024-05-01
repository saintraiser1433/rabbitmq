package com.rabbitmq.rabbitmqtutorials.consumer;

import com.rabbitmq.rabbitmqtutorials.dto.User;
import com.rabbitmq.rabbitmqtutorials.publisher.RabbitMQJSONProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJSONConsumer {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQJSONProducer.class);

    @RabbitListener(queues = {"${rabbitmq.json.queue.name}"})
    public void receiveMessage(User user) {
        logger.info("Received user: -> %s" + user);


    }
}
