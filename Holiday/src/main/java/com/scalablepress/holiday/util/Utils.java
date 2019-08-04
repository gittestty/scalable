package com.scalablepress.holiday.util;

import java.time.LocalDateTime;

import com.scalablepress.holiday.constants.ErrorMessages;

public class Utils {

	
	public static LocalDateTime parseTextDateToLocalDateYMDHHmmss(String dateToParseYMDHhmmss) {
		LocalDateTime parseDate = null;
		try {
			parseDate = LocalDateTime.parse(dateToParseYMDHhmmss);
			}catch(Exception e) {
				throw new IllegalArgumentException(ErrorMessages.HOLIDAY_DATE_INITIALIZATION.getMessage());
			}
		
		return parseDate;
	}
	
	
	public static LocalDateTime addSecondsToDate(LocalDateTime localDateToAddSeconds,Long secondsToAdd) {
		return localDateToAddSeconds.plusSeconds(secondsToAdd);
	}
}
