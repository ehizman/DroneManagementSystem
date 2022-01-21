package com.ehizman.drones.dto.mapper;

import com.ehizman.drones.data.model.Medication;
import com.ehizman.drones.dto.MedicationRequestDto;
import com.ehizman.drones.dto.MedicationResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MedicationMapper {
    @Mappings({})
    Medication medicationRequestDtoToMedication(MedicationRequestDto medicationRequestDto);

    @Mappings({})
    MedicationResponseDto medicationToMedicationResponseDto(Medication medication);
}
