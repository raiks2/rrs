package ru.vtb.rrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.vtb.rrs.metadata.Layer;

@SpringBootApplication
@Layer(Layer.Type.INFRASTRUCTURE)
public class RoutingServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(RoutingServiceApp.class);
    }
}
