package com.scalablepress.holiday.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.scalablepress.holiday.interfaces.BusinessDateScheduler;
import com.scalablepress.holiday.model.Holiday;
import com.scalablepress.holiday.util.Utils;

public class BusinessDateSchedulerImpl implements BusinessDateScheduler {

	@Override
	public LocalDateTime addBusinessTime(Holiday holidayDateTime, String dateToAddYMDTHHmmss, Long durationInSeconds) {
		LocalDateTime dateToAdd = Utils.parseTextDateToLocalDateYMDHHmmss(dateToAddYMDTHHmmss);
		dateToAdd = Utils.addSecondsToDate(dateToAdd, durationInSeconds);
		dateToAdd = ifBetweenHolidayGetEndHolidayPusSeconds(holidayDateTime, durationInSeconds, dateToAdd);
		return dateToAdd;
	}

	private LocalDateTime ifBetweenHolidayGetEndHolidayPusSeconds(Holiday holidayDateTime, Long durationInSeconds,
			LocalDateTime dateToAdd) {
		if (isTimeBetweenHoliday(holidayDateTime, dateToAdd)) {
			LocalDateTime endDate = holidayDateTime.getEndYMDTHHmmss();
			dateToAdd = Utils.addSecondsToDate(endDate, durationInSeconds);
		}
		return dateToAdd;
	}

	private boolean isTimeBetweenHoliday(Holiday holidayDateTime, LocalDateTime time) {
		Date startDate = Date.from(holidayDateTime.getStartYMDTHHmmss().atZone(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(holidayDateTime.getEndYMDTHHmmss().atZone(ZoneId.systemDefault()).toInstant());
		Date dateToTest = Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
		return (dateToTest.after(startDate) && dateToTest.before(endDate));
	}

}
