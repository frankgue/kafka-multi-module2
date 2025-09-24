package com.gkfcsolution.producer.service;

import com.gkfcsolution.commonmodels.common.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created on 2025 at 22:16
 * File: null.java
 * Project: springbootBafkaProducer
 *
 * @author Frank GUEKENG
 * @date 23/09/2025
 * @time 22:16
 */
@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, Animal> kafkaTemplate;
    private final static String TOPIC_NAME = "AnimalTopic";

    public void sendMessage(Animal animal){
         kafkaTemplate.send(TOPIC_NAME, animal);
    }
}
