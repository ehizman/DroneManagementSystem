package com.ehizman.drones.dto.mapper;

import com.ehizman.drones.data.model.Drone;
import com.ehizman.drones.dto.DroneRegistrationDto;
import com.ehizman.drones.dto.DroneResponseDto;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface DroneMapper {

    @Mappings({})
    Drone registerDroneDtoToDto(DroneRegistrationDto droneRegistrationDto);

    @Mappings({})
    DroneResponseDto droneToDroneResponseDto(Drone drone);
}
