package com.mango.service;

import com.mango.domain.User;
import com.mango.request.AuthRequest;
import com.mango.request.RegistrationRequest;
import com.mango.response.AuthResponse;

public interface UserService {
    public AuthResponse register(RegistrationRequest request) throws IllegalAccessException;

  //  public AuthResponse login(AuthRequest request);

    User getUserByUsername(String username);
}
