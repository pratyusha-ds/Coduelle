package com.coduelle.judge.infrastructure.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "submission-queue")
    public void handle(String message) {
        // stub: receive message from RabbitMQ
    }
}
