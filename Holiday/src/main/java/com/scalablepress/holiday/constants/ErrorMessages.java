package com.scalablepress.holiday.constants;

public enum ErrorMessages {
	
	 
    HOLIDAY_DATE_INITIALIZATION("The start/end date in holiday has not the correct format. Expected date YYYY-MM-DDTHH:MM:SS Ex:2019-12-24T21:00:00"),
   ;
     
    private String message;
     
    private ErrorMessages(String message) {
        this.message = message;
    }
     
    public String getMessage() {
        return this.message;
    }


}
