package ch.competec.ala.rabbitspringer;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "mirrorq1")
class Consumer
{

    @RabbitHandler
    public void receive(byte[] msg){
        System.out.println(new String(msg));
    }

    @RabbitHandler
    public void receive(String msg){
        System.out.println(msg);
    }

}
//Todo: Counter der Zählt, wie viele Messages nicht empfangen wurden