package com.crm.payload;

import java.util.Date;

public class ErrorsDetails {

    private Date date;
    private String message;
    private String requesturl;

    public ErrorsDetails(Date date, String message, String requesturl) {
        this.date = date;
            this.message = message;
        this.requesturl = requesturl;
    }
    // getter and setter
    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }


    public String getRequesturl() {
        return requesturl;
    }
}
