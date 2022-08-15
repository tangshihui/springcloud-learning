package org.example.provider02.service;


import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
}
