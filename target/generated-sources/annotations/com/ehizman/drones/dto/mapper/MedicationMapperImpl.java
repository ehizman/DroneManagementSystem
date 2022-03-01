package com.ehizman.drones.dto.mapper;

import com.ehizman.drones.data.model.Medication;
import com.ehizman.drones.data.model.Medication.MedicationBuilder;
import com.ehizman.drones.dto.MedicationRequestDto;
import com.ehizman.drones.dto.MedicationResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-27T17:58:11+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Azul Systems, Inc.)"
)
@Component
public class MedicationMapperImpl implements MedicationMapper {

    @Override
    public Medication medicationRequestDtoToMedication(MedicationRequestDto medicationRequestDto) {
        if ( medicationRequestDto == null ) {
            return null;
        }

        MedicationBuilder medication = Medication.builder();

        medication.name( medicationRequestDto.getName() );
        medication.weight( medicationRequestDto.getWeight() );
        medication.code( medicationRequestDto.getCode() );
        medication.image( medicationRequestDto.getImage() );

        return medication.build();
    }

    @Override
    public MedicationResponseDto medicationToMedicationResponseDto(Medication medication) {
        if ( medication == null ) {
            return null;
        }

        MedicationResponseDto medicationResponseDto = new MedicationResponseDto();

        return medicationResponseDto;
    }
}
