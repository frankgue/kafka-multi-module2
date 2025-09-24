package com.gkfcsolution.consumer.consumer;

import com.gkfcsolution.commonmodels.common.Animal;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created on 2025 at 17:53
 * File: null.java
 * Project: springbootKafkaConsumer
 *
 * @author Frank GUEKENG
 * @date 23/09/2025
 * @time 17:53
 */
@Service
public class KafkaConsumerImpl {
    @KafkaListener(topics = "AnimalTopic", groupId = "Group100", containerFactory = "animalListener")
    public void listen(Animal animal){
        System.out.println("Recived '" + animal + "' from the AnimalTopic");
    }
}
