package com.my_portfolio.backend.Model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmailDTO {

    @NotBlank(message = "Email cannot be blank.")
    @Email
    private String email;

    @NotBlank(message = "Full Name cannot be blank.")
    @Size(min = 5, message = "Full Name must be at least 5 characters.")
    private String fullName;

    @Size(min = 10, max = 500, message = "Message must be between 10 and 500 characters.")
    @NotBlank(message = "Message cannot be blank.")
    private String message;

}
