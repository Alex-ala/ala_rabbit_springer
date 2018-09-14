package ch.competec.ala.rabbitspringer;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "mirrorq1")
class Consumer
{

    @RabbitHandler
    public void receive(byte[] msg){
        System.out.println(new String(msg));
    }

}
