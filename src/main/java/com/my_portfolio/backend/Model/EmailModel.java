package com.my_portfolio.backend.Model;

import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EmailModel {

    @Email
    private String email;

    private String fullName;
    private String message;

}
