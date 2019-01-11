package com.japa.Japa.controller.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors e) {
        ValidationUtils.rejectIfEmptyOrWhitespace(e,"username","required.username","The username is required");
    }
}
