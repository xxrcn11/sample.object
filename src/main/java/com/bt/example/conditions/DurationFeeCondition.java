package com.bt.example.conditions;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.bt.example.Call;
import com.bt.example.DateTimeInterval;
import com.bt.example.FeeCondition;

public class DurationFeeCondition implements FeeCondition {
	private Duration from;
	private Duration to;

	public DurationFeeCondition(Duration from, Duration to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public List<DateTimeInterval> getDateTimeInterval(Call call) {
		
		if(call.getDuration().compareTo(from) < 0)
			return Collections.emptyList();
		
		return Arrays.asList(DateTimeInterval.of(call.getFrom().plus(from), 
				call.getDuration().compareTo(to) >= 0 ?  
						call.getFrom().plus(to) : call.getTo() ));

	}

}
