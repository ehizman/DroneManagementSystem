package com.ehizman.drones.data.model.enums;


import com.ehizman.drones.data.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
public enum Privileges {
    LOAD_DRONE("load drone"), DISPATCH_DRONE("dispatch a drone"), REGISTER_DRONE("register a new drone");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles;

    Privileges(String name) {
        this.name = name;
    }
}
