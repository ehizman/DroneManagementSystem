//package com.ehizman.drones.service;
//
//import com.ehizman.drones.data.model.Role;
//import com.ehizman.drones.data.model.User;
//import com.ehizman.drones.data.model.Privilege;
//import com.ehizman.drones.data.model.enums.Type;
//import com.ehizman.drones.data.repository.RoleRepository;
//import com.ehizman.drones.data.repository.UserRepository;
//import com.ehizman.drones.dto.UserDto;
//import com.ehizman.drones.dto.UserResponseDto;
//import com.ehizman.drones.dto.mapper.UserMapper;
//import com.ehizman.drones.exceptions.DroneApplicationExceptionReason;
//import com.ehizman.drones.exceptions.DronesApplicationException;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.stream.Collectors;
//
//
//@Slf4j
//@Service
//public class UserServiceImpl implements UserDetailsService, UserService{
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final UserMapper userMapper;
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper, BCryptPasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.userMapper = userMapper;
//        this.passwordEncoder = passwordEncoder;
//        this.roleRepository = roleRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findUserByEmail(email).orElse(null);
//        if (user == null){
//            throw new DronesApplicationException(DroneApplicationExceptionReason.USER_ACCOUNT_NOT_FOUND);
//        }
//        List<SimpleGrantedAuthority> authorities = getAuthorities(user.getRole().getAuthorities());
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
//    }
//    private List<SimpleGrantedAuthority> getAuthorities(List<Privilege> authorities) {
//        return authorities.stream()
//                .map(authority -> new SimpleGrantedAuthority(authority.name()))
//                .collect(Collectors.toList());
//    }
////    @Override
////    @Transactional
////    public UserResponseDto register(UserDto userDto) {
////        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
////        User user = userMapper.userDtoToUser(userDto);
////        log.info("user before saving --> {}", user);
////        if (userRepository.findUserByEmail(user.getEmail()).isPresent()){
////            throw new DronesApplicationException(DroneApplicationExceptionReason.USER_ALREADY_EXISTS_IN_DATABASE);
////        }
////        Role role = new Role();
////        role.setRoleType(Type.USER);
////        List<Privilege> authorities = new ArrayList<>();
////        authorities.add(Privilege.LOAD_DRONE);
////        role.setAuthorities(authorities);
////        roleRepository.save(role);
////        user.setRole(role);
////        user = userRepository.save(user);
////        return userMapper.userToUserResponseDto(user);
////    }
//}
