package com.example.springbootactivemqexample;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @JmsListener(destination = "Queue.example")
    public void receiveMessage(Message message) {System.out.println("Received message: " + message.getText());}
}
