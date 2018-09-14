package ch.competec.ala.rabbitspringer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Producer {

    @Autowired
    private RabbitTemplate template;

    @Scheduled(fixedDelay = 1, initialDelay = 1000)
    public void send() {
        this.template.convertAndSend("SHITTYBANGBANG");
    }
}
