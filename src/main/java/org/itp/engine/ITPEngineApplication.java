package org.itp.engine;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ITPEngineApplication {
    public static void main(String[] args) {
        SpringApplication.run(ITPEngineApplication.class, args);
    }
}
