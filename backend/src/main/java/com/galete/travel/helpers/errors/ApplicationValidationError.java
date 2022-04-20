package com.galete.travel.helpers.errors;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ApplicationValidationError extends ApplicationError {

    @Getter
    private List<FieldMessage> fieldMessageList = new ArrayList<>();

    public void addFieldMessage(String name, String message) {
        fieldMessageList.add(new FieldMessage(name, message));
    }
}
