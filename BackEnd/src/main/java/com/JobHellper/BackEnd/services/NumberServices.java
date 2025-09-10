package com.JobHellper.BackEnd;

import org.springframework.stereotype.Service;

@Service
public class NumberSevices {
public int processedNumber(int currentNumber) {
        return currentNumber * 2;
    }

}
