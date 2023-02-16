package com.wheelwatch.wheelwatch.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Tires")
public class Tires {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "diameter")
    private Integer diameter;

    @Column(name = "width")
    private Double width;

    @Column(name = "aspectRatio")
    private Integer aspectRatio;

    @Column(name = "tireType")
    private String tireType;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JsonBackReference
    private User user;

}
