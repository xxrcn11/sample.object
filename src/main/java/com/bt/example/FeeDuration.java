package com.bt.example;

import java.time.Duration;

import com.bt.example.money.Money;

public class FeeDuration {

	private Duration duration;
	private Money amount;
	
	public FeeDuration(Duration duration, Money amount) {
		this.duration = duration;
		this.amount = amount;
	}
	
	public Money calculate(DateTimeInterval interval) {
		return amount.times(1.0d * interval.duration().getSeconds() / duration.getSeconds()  );
	}
}
