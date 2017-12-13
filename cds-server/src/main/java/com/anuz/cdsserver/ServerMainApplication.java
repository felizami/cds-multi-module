package com.anuz.cdsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerMainApplication {

    public static void main(String[] args) {
        System.out.println("Module: Server");
        SpringApplication.run(ServerMainApplication.class,args);
    }
}
