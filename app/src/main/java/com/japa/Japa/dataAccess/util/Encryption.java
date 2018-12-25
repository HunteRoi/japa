package com.japa.Japa.dataAccess.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encryption {
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encrypt(String string){
        return encoder.encode(string);
    }

    public static boolean match(String toCheckPassword, String givenPassword){
        return encoder.matches(toCheckPassword, givenPassword);
    }
}
