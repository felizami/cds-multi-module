package com.anuz.cdsclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientMainApplication {
    public static void main(String[] args) {

        System.out.println("Module: Client");
        SpringApplication.run(ClientMainApplication.class,args);
    }
}
