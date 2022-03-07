package com.ehizman.drones.dto.mapper;

import com.ehizman.drones.data.model.Package;
import com.ehizman.drones.data.model.Package.MedicationBuilder;
import com.ehizman.drones.dto.MedicationRequestDto;
import com.ehizman.drones.dto.MedicationResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-03T13:31:32+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Azul Systems, Inc.)"
)
@Component
public class MedicationMapperImpl implements MedicationMapper {

    @Override
    public Package medicationRequestDtoToMedication(MedicationRequestDto medicationRequestDto) {
        if ( medicationRequestDto == null ) {
            return null;
        }

        MedicationBuilder medication = Package.builder();

        medication.name( medicationRequestDto.getName() );
        medication.weight( medicationRequestDto.getWeight() );
        medication.code( medicationRequestDto.getCode() );
        medication.image( medicationRequestDto.getImage() );

        return medication.build();
    }

    @Override
    public MedicationResponseDto medicationToMedicationResponseDto(Package aPackage) {
        if ( aPackage == null ) {
            return null;
        }

        MedicationResponseDto medicationResponseDto = new MedicationResponseDto();

        return medicationResponseDto;
    }
}
