package com.ehizman.drones.service;

import com.ehizman.drones.data.model.Drone;
import com.ehizman.drones.data.repository.DroneRepository;
import com.ehizman.drones.dto.DroneRegistrationDto;
import com.ehizman.drones.dto.DroneResponseDto;
import com.ehizman.drones.dto.mapper.DroneMapper;
import com.ehizman.drones.exceptions.DroneApplicationExceptionReason;
import com.ehizman.drones.exceptions.DronesApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

import static com.ehizman.drones.util.Validation.validateDroneFields;

@Service
@Slf4j
public class DroneServiceImpl implements DroneService {
    private final DroneMapper mapper;
    private final DroneRepository droneRepository;

    @Autowired
    public DroneServiceImpl(DroneMapper mapper, DroneRepository droneRepository) {
        this.mapper = mapper;
        this.droneRepository = droneRepository;
    }

    @Override
    public DroneResponseDto register(@NotNull DroneRegistrationDto droneRegistrationDto) {
        log.info("Repository --> {}", droneRepository.getClass().getCanonicalName());
        Drone drone = mapper.registerDroneDtoToDto(droneRegistrationDto);
        if (drone == null){
            throw new DronesApplicationException(DroneApplicationExceptionReason.INVALID_DRONE_REGISTRATION_DETAILS);
        }
        /*Validate that none of the fields in the drone are null*/
        validateDroneFields(drone);
        log.info("Drone to be saved --> {}", drone);
        Drone savedDrone = droneRepository.save(drone);
        log.info("Saved Drone --> {}", savedDrone);
        DroneResponseDto responseDto = new DroneResponseDto();
        return mapper.droneToDroneResponseDto(savedDrone);
    }
}
