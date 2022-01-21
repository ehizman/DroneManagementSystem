package com.ehizman.drones.dto.mapper;

import com.ehizman.drones.data.model.Medication;
import com.ehizman.drones.dto.MedicationRequestDto;
import com.ehizman.drones.dto.MedicationResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-21T17:34:27+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Azul Systems, Inc.)"
)
@Component
public class MedicationMapperImpl implements MedicationMapper {

    @Override
    public Medication medicationRequestDtoToMedication(MedicationRequestDto medicationRequestDto) {
        if ( medicationRequestDto == null ) {
            return null;
        }

        String name = null;
        Double weight = null;
        String code = null;
        String image = null;

        name = medicationRequestDto.getName();
        weight = medicationRequestDto.getWeight();
        code = medicationRequestDto.getCode();
        image = medicationRequestDto.getImage();

        Medication medication = new Medication( name, weight, code, image );

        return medication;
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
