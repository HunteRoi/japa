package com.japa.Japa.dataAccess.dao;

import com.japa.Japa.dataAccess.entity.UserEntity;
import com.japa.Japa.dataAccess.repository.UserRepository;
import com.japa.Japa.dataAccess.util.Encryption;
import com.japa.Japa.exception.LoginDataException;
import com.japa.Japa.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.ResourceBundle;

@Transactional
@Service
public class UserDAO {
    private UserRepository userRepository;

    public UserDAO(UserRepository userRepository){
        this.userRepository = userRepository;
    }

}
