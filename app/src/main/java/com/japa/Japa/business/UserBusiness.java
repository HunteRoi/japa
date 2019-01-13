package com.japa.Japa.business;

import com.japa.Japa.dataAccess.dao.UserDAO;
import com.japa.Japa.model.User;

public class UserBusiness {
    private UserDAO userDAO;

    public UserBusiness(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public boolean isUsernameTaken(String username){
        return userDAO.isUsernameTaken(username);
    }

    public boolean isEmailAlreadyUsed(String email){
        return isEmailAlreadyUsed(email);
    }

    public boolean isPhoneNumberAlreadyUsed(String phoneNumber){
        return isPhoneNumberAlreadyUsed(phoneNumber);
    }

    public void saveUser(User user){
        userDAO.saveUser(user);
    }
}
