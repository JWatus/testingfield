package homeproject.testingfield.messaging.consumer;

import homeproject.testingfield.model.Greeting;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//@Service
public class MessageConsumer {

    @KafkaListener(topics = "topicName1", groupId = "foo")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }

    @KafkaListener(
            topics = "topicName2",
            containerFactory = "greetingKafkaListenerContainerFactory")
    public void greetingListener(Greeting greeting) {
        System.out.println("Received Greeting Message: " + greeting.getMsg() + " to " + greeting.getName());
    }
}
