package com.ehizman.drones.data.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Package {
    @Pattern(regexp = "^[a-zA-Z0-9_-]+$")
    private String name;

    @Min(value = 0)
    @Max(value = 500)
    private Double weight;

    @Id
    @Pattern(regexp = "^[A-Z0-9_]+$")
    private String code;

    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    private Drone carrierDrone;

    @Override
    public boolean equals(Object obj) {
        return (code != null && ((Package)obj).getCode().equals(code));
    }

    @Override
    public int hashCode() {
        return 2022;
    }

    @Override
    public String toString() {
        return String.format("""
                Name: %s
                Code: %s
                Weight: %f""", name, code, weight);
    }
}
