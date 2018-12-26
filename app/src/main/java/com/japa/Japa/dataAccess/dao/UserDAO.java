package com.japa.Japa.dataAccess.dao;

import com.japa.Japa.dataAccess.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserDAO {
    private UserRepository userRepository;

    public UserDAO(UserRepository userRepository){
        this.userRepository = userRepository;
    }

}
