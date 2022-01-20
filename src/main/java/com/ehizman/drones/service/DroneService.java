package com.ehizman.drones.service;

import com.ehizman.drones.dto.DroneRegistrationDto;
import com.ehizman.drones.dto.DroneResponseDto;

public interface DroneService {
    DroneResponseDto register(DroneRegistrationDto droneRegistrationDto);
}
