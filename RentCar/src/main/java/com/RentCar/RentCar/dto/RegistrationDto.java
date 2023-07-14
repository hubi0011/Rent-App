package com.RentCar.RentCar.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationDto {
    private Long id;
    @NotEmpty(message = "Name should not be empty or null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name should only contain letters")
    private String name;
    @NotEmpty(message = "Last Name should not be empty or null")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last Name should only contain letters")
    private String lastName;
    @NotEmpty(message = "Email should not be empty or null")
    @Email(message = "email must be a correctly formatted address")
    private String email;
    @NotEmpty(message = "Password should not be empty or null")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{6,}$",
            message = "Password must contain at least 1 uppercase letter, 1 lowercase letter, 1 digit and have at least 6 characters")
    private String password;
    @NotEmpty(message = "Name should not be empty or null")
    @Pattern(regexp = "^[0-9]{11}$", message = "Pesel should contain exactly 11 digits")
    private String pesel;
    @NotEmpty(message = "Name should not be empty or null")
    @Pattern(regexp = "\\d{9}", message = "Phone number must contain only digits")
    private String phoneNumber;
    @NotEmpty(message = "Password should not be empty or null")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{6,}$",
            message = "Password must contain at least 1 uppercase letter, 1 lowercase letter, 1 digit and have at least 6 characters")
    private String confirmPassword;
    private boolean passwordsMatch;

    @AssertTrue(message = "Passwords must match")
    public boolean isPasswordsMatch(String password, String confirmPassword) {
        if (password == null || confirmPassword == null) {
            return false;
        }
        return password.equals(confirmPassword);
    }
}

