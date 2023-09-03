package com.example.demo.model;

public class PigeonNotFoundException extends Exception {
    public PigeonNotFoundException() {
        super("Pigeon not found");
    }
}
