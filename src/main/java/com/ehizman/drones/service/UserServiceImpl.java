package com.ehizman.drones.service;

import com.ehizman.drones.data.model.User;
import com.ehizman.drones.data.model.enums.Role;
import com.ehizman.drones.data.repository.UserRepository;
import com.ehizman.drones.dto.UserRegistrationRequest;
import com.ehizman.drones.dto.UserResponseDto;
import com.ehizman.drones.dto.mapper.UserMapper;
import com.ehizman.drones.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Slf4j
@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final NotificationService notificationService;

    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper,
                           BCryptPasswordEncoder bCryptPasswordEncoder,
                           NotificationService notificationService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.notificationService = notificationService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String email = username;
        return loadAUserByEmail(email);
    }

    private UserDetails loadAUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(()->
                    new UsernameNotFoundException(String.format("No user found with this email %s", email))
                );
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities(user));
    }

    private Set<SimpleGrantedAuthority> getAuthorities(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(
                role -> {
                    authorities.addAll(role.getGrantedAuthority());
                }
        );
        return authorities;
    }


    @Override
    public UserResponseDto registerUser(UserRegistrationRequest userRegistrationRequest) throws UserException {
        if (findUserByEmail(userRegistrationRequest.getEmail())){
            throw new UserException("User account already exists");
        }
        User user = userMapper.userDtoToUser(userRegistrationRequest);
        log.info("User --> {}", user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.addRole(Role.USER);
        notificationService.sendVerifyAccountMailTo(user.getEmail(), user.getFullName(), "token");
        userRepository.save(user);
        return userMapper.userToUserResponseDto(user);
    }

    private boolean findUserByEmail(String email) {
        return userRepository.findUserByEmail(email).isPresent();
    }
}
