package com.gkfcsolution.consumer.config;

import com.gkfcsolution.commonmodels.common.Animal;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2025 at 17:45
 * File: null.java
 * Project: springbootKafkaConsumer
 *
 * @author Frank GUEKENG
 * @date 23/09/2025
 * @time 17:45
 */
@Configuration
@EnableKafka
public class KafkaConsumerConfig {
    private static final String GROUP_ID = "Group100";

    @Bean
    public ConsumerFactory<String, Animal> consumerFactory(){
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(Animal.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Animal > animalListener(){
        ConcurrentKafkaListenerContainerFactory<String , Animal > factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }
}
