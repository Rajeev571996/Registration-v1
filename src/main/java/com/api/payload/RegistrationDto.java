package com.api.payload;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegistrationDto {

    @NotEmpty

    @Size(min=2 , message = "min shouild 2 letters")
    @Column(name = "name", nullable = false)
    private String name;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Size(max = 10 , min = 10, message = "should be 10 digit")
    @Column(name = "mobile", nullable = false, unique = true, length = 10)
    private String mobile;

}
