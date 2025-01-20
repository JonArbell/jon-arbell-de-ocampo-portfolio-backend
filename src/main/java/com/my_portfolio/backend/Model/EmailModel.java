package com.my_portfolio.backend.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class EmailModel {

    @NotNull
    @Email
    private String email;

    @NotNull
    private String fullName;
    @NotNull
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
