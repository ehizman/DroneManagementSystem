package com.ehizman.drones.data.model;

import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@RequiredArgsConstructor
public class Medication {
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$")
    private final String name;

    @Min(value = 0)
    @Max(value = 500)
    private final Double weight;

    @Pattern(regexp = "^[A-Z0-9_]+$")
    private final String code;

    private final String image;
}
