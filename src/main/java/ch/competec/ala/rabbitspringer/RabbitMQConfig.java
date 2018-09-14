package ch.competec.ala.rabbitspringer;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue mirrorq1(){
        return new Queue("mirrorq1");
    }

    @Bean
    public Consumer consumer(){
        return new Consumer();
    }

    @Bean
    public Producer producer() {return new Producer(); }

}
