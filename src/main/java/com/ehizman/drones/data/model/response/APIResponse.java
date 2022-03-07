package com.ehizman.drones.data.model.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class APIResponse {
    private boolean isSuccessful;
    private String message;
    private LocalDateTime timeStamp;
    private String extraInfo;

    public APIResponse(boolean isSuccessful, String message) {
        this.isSuccessful = isSuccessful;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }

    public APIResponse(boolean isSuccessful, String message, String extraInfo) {
        this.isSuccessful = isSuccessful;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
        this.extraInfo = extraInfo;
    }
}
