package com.mango.service.impl;

import com.mango.domain.Role;
import com.mango.domain.User;
import com.mango.repository.UserRepository;
import com.mango.request.RegistrationRequest;
import com.mango.security.CustomUserDetailsService;
import com.mango.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User register(RegistrationRequest request) {
        final User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        user.setCountry(request.getCountry());
        user.setEmail(request.getEmail());
        user.setGender(request.getGender());
        user.setPhone(request.getPhone());
        user.setRole(Role.USER);
        user.setUserName(request.getEmail());
        user.setAddress("address");
        user.setCreatedAt(LocalDateTime.now());
        user.setIsActivated(false);
        user.setUpdateDate(LocalDateTime.now());

        userRepository.save(user);

        return user;
    }
}
