package com.bt.example;

import java.util.List;

import com.bt.example.money.Money;

public final class BasicRatePolicy implements RatePolicy {
	private List<FeeRule> feeRules;
	
    public BasicRatePolicy(List<FeeRule> feeRules) {
		this.feeRules = feeRules;
	}

	@Override
    public Money calculateFee(Phone phone) {
        Money result = Money.ZERO;

        for(Call call : phone.getCalls()) {
        	result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    private Money calculateCallFee(Call call) {
    	return feeRules.stream()
    			.map(rule -> rule.calculate(call))
    			.reduce(Money.ZERO, (frist, second) -> frist.plus(second) );
    }
}
