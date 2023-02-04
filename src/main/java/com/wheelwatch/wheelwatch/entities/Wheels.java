package com.wheelwatch.wheelwatch.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Wheels")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wheels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "diameter")
    private Integer diameter;

    @Column(name = "width")
    private Long width;

    @Column(name = "wheel_offset")
    private Float offset;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "material")
    private String material;

    @Column(name = "finish")
    private String finish;

    @Column(name = "boltPattern")
    private Long boltPattern;

    @ManyToOne
    @JsonBackReference
    private User user;

}
