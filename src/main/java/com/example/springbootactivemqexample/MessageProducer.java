package com.example.springbootactivemqexample;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class MessageProducer {

    private final JmsTemplate jmsTemplate;

    public MessageProducer(JmsTemplate jmsTemplate) {this.jmsTemplate = jmsTemplate;}

    public void sendMessage(Message message) {
        jmsTemplate.convertAndSend("Queue.example", message);
    }
}
