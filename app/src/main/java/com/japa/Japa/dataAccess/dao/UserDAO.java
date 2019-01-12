package com.japa.Japa.dataAccess.dao;

import com.japa.Japa.dataAccess.entity.UserEntity;
import com.japa.Japa.dataAccess.repository.UserRepository;
import com.japa.Japa.dataAccess.util.ProviderConverter;
import com.japa.Japa.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserDAO {
    private UserRepository userRepository;
    private ProviderConverter providerConverter;

    public UserDAO(UserRepository userRepository, ProviderConverter providerConverter){
        this.userRepository = userRepository;
        this.providerConverter = providerConverter;
    }

    public boolean isUsernameTaken(String username){
        List<UserEntity> userEntities = userRepository.findAll();
        UserEntity userEntity = userEntities.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
        return userEntity != null;
    }

    public boolean isEmailAlreadyUsed(String email){
        List<UserEntity> userEntities = userRepository.findAll();
        UserEntity userEntity = userEntities.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
        return userEntity != null;
    }

    public boolean isPhoneNumberAlreadyUsed(String phoneNumber){
        List<UserEntity> userEntities = userRepository.findAll();
        UserEntity userEntity = userEntities.stream().filter(user -> user.getPhone_number().equals(phoneNumber)).findFirst().orElse(null);
        return userEntity != null;
    }

    public void saveUser(User user){
        UserEntity userEntity = providerConverter.userModelToUserEntity(user);
        userRepository.save(userEntity);
    }

}
