package com.bt.example;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bt.example.conditions.DayOfWeekFeeCondition;
import com.bt.example.conditions.DurationFeeCondition;
import com.bt.example.money.Money;

@SpringBootApplication
public class ObjectApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ObjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		FeeRule dayOfWeekRule1 = new FeeRule(
	    		new DayOfWeekFeeCondition(DayOfWeek.MONDAY),
	    		new FeeDuration(Duration.ofSeconds(10), Money.wons(38)) ); 
	    
	    FeeRule dayOfWeekRule2 = new FeeRule(
	    		new DayOfWeekFeeCondition(DayOfWeek.TUESDAY),
	    		new FeeDuration(Duration.ofSeconds(10), Money.wons(38)) );
	    
	    FeeRule dayOfWeekRule3 = new FeeRule(
	    		new DayOfWeekFeeCondition(DayOfWeek.WEDNESDAY),
	    		new FeeDuration(Duration.ofSeconds(10), Money.wons(38)) );
	    
	    FeeRule dayOfWeekRule4 = new FeeRule(
	    		new DayOfWeekFeeCondition(DayOfWeek.THURSDAY),
	    		new FeeDuration(Duration.ofSeconds(10), Money.wons(38)) );
	    
	    FeeRule dayOfWeekRule5 = new FeeRule(
	    		new DayOfWeekFeeCondition(DayOfWeek.FRIDAY),
	    		new FeeDuration(Duration.ofSeconds(10), Money.wons(38)) );
	    
	    FeeRule dayOfWeekRule6 = new FeeRule(
	    		new DayOfWeekFeeCondition(DayOfWeek.SATURDAY),
	    		new FeeDuration(Duration.ofSeconds(10), Money.wons(19)) );
	    
	    FeeRule dayOfWeekRule7 = new FeeRule(
	    		new DayOfWeekFeeCondition(DayOfWeek.SUNDAY),
	    		new FeeDuration(Duration.ofSeconds(10), Money.wons(19)) );
	    
	    
	    List<FeeRule> dayOfWeekRules = Arrays.asList(dayOfWeekRule1, dayOfWeekRule2, dayOfWeekRule3, dayOfWeekRule4,
	    		dayOfWeekRule5, dayOfWeekRule6, dayOfWeekRule7);
	    
	    
	    Phone phone1 = new Phone(new BasicRatePolicy(dayOfWeekRules));
	    phone1.call(new Call(LocalDateTime.of(2020,  6, 19, 23, 59, 0), LocalDateTime.of(2020,  6, 20, 0, 1, 0)) );
	    System.out.println(phone1.calculateFee());
	    
	    

//		FeeRule rule1 = new FeeRule(
//				new DurationFeeCondition(Duration.ofSeconds(0), Duration.ofSeconds(60)), 
//				new FeeDuration(Duration.ofSeconds(10), Money.wons(18)) );
//		
//		FeeRule rule2 = new FeeRule(
//				new DurationFeeCondition(Duration.ofSeconds(60), Duration.ofSeconds(Long.MAX_VALUE)), 
//				new FeeDuration(Duration.ofSeconds(10), Money.wons(20)) );
//		
//		List<FeeRule> feeRules = Arrays.asList(rule1, rule2);
//	    
//	    Phone phone = new Phone(new BasicRatePolicy(feeRules));
//	    phone.call(new Call(LocalDateTime.of(2020,  6, 19, 18, 0, 0), LocalDateTime.of(2020,  6, 19, 18, 0, 30)) );
//	    System.out.println(phone.calculateFee());
	    
	    
	    
	}

}
