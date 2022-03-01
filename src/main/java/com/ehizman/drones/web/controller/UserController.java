package com.ehizman.drones.web.controller;

import com.ehizman.drones.dto.UserDto;
import com.ehizman.drones.dto.UserResponseDto;
import com.ehizman.drones.exceptions.DroneApplicationExceptionReason;
import com.ehizman.drones.exceptions.DronesApplicationException;
import com.ehizman.drones.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@Slf4j
@RequestMapping("/dronesProject/api/v1/users/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<?> register(@RequestBody @NotNull UserDto userDto){
        log.info("Hit endpoint");
        if (userDto.getEmail() == null || userDto.getPassword() == null){
            throw new DronesApplicationException(DroneApplicationExceptionReason.INCOMPLETE_USER_REGISTRATION_FIELDS);
        }
        UserResponseDto userResponseDto = userService.register(userDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }
}
