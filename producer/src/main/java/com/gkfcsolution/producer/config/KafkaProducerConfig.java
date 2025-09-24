package com.gkfcsolution.producer.config;

import com.gkfcsolution.commonmodels.common.Animal;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2025 at 12:40
 * File: null.java
 * Project: springbootBafkaProducer
 *
 * @author Frank GUEKENG
 * @date 23/09/2025
 * @time 12:40
 */
@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, Animal> producerFactory(){
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, Animal> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
