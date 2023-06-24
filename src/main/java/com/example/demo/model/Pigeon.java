package com.example.demo.model;

import lombok.*;

import java.util.UUID;

@Value
@Builder
@AllArgsConstructor
@With
public class Pigeon {
    private UUID id;
    private String name;
    private Integer age;
    private String status;
}

