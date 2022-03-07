package com.ehizman.drones.web.controller;

import com.ehizman.drones.data.model.response.APIResponse;
import com.ehizman.drones.dto.UserRegistrationRequest;
import com.ehizman.drones.dto.UserResponseDto;
import com.ehizman.drones.exception.UserException;
import com.ehizman.drones.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/userService/api/v1/user/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest) throws UserException {
        try{
            UserResponseDto userDto = userService.registerUser(userRegistrationRequest);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
        catch (UserException userException){
            return new ResponseEntity<>(new APIResponse(false, userException.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
