package br.com.opus.campanha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CampanhaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampanhaApplication.class, args);
    }

}
