package com.ehizman.drones.data.model.enums;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public enum Authority {
    LOAD_DRONE, DISPATCH_DRONE, REGISTER_DRONE;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
