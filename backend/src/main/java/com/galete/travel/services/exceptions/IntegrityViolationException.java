package com.galete.travel.services.exceptions;

import com.galete.travel.helpers.enums.ApplicationExceptionEnums;
import com.galete.travel.helpers.exceptions.ApplicationException;

import java.io.Serializable;

public class IntegrityViolationException extends ApplicationException implements Serializable {

    private static final long serialVersionUID = 1L;

    public IntegrityViolationException(String message, ApplicationExceptionEnums applicationExceptionEnums) {
        super(message);
        setExceptionsServiceEnum(applicationExceptionEnums);
    }
}
