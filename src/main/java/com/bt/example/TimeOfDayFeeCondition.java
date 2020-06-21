package com.bt.example;

import java.time.LocalTime;
import java.util.List;

public class TimeOfDayFeeCondition implements FeeCondition {

	private LocalTime from;
	private LocalTime to;
	
	public TimeOfDayFeeCondition(LocalTime from, LocalTime to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public List<DateTimeInterval> getDateTimeInterval(Call call) {
		
		return
				call.splitByDay().stream().
				filter(predicate)
		
	}

}
