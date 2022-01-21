package com.ehizman.drones.dto.mapper;

import com.ehizman.drones.data.model.Drone;
import com.ehizman.drones.dto.DroneRegistrationDto;
import com.ehizman.drones.dto.DroneResponseDto;
import com.ehizman.drones.dto.DroneResponseDto.DroneResponseDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-20T16:33:25+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Azul Systems, Inc.)"
)
@Component
public class DroneMapperImpl implements DroneMapper {

    @Override
    public Drone registerDroneDtoToDto(DroneRegistrationDto droneRegistrationDto) {
        if ( droneRegistrationDto == null ) {
            return null;
        }

        Drone drone = new Drone();

        drone.setSerialNumber( droneRegistrationDto.getSerialNumber() );
        drone.setWeight( droneRegistrationDto.getWeight() );
        drone.setBatteryCapacity( droneRegistrationDto.getBatteryCapacity() );
        drone.setModel( droneRegistrationDto.getModel() );

        return drone;
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
