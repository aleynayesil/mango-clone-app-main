package com.mango.service.impl;

import com.mango.domain.Token;
import com.mango.domain.User;
import com.mango.repository.TokenRepository;
import com.mango.service.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;


    @Override
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token).orElse(null);
    }
}
