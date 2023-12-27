package topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumers {

    @JmsListener(destination = "Topic.example", containerFactory = "topicListenerFactory")
    public void receiveMessage(String message) {System.out.println("Received message on Subscriber 1: " + message);}

    @JmsListener(destination = "Topic.example", containerFactory = "topicListenerFactory")
    public void receiveMessage2(String message) {System.out.println("Received message on Subscriber 2: " + message);}
}
