package com.ehizman.drones.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
