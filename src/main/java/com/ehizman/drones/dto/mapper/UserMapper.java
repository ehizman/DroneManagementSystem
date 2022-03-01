package com.ehizman.drones.dto.mapper;

import com.ehizman.drones.data.model.Medication;
import com.ehizman.drones.data.model.User;
import com.ehizman.drones.dto.UserDto;
import com.ehizman.drones.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({})
    User userDtoToUser(UserDto userDto);

    @Mappings({})
    UserResponseDto userToUserResponseDto(User user);
}
