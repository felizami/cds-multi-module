package com.anuz.cdsclient.config;

import com.anuz.cdsclient.entity.Greeting;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.*;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

public class MyStompHandler extends StompSessionHandlerAdapter {

    final AtomicReference<Object> result = new AtomicReference<Object>();




    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
//        System.out.println(this);
        session.subscribe("/topic/greetings", this);
        session.send("/app/hello", "{\"name\":\"Client\"}".getBytes());
        System.out.println( "{\"name\":\"Client\"}".getBytes());
//        System.out.println("New session: "+session.getSessionId());
//
//
        session.subscribe("/topic/greetings", new StompFrameHandler() {
            @Override
            public Type getPayloadType(StompHeaders headers) {
                return Object.class;
            }

            @Override
            public void handleFrame(StompHeaders headers, Object payload) {
                result.set(payload);


            }
        });


    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        exception.printStackTrace();
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return Greeting.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println("Received by :"+ ((Greeting) payload).getContent());
        System.out.println( result.get());
        sendFromStompHandler(payload);
          }

    @SendTo("/client-topic/greetings")
    public Greeting sendFromStompHandler(Object payload) {
        return new Greeting("hello");
    }

}
