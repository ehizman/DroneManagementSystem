package com.ehizman.drones.dto.mapper;

import com.ehizman.drones.data.model.User;
import com.ehizman.drones.dto.UserDto;
import com.ehizman.drones.dto.UserResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-27T17:58:11+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userDto.getEmail() );
        user.setPassword( userDto.getPassword() );
        user.setFirstName( userDto.getFirstName() );
        user.setLastName( userDto.getLastName() );

        return user;
    }

    @Override
    public UserResponseDto userToUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setEmail( user.getEmail() );
        userResponseDto.setFirstName( user.getFirstName() );
        userResponseDto.setLastName( user.getLastName() );

        return userResponseDto;
    }
}
