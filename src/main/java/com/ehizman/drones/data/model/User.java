package com.ehizman.drones.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    private long id;

    @Email
    private String email;

    @Size(min = 8)
    @Pattern(regexp = "^[A-Z|a-z]\\w+$")
    private String password;
}
