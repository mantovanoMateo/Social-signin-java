package com.oauth.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AppleSiginInDto {
    private String email;
    private String name;
    private String lastname;
    private String appleUser;
}
