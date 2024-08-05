package com.example.capstone_1.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotNull
    private int id;
    @NotEmpty
    @Size(min = 6, max = 25)
    private String username;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{9,}$" , message = "password must be at least 9 characters long, at least one letter, at least one digit" )
    private String password;
    @Email
    private String email;
    @NotEmpty
    @Pattern(regexp = "^(Admin|Customer)$")
    private String role;
    @NotNull
    @Positive
    private double balance;
}
