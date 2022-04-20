package com.galete.travel.helpers.exceptions;

import com.galete.travel.helpers.enums.ApplicationExceptionEnums;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationException extends RuntimeException{

    private ApplicationExceptionEnums exceptionsServiceEnum;

    public ApplicationException(String message) {
        super(message);
    }
}
