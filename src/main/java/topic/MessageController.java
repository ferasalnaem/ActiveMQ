package topic;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/publish-message")
    public ResponseEntity<String> publishMessage(@RequestBody String messageText) {
        try {
            messageProducer.sendMessageToTopic(messageText);
            return new ResponseEntity<>("Message published successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error publishing message: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
