package com.ehizman.drones.service;

import com.ehizman.drones.data.model.Drone;
import com.ehizman.drones.data.model.Package;
import com.ehizman.drones.dto.DroneRegistrationDto;
import com.ehizman.drones.dto.DroneResponseDto;

public interface DroneService {
    DroneResponseDto register(DroneRegistrationDto droneRegistrationDto);
    Drone findDrone(String serialNumber);
    void load(Package aPackage, Drone drone);
}
