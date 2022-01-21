package com.ehizman.drones.service;

import com.ehizman.drones.data.model.Drone;
import com.ehizman.drones.data.model.Medication;
import com.ehizman.drones.data.repository.DroneRepository;
import com.ehizman.drones.dto.DroneRegistrationDto;
import com.ehizman.drones.dto.DroneResponseDto;
import com.ehizman.drones.dto.MedicationRequestDto;
import com.ehizman.drones.dto.mapper.DroneMapper;
import com.ehizman.drones.dto.mapper.MedicationMapper;
import com.ehizman.drones.exceptions.DroneApplicationExceptionReason;
import com.ehizman.drones.exceptions.DronesApplicationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

import static com.ehizman.drones.util.Validation.validateDroneFields;

@Service
@Slf4j
public class DroneServiceImpl implements DroneService {
    private final DroneMapper droneMapper;
    private final DroneRepository droneRepository;

    public DroneServiceImpl(DroneMapper droneMapper, DroneRepository droneRepository) {
        this.droneMapper = droneMapper;
        this.droneRepository = droneRepository;
    }

    @Override
    public DroneResponseDto register(@NotNull DroneRegistrationDto droneRegistrationDto) {
        log.info("Repository --> {}", droneRepository.getClass().getCanonicalName());
        Drone drone = droneMapper.registerDroneDtoToDto(droneRegistrationDto);
        if (drone == null){
            throw new DronesApplicationException(DroneApplicationExceptionReason.INVALID_DRONE_REGISTRATION_DETAILS);
        }
        /*Validate that none of the fields in the drone are null*/
        validateDroneFields(drone);
        log.info("Drone to be saved --> {}", drone);
        Drone savedDrone = droneRepository.save(drone);
        log.info("Saved Drone --> {}", savedDrone);
        DroneResponseDto responseDto = new DroneResponseDto();
        return droneMapper.droneToDroneResponseDto(savedDrone);
    }

    @Override
    public Drone findDrone(String serialNumber) {
        return droneRepository.findDroneBySerialNumber(serialNumber);
    }

    @Override
    public void load(Medication medication, Drone drone) {
    }
}
