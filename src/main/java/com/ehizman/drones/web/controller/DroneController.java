package com.ehizman.drones.web.controller;

import com.ehizman.drones.data.model.Drone;
import com.ehizman.drones.data.model.Package;
import com.ehizman.drones.dto.DroneRegistrationDto;
import com.ehizman.drones.dto.DroneResponseDto;
import com.ehizman.drones.dto.MedicationRequestDto;
import com.ehizman.drones.dto.mapper.MedicationMapper;
import com.ehizman.drones.exceptions.DronesApplicationException;
import com.ehizman.drones.service.DroneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("dronesProject/api/v1/drones/")
@Slf4j
@Validated
public class DroneController {
    private final DroneService droneService;
    private final MedicationMapper medicationMapper;


    public DroneController(DroneService droneService, MedicationMapper medicationMapper) {
        this.droneService = droneService;
        this.medicationMapper = medicationMapper;
    }

    @PostMapping(value = "/new-drone", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> register(@Valid @RequestBody @NotNull DroneRegistrationDto droneRegistrationDto) throws DronesApplicationException {
        log.info("Request --> {}", droneRegistrationDto);
        DroneResponseDto savedDrone= droneService.register(droneRegistrationDto);
        log.info("Saved drone --> {}", savedDrone);
        return new ResponseEntity<>(savedDrone, HttpStatus.CREATED);
    }

    @PostMapping(value = "/load-drone/{serialNumber}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> loadDrone(@Valid @RequestBody @NotNull MedicationRequestDto medicationRequestDto,
                                       @NotNull @NotBlank @PathVariable(name = "serialNumber") String serialNumber){
        Drone drone =droneService.findDrone(serialNumber);
        log.info("Drone to load --> {}", drone);
        log.info("Medication --> {}", medicationRequestDto);
        Package aPackage = medicationMapper.medicationRequestDtoToMedication(medicationRequestDto);
        droneService.load(aPackage, drone);
        return new ResponseEntity<>("Drone loaded", HttpStatus.OK);
    }
}
