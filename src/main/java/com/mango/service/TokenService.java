package com.mango.service;

import com.mango.domain.Token;
import com.mango.domain.User;
import com.mango.repository.TokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

public interface TokenService {

    public Token findByToken(String token);
}
