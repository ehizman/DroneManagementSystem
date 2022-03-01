package com.ehizman.drones.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponseDto {
    private String email;
    private String firstName;
    private String lastName;
}
