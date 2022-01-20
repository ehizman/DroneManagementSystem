package com.ehizman.drones.exceptions.policy;

import org.springframework.http.HttpStatus;

public interface DroneApplicationExceptionPolicy extends ExceptionPolicy {
    HttpStatus getHttpStatus();
}
