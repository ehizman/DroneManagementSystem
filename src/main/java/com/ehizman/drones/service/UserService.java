package com.ehizman.drones.service;

import com.ehizman.drones.dto.UserRegistrationRequest;
import com.ehizman.drones.dto.UserResponseDto;
import com.ehizman.drones.exception.UserException;

public interface                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    UserService {
    UserResponseDto registerUser(UserRegistrationRequest userRegistrationRequest) throws UserException;
}
