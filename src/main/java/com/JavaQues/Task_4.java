package com.JavaQues;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * Design a class that will represent a time range: start time to end time
 * One possible use for such a class is in scheduling or booking application.
 * Example: Conference room will be used from Monday 10am to 12pm
 * Create any code constructors, variables and methods that you feel are necessary.
 * One such method should test for intersection or conflict
 * in times between 2 instances of TimeRange
 * 
 */

public class Task_4 {

	public static final int maxHrs=4;

	static class TimeRange{
		Date startTime;
		Date endTime;
		String nameOfPersonBooked;

		public TimeRange(Date startTime,Date endTime, String name) {
			this.startTime=startTime;
			this.endTime=endTime;
			this.nameOfPersonBooked=name;
		}
	}

	boolean isTimeRangeValid(TimeRange t1,TimeRange t2){

		if(t1==null || t2==null){
			return false;
		}
		if(t1.endTime.compareTo(t2.startTime)==1){
			return true;
		}
		return false;
	}

	String nameOfPersonBooked(TimeRange t){
		return t.nameOfPersonBooked;
	}

	boolean isTimeRangeAllowed(TimeRange t){

		Calendar scalendar = GregorianCalendar.getInstance(); // creates a new calendar instance
		scalendar.setTime(t.startTime);   // assigns calendar to given date
		int start=scalendar.get(Calendar.HOUR);        // gets hour in 12h format

		Calendar ecalendar = GregorianCalendar.getInstance(); // creates a new calendar instance
		ecalendar.setTime(t.endTime);   // assigns calendar to given date
		int end=ecalendar.get(Calendar.HOUR);        // gets hour in 12h format

		if(end-start<maxHrs){
			return true;
		}
		return false;
	}

}
