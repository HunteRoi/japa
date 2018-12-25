package com.japa.Japa.dataAccess.service;

import com.japa.Japa.dataAccess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImplementation(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String searchedUser) throws UsernameNotFoundException {
        UserDetails user = userRepository.findByUsername(searchedUser);
        if(user == null){
            throw new UsernameNotFoundException("");
        }
        return null;
    }
}

/*
*  UserEntity filteredUser = userRepository.findByUsername(searchUser.getUsername());

        if(filteredUser == null || !Encryption.match(searchUser.getPassword(), filteredUser.getPassword()))
            throw new LoginDataException("Connection error");

        return true;
* */