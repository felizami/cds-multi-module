//package com.anuz.cdsclient.controller;
//
//import com.anuz.cdsclient.entity.Greeting;
//import com.anuz.cdsclient.entity.HelloMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Controller;
//
//@Controller
//@EnableScheduling
//public class WSController {
//    @Autowired
//    private SimpMessagingTemplate template;
//
//    @Scheduled(fixedRate = 5000)
//    public void greeting() throws Exception {
//        Thread.sleep(1000); // simulated delay
//
//        this.template.convertAndSend("/client-topic/greetings",  new Greeting("Hello world"));
//    }
//
//
//    @MessageMapping("/helloworld")
//    @SendTo("/client-topic/greetings")
//    public Greeting greetings(HelloMessage message){
//        return new Greeting("Hello"+message.getName());
//    }
//}
