package com.ehizman.drones.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
@RequiredArgsConstructor
public class MedicationRequestDto {
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$")
    private final String name;

    @Min(value = 0)
    @Max(value = 500)
    private final Double weight;

    @Pattern(regexp = "^[A-Z0-9_]+$")
    private final String code;

    private final String image;
}
