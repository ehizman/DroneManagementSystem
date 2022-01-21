package com.ehizman.drones.data.repository;

import com.ehizman.drones.data.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    Drone findDroneBySerialNumber(String serialNumber);

}
