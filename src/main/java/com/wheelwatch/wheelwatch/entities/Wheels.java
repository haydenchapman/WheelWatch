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
@Table(name = "Wheels")
public class Wheels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "diameter")
    private Integer diameter;

    @Column(name = "width")
    private Double width;

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
    private String boltPattern;

    @Column(name = "imgUrl")
    private String imgUrl;

    @ManyToOne
    @JsonBackReference
    private User user;



}
