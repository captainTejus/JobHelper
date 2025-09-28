package com.JobHellper.BackEnd.services;

import org.springframework.stereotype.Service;

@Service
public class NumberServices {
public int processedNumber(int currentNumber) {
        return currentNumber * 2;
    }

}
