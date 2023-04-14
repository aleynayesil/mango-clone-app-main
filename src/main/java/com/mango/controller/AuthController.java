package com.mango.controller;

import com.mango.request.RegistrationRequest;
import com.mango.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "auth/")
@AllArgsConstructor
public class AuthController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request) throws IllegalAccessException {
        userService.register(request);
        return ResponseEntity.ok("works");
    }
}
