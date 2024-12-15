package com.crm.exception;


import com.crm.payload.ErrorsDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice    // annotating with this it becomes global class - which means where ever exception occurs , it will come to this class
public class HandleException {
    // handle exception for employee not found
    @ExceptionHandler(Exception.class)
    public ResponseEntity< ErrorsDetails > Exception(
            Exception e,
            WebRequest requesturl
    ) { // exceptions object address is stored in "e"

        ErrorsDetails errorsDetails = new ErrorsDetails(
                new Date(),
                e.getMessage(),
                requesturl.getDescription(false)//  this
        );
        return new ResponseEntity<>(errorsDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
