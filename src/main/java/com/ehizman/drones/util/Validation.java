package com.ehizman.drones.util;

import com.ehizman.drones.data.model.Drone;
import com.ehizman.drones.exceptions.DroneApplicationExceptionReason;
import com.ehizman.drones.exceptions.DronesApplicationException;

public class Validation {
    public static void validateDroneFields(Drone drone){
        if (drone.getSerialNumber() == null || drone.getSerialNumber().trim().equals("")){
            throw new DronesApplicationException(DroneApplicationExceptionReason.INVALID_DRONE_REGISTRATION_DETAILS);
        }
        if (drone.getModel() == null){
            throw new DronesApplicationException(DroneApplicationExceptionReason.INVALID_DRONE_REGISTRATION_DETAILS);
        }
        if (drone.getBatteryCapacity() == null){
            throw new DronesApplicationException(DroneApplicationExceptionReason.INVALID_DRONE_REGISTRATION_DETAILS);
        }
        if (drone.getWeight() == null || drone.getWeight() > 500.0){
            throw new DronesApplicationException(DroneApplicationExceptionReason.INVALID_DRONE_REGISTRATION_DETAILS);
        }
    }
}
