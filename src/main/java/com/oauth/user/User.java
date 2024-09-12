package com.oauth.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String family_name;

    private String given_name;

    private String name;

    private String picture;

    private Boolean verified_email;

    private Boolean isGoogleUser;

    private Boolean isAppleUser;

    public User(String email, String family_name, String given_name, String name, String picture, Boolean verified_email, Boolean isGoogleUser, Boolean isAppleUser) {
        this.email = email;
        this.family_name = family_name;
        this.given_name = given_name;
        this.name = name;
        this.picture = picture;
        this.verified_email = verified_email;
        this.isGoogleUser = isGoogleUser;
        this.isAppleUser = isAppleUser;
    }
}
