package com.anuz.cdsserver.controller;

import com.anuz.cdsserver.model.Greeting;
import com.anuz.cdsserver.model.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
@EnableScheduling
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedRate = 5000)
    public void greeting() throws Exception {
        Thread.sleep(1000); // simulated delay

        this.template.convertAndSend("/topic/greetings",  new Greeting("Hello world from Server"));
    }


    @MessageMapping("/helloworld")
    @SendTo("/topic/greetings")
    public Greeting greetings(HelloMessage message){
        return new Greeting("Hello"+message.getName());
    }
}
