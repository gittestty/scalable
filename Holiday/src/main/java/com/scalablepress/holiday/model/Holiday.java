package com.scalablepress.holiday.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.scalablepress.holiday.util.Utils;

public class Holiday implements Serializable {

	private static final long serialVersionUID = 1987668965834131668L;

	public Holiday(String startYMDTHHmmss, String endYMDTHHmmss)  {
		this.startYMDTHHmmss = Utils.parseTextDateToLocalDateYMDHHmmss(startYMDTHHmmss);
		this.endYMDTHHmmss =  Utils.parseTextDateToLocalDateYMDHHmmss(endYMDTHHmmss);
	}

	private LocalDateTime startYMDTHHmmss;
	private LocalDateTime endYMDTHHmmss;
	

	public LocalDateTime getStartYMDTHHmmss() {
		return startYMDTHHmmss;
	}
	public LocalDateTime getEndYMDTHHmmss() {
		return endYMDTHHmmss;
	}

	

}
