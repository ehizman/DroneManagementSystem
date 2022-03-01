package com.ehizman.drones.data.repository;

import com.ehizman.drones.data.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Optional<Privilege> findByName(String name);
}
