package com.mango.service.impl;

import com.mango.domain.Role;
import com.mango.domain.Token;
import com.mango.domain.User;
import com.mango.repository.TokenRepository;
import com.mango.repository.UserRepository;
import com.mango.request.RegistrationRequest;
import com.mango.response.AuthResponse;
import com.mango.security.JwtService;
import com.mango.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private JwtService jwtService;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public AuthResponse register(RegistrationRequest request) {
        final User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setCountry(request.getCountry());
        user.setEmail(request.getEmail());
        user.setGender(request.getGender());
        user.setPhone(request.getPhone());
        user.setRole(Role.USER);
        user.setUsername(request.getEmail());
        user.setAddress("address");
        user.setCreatedAt(LocalDateTime.now());
        user.setIsActivated(false);
        user.setUpdateDate(LocalDateTime.now());

        final Token token = new Token();
        String generateToken = UUID.randomUUID().toString();

        token.setToken(jwtService.generateToken(user));
        token.setCreateAt(LocalDateTime.now());
        token.setExpiredAt(LocalDateTime.now().plusMinutes(15));

        tokenRepository.save(token);

        user.setToken(token);

        userRepository.save(user);

        return AuthResponse.builder().token(token.getToken()).build();
    }

   /* @Override
    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getUsername()).orElse(null);
        String token = jwtService.generateToken(user);

        return AuthResponse.builder().token(token).build();
    }*/

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username).get();
    }
}
