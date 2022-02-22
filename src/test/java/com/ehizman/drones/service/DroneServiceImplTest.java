package com.ehizman.drones.service;

import com.ehizman.drones.DataConfig;
import com.ehizman.drones.data.model.Drone;
import com.ehizman.drones.data.model.Medication;
import com.ehizman.drones.data.model.enums.Model;
import com.ehizman.drones.data.repository.DroneRepository;
import com.ehizman.drones.dto.DroneRegistrationDto;
import com.ehizman.drones.dto.DroneResponseDto;
import com.ehizman.drones.dto.mapper.DroneMapper;
import com.ehizman.drones.exceptions.DronesApplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@DataJpaTest
@ComponentScan(basePackages = "com.ehizman.drones.**")
@ContextConfiguration(classes = {DataConfig.class})
@ExtendWith(MockitoExtension.class)
class DroneServiceImplTest {
    @Mock
    DroneRepository droneRepository;

    private DroneServiceImpl droneService;

    @Captor
    ArgumentCaptor<Drone> droneArgumentCaptor;

    @Autowired
    private DroneMapper mapper;

    @BeforeEach
    public void setUp() {
        droneService = new DroneServiceImpl(mapper, droneRepository);
    }

    @Test
    void register() {
        //given
        DroneRegistrationDto droneRegistrationDto = DroneRegistrationDto.builder()
                .batteryCapacity(50)
                .serialNumber("1232567890")
                .weight(240.0)
                .model(Model.HEAVYWEIGHT).build();
        Drone drone = mapper.registerDroneDtoToDto(droneRegistrationDto);
        when(droneRepository.save(any(Drone.class))).thenReturn(drone);
        DroneResponseDto droneResponseDto = droneService.register(droneRegistrationDto);
        verify(droneRepository).save(droneArgumentCaptor.capture());
        Drone drone1 = droneArgumentCaptor.getValue();
        assertThat(drone1).isNotNull();
        assertThat(drone1.getBatteryCapacity()).isEqualTo(droneResponseDto.getBatteryCapacity());
        assertThat(drone1.getModel()).isEqualTo(droneResponseDto.getModel());
        assertThat(drone1.getWeight()).isEqualTo(droneResponseDto.getWeight());
        assertThat(drone1.getSerialNumber()).isEqualTo(droneResponseDto.getSerialNumber());
    }

    @Test
    void validateDrone(){
        DroneRegistrationDto droneRegistrationDto = com.ehizman.drones.dto.DroneRegistrationDto.builder()
                .batteryCapacity(20)
                .serialNumber("1232567890")
                .weight(100.0).build();
        assertThrows(DronesApplicationException.class, ()-> droneService.register(droneRegistrationDto));
    }

    @Test
    void testThrowsExceptionWhenDroneIsOverloaded(){
        Medication medication = Medication.builder()
                                            .name("Panadol")
                                            .code("PAN45678")
                                            .image("image")
                                            .weight(500.00).build();
        Drone drone = Drone.builder()
                .batteryCapacity(50)
                .serialNumber("1232567890")
                .weight(240.0)
                .model(Model.HEAVYWEIGHT).build();
        assertThrows(DronesApplicationException.class, ()->droneService.load(medication, drone));
    }

    @Test
    void testCanLoadDroneWithMedication(){
        Medication medication = Medication.builder()
                .name("Panadol")
                .code("PAN45678")
                .image("image")
                .weight(50.00).build();
        Drone drone = Drone.builder()
                .batteryCapacity(50)
                .serialNumber("1232567890")
                .weight(240.0)
                .model(Model.HEAVYWEIGHT).build();
        droneService.load(medication, drone);

    }
}