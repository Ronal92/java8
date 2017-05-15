package com.jinwoo;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

import com.jinwoo.util.TimeUtil;

public class Java8Main {

	public static void main(String[] args) {
		
		//getDate();
		adjustDate();
		
//		calcDuration();
//		calcDurationBySystemMili();
//		calcDurationUsingTimeUtil();
//	
//		calcDuration();
//		calcDurationBySystemMili();
//		calcDurationUsingTimeUtil();
//		
//		calcDuration();
//		calcDurationBySystemMili();
//		calcDurationUsingTimeUtil();
		
		

	}
	
	public static void adjustDate(){		
		LocalDate today = LocalDate.now();
		LocalDate next = today.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.SUNDAY));
		
		System.out.printf("이번달 2번째 일요일 : %s \n", next);
	}
	public static void getDate(){
		LocalDate today = LocalDate.now();
		System.out.printf("today:%s \n",  today);
		LocalDate myBirthday = LocalDate.of(1984,07,16);
		System.out.printf("myBirthday:%s \n", myBirthday);
		myBirthday = LocalDate.of(1985, Month.NOVEMBER, 18);
		System.out.printf("myBirthday2:%s \n",myBirthday);
	}
	// Instant.now()를 이용한 소요시간 계산
	public static void calcDuration(){
		Instant start = Instant.now();
		
		double r = 0;
		for(Long i = 0L; i< 1000000000L ; i++){
			r = r+i;
		}
		
		Instant end = Instant.now();
		Duration period = Duration.between(start, end);
		
		Long millis = period.toMillis();
		
		System.out.printf("소요시간:%d", millis);
	}
	// System.currentTimeMillis()를 이용한 소요시간 계산
	public static void calcDurationBySystemMili(){
		//Long start = System.currentTimeMillis();
		TimeUtil.setStart();
		double r = 0;
		for(Long i = 0L; i< 1000000000L ; i++){
			r = r+i;
		}
		TimeUtil.setEnd();
//		Long end = System.currentTimeMillis();
//		Long period = end - start;
//		System.out.printf("소요시간:%d", period);
	}
	
	// 싱글 쓰레드와 멀티쓰레드에서 사용 가능한 메소드	
	public static void calcDurationUsingTimeUtil(){
		TimeUtil timeUtil = TimeUtil.setStartUni();
		
		double r = 0;
		for(Long i = 0L; i< 1000000000L ; i++){
			r = r+i;
		}
		TimeUtil.setEndUni(timeUtil);
	}
}
