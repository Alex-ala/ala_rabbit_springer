package ch.competec.ala.rabbitspringer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class RabbitSpringer implements CommandLineRunner
{
    public static void main(String[] args)
    {
        SpringApplication.run(RabbitSpringer.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Ja uff erstmal");
    }

}
