package com.example.travel_buddy_app.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LoginDto {
    private String usernameOrEmail;
    private String password;

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDto(String usernameOrEmail, String password) {
        System.out.println(usernameOrEmail);
        System.out.println(password);
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;

    }
}

