package com.ehizman.drones.data.model;
import com.ehizman.drones.data.model.enums.Authority;
import com.ehizman.drones.data.model.enums.Type;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Type roleType;

    @Transient
    private List<Authority> authorities;
}
