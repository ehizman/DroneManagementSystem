package com.ehizman.drones.dto;

import com.ehizman.drones.data.model.enums.Model;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DroneRegistrationDto {
    @NotNull
    private String serialNumber;
    @NotNull
    @Max(value = 500)
    @Min(value = 0)
    private Double weight;
    @NotNull
    @Max(value = 100)
    @Min(value = 0)
    private Integer batteryCapacity;
    @NotNull
    private Model model;
}
