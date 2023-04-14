package com.mango.service;

import com.mango.domain.User;
import com.mango.request.RegistrationRequest;

public interface UserService {
    public User register(RegistrationRequest request) throws IllegalAccessException;
}
