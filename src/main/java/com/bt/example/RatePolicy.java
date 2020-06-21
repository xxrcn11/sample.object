package com.bt.example;

import com.bt.example.money.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
