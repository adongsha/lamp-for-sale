package com.lamp.util;

import java.util.Calendar;
import java.util.Date;

public class Utils {

	/**
	 * 
	 * isSameAMorPM判断给定时间是否同一个上午或者是同一个下午
	 * 
	 * @param date
	 * @return 
	 *@return boolean
	 * @exception 
	 * @since  1.0
	 */
	public static boolean  isSameAMorPM(Date date){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		Calendar currentCalendar=Calendar.getInstance();
		currentCalendar.setTime(new Date());
		boolean sameDay=calendar.get(Calendar.YEAR)==currentCalendar.get(Calendar.YEAR)&&calendar.get(Calendar.MONTH)==currentCalendar.get(Calendar.MONTH)&&calendar.get(Calendar.DAY_OF_MONTH)==currentCalendar.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(calendar.get(Calendar.AM_PM));
		return calendar.get(Calendar.AM_PM)==currentCalendar.get(Calendar.AM_PM)&&sameDay;
	}
}
