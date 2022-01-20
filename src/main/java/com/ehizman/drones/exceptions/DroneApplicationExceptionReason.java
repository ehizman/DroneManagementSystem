package com.ehizman.drones.exceptions;

import com.ehizman.drones.exceptions.policy.DroneApplicationExceptionPolicy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum DroneApplicationExceptionReason implements DroneApplicationExceptionPolicy {
    LOW_BATTERY_EXCEPTION("Battery level is below 25%", HttpStatus.BAD_REQUEST),
    INVALID_DRONE_REGISTRATION_DETAILS("Drone Registration contains some invalid fields", HttpStatus.BAD_REQUEST);

    private final String code = DronesApplicationException.class.getSimpleName();
    private final String message;
    private final HttpStatus httpStatus;

}
