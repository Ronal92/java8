package com.jinwoo.util;


/**
 * 시간 계산하는 클래스
 * @author JINWOO
 *
 */
public class TimeUtil {
	// multi thread
	private static Long start;
	private static Long end;
	private static Long period;
	// single thread
	private Long startAsync;
	private Long endAsync;
	private Long periodAsync;
	// 둘다 사용 가능
	private Long startUni;
	private Long endUni;
	private Long periodUni;
	
	
	// multi thread 소용시간 체크
	public void setStartAsync(){
		startAsync = System.currentTimeMillis();
	}
	public void setEndAsync(){
		endAsync = System.currentTimeMillis();
		periodAsync = endAsync - startAsync;
		System.out.print("duration : " + periodAsync);
	}
	
	
	// single thread 소용시간 체크
	public static void setStart(){
		start = System.currentTimeMillis();
	}
	
	public static void setEnd(){
		end = System.currentTimeMillis();
		period = end - start;
		System.out.println("single thread duration : " + period);
	}
	
	// single thread and multithread 둘 다 사용해서 소용시간 체크. 
	public static TimeUtil setStartUni(){
		TimeUtil timeUtil = new TimeUtil();
		timeUtil.startUni = System.currentTimeMillis();
		return timeUtil;		
	}
	
	public static void setEndUni(TimeUtil timeUtil){
		timeUtil.endUni = System.currentTimeMillis();
		timeUtil.periodUni = timeUtil.endUni - timeUtil.startUni;
		System.out.println("setBoth duration : " + timeUtil.periodUni);
	}
}
