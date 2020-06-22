package com.bt.example.conditions;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.bt.example.Call;
import com.bt.example.DateTimeInterval;
import com.bt.example.FeeCondition;

public class TimeOfDayFeeCondition implements FeeCondition {

	private LocalTime start;
	private LocalTime end;
	
	public TimeOfDayFeeCondition(LocalTime start, LocalTime end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public List<DateTimeInterval> getDateTimeInterval(Call call) {
		
		
		List<DateTimeInterval> list = new ArrayList<>();
		
		for (DateTimeInterval interval : call.splitByDay()) {
			if(interval.getFrom().toLocalTime().isAfter(end))
				continue;
			else if(interval.getTo().toLocalTime().isBefore(start))
				continue;
			
			list.add(DateTimeInterval.of(
					LocalDateTime.of(interval.getFrom().toLocalDate(), start.isBefore(interval.getFrom().toLocalTime()) ? interval.getFrom().toLocalTime() : start ), 
					LocalDateTime.of(interval.getFrom().toLocalDate(), end.isAfter(interval.getTo().toLocalTime()) ? interval.getTo().toLocalTime() : end)
					));
			
		}
		System.out.println("list : " + list);
		return list;
		
	}

}
