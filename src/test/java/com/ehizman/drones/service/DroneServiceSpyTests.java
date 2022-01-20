package com.ehizman.drones.service;

import com.ehizman.drones.DataConfig;
import com.ehizman.drones.data.model.enums.State;
import com.ehizman.drones.data.repository.DroneRepository;
import com.ehizman.drones.dto.DroneRegistrationDto;
import com.ehizman.drones.exceptions.DronesApplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@ComponentScan(basePackages = "com.ehizman.drones.**")
@ContextConfiguration(classes = {DataConfig.class})
@ExtendWith(MockitoExtension.class)
public class DroneServiceSpyTests {
    @Autowired
    private DroneRepository droneRepositorySpy;
    @Autowired
    private DroneServiceImpl droneService;

    @BeforeEach
    void setUp(){
    }

    @Test
    @Rollback(value = false)
    void validateDrone(){
        DroneRegistrationDto droneRegistrationDto = DroneRegistrationDto.builder()
                .batteryCapacity(20)
                .serialNumber("1232567890")
                .weight(100.0).build();
        assertThrows(DronesApplicationException.class, ()-> droneService.register(droneRegistrationDto));
    }
}
