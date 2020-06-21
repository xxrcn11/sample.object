package com.bt.example;

import java.util.List;

import com.bt.example.money.Money;

public class FeeRule {

	private FeeCondition feeCondtidion;
	private FeeDuration feeDuration;
	
	public FeeRule(FeeCondition feeCondtidion, FeeDuration feeDuration) {
		this.feeCondtidion = feeCondtidion;
		this.feeDuration = feeDuration;
	}
	
	public Money calculate(Call call) {
		
		List<DateTimeInterval> list = feeCondtidion.getDateTimeInterval(call);
		return 
		list.stream()
			.map(interval -> feeDuration.calculate(interval))
			.reduce(Money.ZERO, (first, second) -> first.plus(second));
		
	}
	
	
}
