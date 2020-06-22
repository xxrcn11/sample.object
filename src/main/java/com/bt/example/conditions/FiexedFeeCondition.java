package com.bt.example.conditions;

import java.util.Arrays;
import java.util.List;

import com.bt.example.Call;
import com.bt.example.DateTimeInterval;
import com.bt.example.FeeCondition;

public class FiexedFeeCondition implements FeeCondition {

	@Override
	public List<DateTimeInterval> getDateTimeInterval(Call call) {
		return Arrays.asList(call.getInterval());
	}

}
