package com.gkfcsolution.commonmodels.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created on 2025 at 22:11
 * File: null.java
 * Project: springbootBafkaProducer
 *
 * @author Frank GUEKENG
 * @date 23/09/2025
 * @time 22:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Animal {
    private String name;
    private String color;
    private String animalType;
}
