package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.With;

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

