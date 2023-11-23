package es.libreria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
    	System.out.println("Servicio Rest -> Cargando el contexto de Spring");
        ApplicationContext context = SpringApplication.run(Application.class, args);
        System.out.println("Servicio Rest -> Contexto De Spring Cargado");
        Main main = context.getBean(Main.class);
        main.run();
    }
}
