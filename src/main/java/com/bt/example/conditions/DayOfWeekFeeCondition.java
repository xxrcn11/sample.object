package com.bt.example.conditions;

import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;

import com.bt.example.Call;
import com.bt.example.DateTimeInterval;
import com.bt.example.FeeCondition;

public class DayOfWeekFeeCondition implements FeeCondition {

	private DayOfWeek dayOfWeek;
	
	public DayOfWeekFeeCondition(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	@Override
	public List<DateTimeInterval> getDateTimeInterval(Call call) {
		return
		call.splitByDay().stream().
			filter( x -> x.getFrom().getDayOfWeek().equals(dayOfWeek)).
			collect(Collectors.toList());
	}

}
