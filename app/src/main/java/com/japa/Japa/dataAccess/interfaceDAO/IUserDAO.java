package com.japa.Japa.dataAccess.interfaceDAO;

import com.japa.Japa.model.User;

public interface IUserDAO {
    boolean isUsernameTaken(String username);

    boolean isEmailAlreadyUsed(String email);

    boolean isPhoneNumberAlreadyUsed(String phoneNumber);

    void saveUser(User user);
}
