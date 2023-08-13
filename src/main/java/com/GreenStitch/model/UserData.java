package com.GreenStitch.model;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class UserData {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Email(message = "Enter a valid Email address")
    private String email;

    private String role = "STANDARD_USER";

	@Size(min = 1, max = 100, message = "Minimum name size should be 1 character at least and maximum is 100 chars")
    private String username;

    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
            message = "Password should contain at least 8 characters, including at least one digit, one lowercase letter, one uppercase letter, and one special character."
        )
    private String password;
}
