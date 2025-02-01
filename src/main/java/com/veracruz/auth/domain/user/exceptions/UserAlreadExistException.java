package com.veracruz.auth.domain.user.exceptions;

public class UserAlreadExistException extends RuntimeException {
    public UserAlreadExistException() {
        super("User Alread Exist!");
    }
}
