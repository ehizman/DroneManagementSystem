package com.ehizman.drones.dto;

import com.ehizman.drones.data.model.enums.Model;
import lombok.*;

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
    private Double weight;
    @NotNull
    private Integer batteryCapacity;
    @NotNull
    private Model model;
}
