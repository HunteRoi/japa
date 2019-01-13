package com.japa.Japa.controller.validator;


import com.japa.Japa.dataAccess.dao.UserDAO;
import com.japa.Japa.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator implements Validator {

    private UserDAO userDAO;

    public UserValidator(UserDAO userDAO){
        this.userDAO = userDAO;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors e) {
        User user = (User) o;
        if(user.getPassword() != null && !user.getPassword().equals(user.getCheckPassword())) e.rejectValue("password","differentPasswords");

        if(user.getUsername() != null && !user.getUsername().isEmpty() && user.getUsername().length() < 3) e.rejectValue("username", "usernameTooShort");

        if(user.getPassword() != null && !user.getPassword().isEmpty() && user.getPassword().length() <6) e.rejectValue("password", "passwordTooShort");

        if(user.getEmail() != null && !user.getEmail().isEmpty()){
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
            Matcher matcher = pattern.matcher(user.getEmail());
            if(!matcher.matches()) e.rejectValue("email","incorrectEmail");

            if(userDAO.isEmailAlreadyUsed(user.getEmail())) e.rejectValue("email","emailAlreadyUsed");
        }

        if(user.getPhoneNumber() != null && !user.getPhoneNumber().isEmpty()){
            Pattern pattern = Pattern.compile("\\+\\d{1,4}\\s\\d{2,3}\\/\\d{2}(\\.\\d{2}){2}");
            Matcher matcher = pattern.matcher(user.getPhoneNumber());
            if(!matcher.matches()) e.rejectValue("phoneNumber","incorrectPhoneNumber");
            if(userDAO.isPhoneNumberAlreadyUsed(user.getPhoneNumber())) e.rejectValue("phoneNumber","phoneNumberAlreadyUsed");
        }

        if(user.getUsername() != null){
            if(userDAO.isUsernameTaken(user.getUsername())) e.rejectValue("username","usernameAlreadyExist");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(e,"username","requiredUsername");
        ValidationUtils.rejectIfEmptyOrWhitespace(e,"password","requiredPassword");
        ValidationUtils.rejectIfEmptyOrWhitespace(e,"checkPassword","requiredCheckPassword");
        ValidationUtils.rejectIfEmptyOrWhitespace(e,"firstName","requiredFirstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(e,"lastName","requiredLastName");
        ValidationUtils.rejectIfEmptyOrWhitespace(e,"email","requiredEmail");
        ValidationUtils.rejectIfEmptyOrWhitespace(e,"phoneNumber","requiredPhoneNumber");
        ValidationUtils.rejectIfEmptyOrWhitespace(e,"address","requiredAddress");
    }
}
