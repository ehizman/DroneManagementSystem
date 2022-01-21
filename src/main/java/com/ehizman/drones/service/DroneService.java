package com.ehizman.drones.service;

import com.ehizman.drones.data.model.Drone;
import com.ehizman.drones.data.model.Medication;
import com.ehizman.drones.dto.DroneRegistrationDto;
import com.ehizman.drones.dto.DroneResponseDto;
import com.ehizman.drones.dto.MedicationRequestDto;

public interface DroneService {
    DroneResponseDto register(DroneRegistrationDto droneRegistrationDto);
    Drone findDrone(String serialNumber);
    void load(Medication medication, Drone drone);
}
