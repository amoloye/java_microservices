package com.amoloye.microservices;

import com.amoloye.microservices.notification.NotificationServiceApplication;
import org.springframework.boot.SpringApplication;

public class TestNotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(NotificationServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
