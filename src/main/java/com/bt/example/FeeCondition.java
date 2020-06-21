package com.bt.example;

import java.util.List;

public interface FeeCondition {

	public List<DateTimeInterval> getDateTimeInterval(Call call);
}
