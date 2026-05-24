package org.example.service;


public class Validation{

    public static boolean isEmailValid(String email){
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && email.matches(regex);
    }

    public static boolean isUsernameValid(String username){
        return username != null && username.length() >= 3;
    }

    public static boolean isPasswordValid(String password){
        String regex = "^(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$";
        return password != null && password.matches(regex);
    }
}
