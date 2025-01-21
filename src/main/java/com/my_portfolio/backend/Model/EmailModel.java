package com.my_portfolio.backend.Model;

import jakarta.validation.constraints.*;

public class EmailModel {

    @NotBlank(message = "Email cannot be blank.")
    @Email
    private String email;

    @NotBlank(message = "Full Name cannot be blank.")
    @Size(min = 10, message = "Full Name must be at least 10 characters.")
    private String fullName;

    @Size(min = 10, max = 500, message = "Message must be between 10 and 500 characters.")
    @NotBlank(message = "Message cannot be blank.")
    private String message;

    @Override
    public String toString() {
        return "EmailModel{" +
                "email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public EmailModel(String email, String fullName, String message) {
        this.email = email;
        this.fullName = fullName;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EmailModel() {
    }
}
