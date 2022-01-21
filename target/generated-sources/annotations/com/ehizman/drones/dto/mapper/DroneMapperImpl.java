package com.ehizman.drones.dto.mapper;

import com.ehizman.drones.data.model.Drone;
import com.ehizman.drones.data.model.Drone.DroneBuilder;
import com.ehizman.drones.dto.DroneRegistrationDto;
import com.ehizman.drones.dto.DroneResponseDto;
import com.ehizman.drones.dto.DroneResponseDto.DroneResponseDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-21T17:34:27+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Azul Systems, Inc.)"
)
@Component
public class DroneMapperImpl implements DroneMapper {

    @Override
    public Drone registerDroneDtoToDto(DroneRegistrationDto droneRegistrationDto) {
        if ( droneRegistrationDto == null ) {
            return null;
        }

        DroneBuilder drone = Drone.builder();

        drone.serialNumber( droneRegistrationDto.getSerialNumber() );
        drone.weight( droneRegistrationDto.getWeight() );
        drone.batteryCapacity( droneRegistrationDto.getBatteryCapacity() );
        drone.model( droneRegistrationDto.getModel() );

        return drone.build();
    }

    @Override
    public DroneResponseDto droneToDroneResponseDto(Drone drone) {
        if ( drone == null ) {
            return null;
        }

        DroneResponseDtoBuilder droneResponseDto = DroneResponseDto.builder();

        droneResponseDto.serialNumber( drone.getSerialNumber() );
        if ( drone.getWeight() != null ) {
            droneResponseDto.weight( drone.getWeight() );
        }
        if ( drone.getBatteryCapacity() != null ) {
            droneResponseDto.batteryCapacity( drone.getBatteryCapacity() );
        }
        droneResponseDto.model( drone.getModel() );

        return droneResponseDto.build();
    }
}
