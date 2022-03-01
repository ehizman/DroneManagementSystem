package com.ehizman.drones.service;

import com.ehizman.drones.DataConfig;
import com.ehizman.drones.data.model.Drone;
import com.ehizman.drones.data.model.Medication;
import com.ehizman.drones.data.model.enums.Model;
import com.ehizman.drones.data.model.enums.State;
import com.ehizman.drones.data.repository.DroneRepository;
import com.ehizman.drones.dto.DroneRegistrationDto;
import com.ehizman.drones.dto.DroneResponseDto;
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

import static org.assertj.core.api.Assertions.assertThat;
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
    void validateDrone(){
        DroneRegistrationDto droneRegistrationDto = DroneRegistrationDto.builder()
                .batteryCapacity(20)
                .serialNumber("1232567890")
                .weight(100.0).build();
        assertThrows(DronesApplicationException.class, ()-> droneService.register(droneRegistrationDto));
    }

    @Test
    void testThrowsExceptionWhenDroneIsLoadedBeyondFiveHundredGrams(){
        DroneRegistrationDto droneRegistrationDto = DroneRegistrationDto.builder()
                .batteryCapacity(20)
                .serialNumber("1232567890")
                .weight(600.0)
                .build();
        assertThrows(DronesApplicationException.class, ()-> droneService.register(droneRegistrationDto));
    }

    @Test
    void testThrowsExceptionWhenDroneWeightIsBelowZeroGrams(){
        DroneRegistrationDto droneRegistrationDto = DroneRegistrationDto.builder()
                .batteryCapacity(20)
                .serialNumber("1232567890")
                .weight(-90.0)
                .build();
        assertThrows(DronesApplicationException.class, ()-> droneService.register(droneRegistrationDto));
    }

    @Test
    void testThrowsExceptionWhenDroneBatteryCapacityIsBelowZero(){
        DroneRegistrationDto droneRegistrationDto = DroneRegistrationDto.builder()
                .batteryCapacity(-10)
                .serialNumber("1232567890")
                .weight(500.0)
                .build();
        assertThrows(DronesApplicationException.class, ()-> droneService.register(droneRegistrationDto));
    }

    @Test
    void testThrowsExceptionWhenDroneBatteryCapacityIsAboveOneHundred(){
        DroneRegistrationDto droneRegistrationDto = DroneRegistrationDto.builder()
                .batteryCapacity(103)
                .serialNumber("1232567890")
                .weight(500.0)
                .build();
        assertThrows(DronesApplicationException.class, ()-> droneService.register(droneRegistrationDto));
    }

    @Test
    @Rollback(value = false)
    void testCanLoadDroneWithMedication(){
        Medication medication = Medication.builder()
                .name("Panadol")
                .code("PAN45678")
                .image("image")
                .weight(50.00).build();
        DroneRegistrationDto drone = DroneRegistrationDto.builder()
                .batteryCapacity(50)
                .serialNumber("1232567890")
                .weight(240.0)
                .model(Model.HEAVYWEIGHT)
                .state(State.IDLE).build();
        droneService.register(drone);
        Drone returnedFromDb = droneRepositorySpy.findDroneBySerialNumber("1232567890");
        droneService.load(medication, returnedFromDb);
        assertThat(returnedFromDb.getWeight()).isEqualTo(290.0);
        assertThat(returnedFromDb.getState()).isEqualTo(State.LOADING);
    }
}
