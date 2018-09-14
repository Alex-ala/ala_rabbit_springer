package ch.competec.ala.rabbitspringer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Producer {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1, initialDelay = 1000)
    public void send() {
        this.template.convertAndSend(queue.getName(),"SHITTYBANGBANG");
    }
}
