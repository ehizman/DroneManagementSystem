package com.ehizman.drones.data.repository;

import com.ehizman.drones.data.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
