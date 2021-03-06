package com.ehizman.drones.web.controller;

import com.ehizman.drones.dto.DroneRegistrationDto;
import com.ehizman.drones.dto.DroneResponseDto;
import com.ehizman.drones.exceptions.DronesApplicationException;
import com.ehizman.drones.service.DroneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("drones/v1/")
@Slf4j
@Validated
public class DroneController {
    private DroneService droneService;

    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @PostMapping(value = "/new-drone", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> register(@Valid @RequestBody @NotNull DroneRegistrationDto droneRegistrationDto) throws DronesApplicationException {
        log.info("Request --> {}", droneRegistrationDto);
        DroneResponseDto savedDrone= droneService.register(droneRegistrationDto);
        log.info("Saved drone --> {}", savedDrone);
        return new ResponseEntity<>(savedDrone, HttpStatus.OK);
    }
}
