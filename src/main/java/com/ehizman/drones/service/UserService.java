package com.ehizman.drones.service;

import com.ehizman.drones.dto.UserDto;
import com.ehizman.drones.dto.UserResponseDto;

public interface UserService {
    UserResponseDto register(UserDto userDto);
}
