package com.ehizman.drones.dto;

import com.ehizman.drones.data.model.enums.Model;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DroneResponseDto {
    private String serialNumber;
    private double weight;
    private int batteryCapacity;
    private Model model;
}
