package com.jinwoo.util;


/**
 * �ð� ����ϴ� Ŭ����
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
	// �Ѵ� ��� ����
	private Long startUni;
	private Long endUni;
	private Long periodUni;
	
	
	// multi thread �ҿ�ð� üũ
	public void setStartAsync(){
		startAsync = System.currentTimeMillis();
	}
	public void setEndAsync(){
		endAsync = System.currentTimeMillis();
		periodAsync = endAsync - startAsync;
		System.out.print("duration : " + periodAsync);
	}
	
	
	// single thread �ҿ�ð� üũ
	public static void setStart(){
		start = System.currentTimeMillis();
	}
	
	public static void setEnd(){
		end = System.currentTimeMillis();
		period = end - start;
		System.out.println("single thread duration : " + period);
	}
	
	// single thread and multithread �� �� ����ؼ� �ҿ�ð� üũ. 
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
