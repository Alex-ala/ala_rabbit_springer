package ch.competec.ala.rabbitspringer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Producer {
    int count = 0;


    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1, initialDelay = 1000)
    public void send() {
        if (count <= 50000){
            count++;
            try {
                this.template.convertAndSend(queue.getName(), "SHITTYBANGBANG");
                Counter.write.release();
            }catch(Exception e){
                System.out.println("FUCK ES MACHTE BOOM");
                count--;
            }
            if (count%1000 == 0) System.out.println(count);
        }else if (count > 50000){
            System.out.println("done sending");
            count++;
            if (Counter.write.availablePermits() == 50001 && Counter.read.availablePermits() == 50001){
                System.exit(0);
            }else{
                System.out.println(Counter.write.availablePermits()+"writes and "+Counter.read.availablePermits()+" reads");
            }
        }


    }
}
