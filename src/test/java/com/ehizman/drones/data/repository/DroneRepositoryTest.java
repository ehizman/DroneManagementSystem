package com.ehizman.drones.data.repository;

import com.ehizman.drones.data.model.Drone;
import com.ehizman.drones.data.model.enums.Model;
import com.ehizman.drones.data.model.enums.State;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DroneRepositoryTest {
    private final DroneRepository droneRepository;

    @Autowired
    public DroneRepositoryTest(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Test
    void canFindDroneBySerialNumber() {
        Drone drone = Drone.builder()
                .serialNumber("SCN12048848")
                .batteryCapacity(50)
                .model(Model.HEAVYWEIGHT)
                .weight(500.0)
                .state(State.IDLE)
                .build();
        droneRepository.save(drone);

        Drone droneOne = droneRepository.findDroneBySerialNumber(drone.getSerialNumber());
        assertThat(droneOne.getSerialNumber()).isEqualTo("SCN12048848");
}
