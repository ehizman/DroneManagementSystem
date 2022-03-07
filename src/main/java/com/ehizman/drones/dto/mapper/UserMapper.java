package com.ehizman.drones.dto.mapper;

import com.ehizman.drones.data.model.User;
import com.ehizman.drones.dto.UserRegistrationRequest;
import com.ehizman.drones.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({})
    User userDtoToUser(UserRegistrationRequest userRegistrationRequest);

    @Mappings({})
    UserResponseDto userToUserResponseDto(User user);
}
