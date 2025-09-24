package com.gkfcsolution.producer.controller;

import com.gkfcsolution.commonmodels.common.Animal;
import com.gkfcsolution.producer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2025 at 21:42
 * File: null.java
 * Project: springbootBafkaProducer
 *
 * @author Frank GUEKENG
 * @date 23/09/2025
 * @time 21:42
 */
@RestController
@RequestMapping("/api/v1")
public class KafkaMessageController {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Animal animal){
        kafkaProducerService.sendMessage(animal);
        System.out.println("Successfully Published the Animal Name = '" + animal + "' to the AnimalTOpic");
        return "Successfully Published the Animal Name = '" + animal + "' to the AnimalTOpic";
    }
}
