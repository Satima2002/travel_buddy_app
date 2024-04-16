package com.example.travel_buddy_app.entities;



import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name="users")
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name="user_name")
    private String userName;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="dob")
    private Date dob;

    @Column(name="email")
    private String email;

//    @Column(name="age")
//    private String age;


    @Column(name="password")
    private String password;

    @Column(name="profile_photo")
    private String profilePhoto;

    @Column(name="description")
    private String description;



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getAge() {
//        return age;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

