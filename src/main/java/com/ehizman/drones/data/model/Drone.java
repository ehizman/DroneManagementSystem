package com.ehizman.drones.data.model;
import com.ehizman.drones.data.model.enums.Model;
import com.ehizman.drones.data.model.enums.State;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "drones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    @Size(max = 100)
    @NotBlank
    private String serialNumber;

    @Column(nullable = false)
    @NotNull
    @Max(value = 500)
    @Min(value = 0)
    private Double weight;

    @Max(value = 100)
    @Min(value = 0)
    @Column(nullable = false)
    @NotNull
    private Integer batteryCapacity;

    @Enumerated
    @Column(nullable = false)
    @NotNull
    private Model model;

    @Enumerated
    @Column(nullable = false)
    @NotNull
    private State state = State.IDLE;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carrierDrone", orphanRemoval = true)
    private Set<Medication> medicationBox;

    public boolean addMedication(Medication medication){
        medication.setCarrierDrone(this);
        medicationBox.add(medication);
        return true;
    }

    @Override
    public int hashCode() {
        return 2021;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Drone) obj).getId().equals(id);
    }

    @Override
    public String toString() {
        return "Drone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", model=" + model +
                ", state=" + state +
                '}';
    }
}
