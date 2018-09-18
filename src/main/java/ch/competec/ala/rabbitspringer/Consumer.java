package ch.competec.ala.rabbitspringer;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "mirrorq1")
class Consumer
{
    @RabbitHandler
    public void receive(String msg){
            Counter.read.release();
            System.out.println(Counter.read.availablePermits());
    }

}