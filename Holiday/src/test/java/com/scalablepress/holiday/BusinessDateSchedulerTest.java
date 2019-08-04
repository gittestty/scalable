package com.scalablepress.holiday;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.scalablepress.holiday.impl.BusinessDateSchedulerImpl;
import com.scalablepress.holiday.interfaces.BusinessDateScheduler;
import com.scalablepress.holiday.model.Holiday;
import com.scalablepress.holiday.util.Utils;

public class BusinessDateSchedulerTest {
	
	private Holiday holyday = null;
	
	@Before
	public void setUp() {
		holyday = new Holiday("2019-12-24T21:00:00", "2019-12-25T21:00:00");
	}

	@Test
	public void return20191201() {
		BusinessDateScheduler businessDateScheduler = new BusinessDateSchedulerImpl();
		LocalDateTime response = businessDateScheduler.addBusinessTime(holyday, "2019-12-01T00:00:00", 60l*60l);
		LocalDateTime expectedDate = Utils.parseTextDateToLocalDateYMDHHmmss("2019-12-01T01:00:00");
		assertEquals(expectedDate, response);
	}
	
	

}
