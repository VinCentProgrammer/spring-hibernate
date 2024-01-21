package com.dungken.SpringMVCAndJPA.RegisterUser;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class RegisterUser {
    @NotBlank(message = "Không được để trống username!")
    @Size(min = 1, message = "Username tối thiểu 1 ký tự!")
    private String username;
    @NotBlank(message = "Không được để trống password!")
    @Size(min = 8, message = "Password tối thiểu 8 ký tự!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
        message = "Password không đúng định dạng!"
    )
    private String password;
    @NotBlank(message = "Không được để trống firstName!")
    private String firstName;
    @NotBlank(message = "Không được để trống lastName!")
    private String lastName;
    @NotBlank(message = "Không được để trống email!")
    @Email(message = "Email không hợp lệ!")
    private String email;

    public RegisterUser() {
    }

    public RegisterUser(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "RegisterUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
