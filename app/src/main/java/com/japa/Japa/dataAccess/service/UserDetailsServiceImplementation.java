package com.japa.Japa.dataAccess.service;

import com.japa.Japa.dataAccess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImplementation implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImplementation(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}

/*
*  UserEntity filteredUser = userRepository.findByUsername(searchUser.getUsername());

        if(filteredUser == null || !Encryption.match(searchUser.getPassword(), filteredUser.getPassword()))
            throw new LoginDataException("Connection error");

        return true;
* */