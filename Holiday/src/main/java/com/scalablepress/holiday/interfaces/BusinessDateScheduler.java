package com.scalablepress.holiday.interfaces;

import java.time.LocalDateTime;

import com.scalablepress.holiday.model.Holiday;

@FunctionalInterface
public interface BusinessDateScheduler {
	
	LocalDateTime addBusinessTime(Holiday holidayDateTime, String dateToAddYMDTHHmmss, Long durationInSeconds);

}
