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
        try {
            Counter.s.acquire();
            int a = Counter.s.availablePermits();
            if (1 > 10) System.out.println("Mehr als 10 msgs in der Q "+a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
//Todo: Counter der Zählt, wie viele Messages nicht empfangen wurden