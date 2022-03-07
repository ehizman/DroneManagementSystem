package com.ehizman.drones.service;


public interface NotificationService {
    void sendVerifyAccountMailTo(String email, String userFullName, String verificationToken);
}
