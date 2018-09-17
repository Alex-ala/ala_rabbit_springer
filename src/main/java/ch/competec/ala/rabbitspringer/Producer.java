package ch.competec.ala.rabbitspringer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;

public class Producer {
    int count = 0;


    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1, initialDelay = 1000)
    public void send() {
        if (count < 100000){
            count++;
            this.template.convertAndSend(queue.getName(),"SHITTYBANGBANG");
            Counter.s.release();
            if (count%1000 == 0) System.out.println(count);
        }else if (count == 100000){
            System.out.println("done");
            count++;
        }


    }
}
