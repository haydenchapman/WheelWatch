package com.wheelwatch.wheelwatch.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wheelwatch.wheelwatch.controllers.WheelsController;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Combo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Combo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comboId;

    public Long getId() {
        this.comboId = getComboId();
        return comboId;
    }

    @ManyToOne
    @JsonBackReference
    private Wheels wheels;

    @ManyToOne
    @JsonBackReference
    private Tires tires;

}
