package homeproject.testingfield.messaging.producer;

import homeproject.testingfield.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//@Service
public class MessageProducer {

    @Value(value = "${kafka.topicName1}")
    private String topicName1;

    @Value(value = "${kafka.topicName2}")
    private String topicName2;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, Greeting> greetingKafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send(topicName1, msg);
    }

    public void sendMessageWithGreeting(Greeting greeting) {
        greetingKafkaTemplate.send(topicName2, greeting);
        // send with a key
        // greetingKafkaTemplate.send(topicName2, userId, greeting);
    }

}
