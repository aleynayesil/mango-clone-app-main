package com.mango.request;

import com.mango.domain.Country;
import com.mango.domain.Gender;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

    private final String firstName;

    private final String lastName;

    private final String password;

    private final String email;

    private final String phone;

    private final Country country;

    private final Gender gender;
}
