package com.ehizman.drones.exceptions;

import com.ehizman.drones.exceptions.policy.DroneApplicationExceptionPolicy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum DroneApplicationExceptionReason implements DroneApplicationExceptionPolicy {
    LOW_BATTERY_EXCEPTION("Battery level is below 25%", HttpStatus.BAD_REQUEST),
    INVALID_DRONE_REGISTRATION_DETAILS("Drone Registration contains some invalid fields", HttpStatus.BAD_REQUEST),
    DRONE_OVERLOAD("Drone cannot be overloaded", HttpStatus.BAD_REQUEST),
    INCOMPLETE_USER_REGISTRATION_FIELDS("User registration fields are incomplete",HttpStatus.BAD_REQUEST),
    USER_ALREADY_EXISTS_IN_DATABASE("User account already exists", HttpStatus.METHOD_NOT_ALLOWED),
    USER_ACCOUNT_NOT_FOUND("User account not found", HttpStatus.BAD_REQUEST),
    PRIVILEGE_NOT_FOUND("Requested privilege is not found", HttpStatus.NOT_FOUND),
    ROLE_NOT_FOUND("Role not found", HttpStatus.BAD_REQUEST);

    private final String code = DronesApplicationException.class.getSimpleName();
    private final String message;
    private final HttpStatus httpStatus;

}
