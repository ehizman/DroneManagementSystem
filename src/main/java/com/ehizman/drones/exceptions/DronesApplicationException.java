package com.ehizman.drones.exceptions;

import com.ehizman.drones.exceptions.policy.DroneApplicationExceptionPolicy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@Getter
@Setter
public class DronesApplicationException extends RuntimeException implements DroneApplicationExceptionPolicy {

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;

    @Override
    public HttpStatus getHttpStatus() {
        return null;
    }

    @Override
    public String getCode() {
        return code;
    }

    public DronesApplicationException(final DroneApplicationExceptionReason reason) {
        this.code = reason.getCode();
        this.message = reason.getMessage();
        this.httpStatus = reason.getHttpStatus();
    }
}
