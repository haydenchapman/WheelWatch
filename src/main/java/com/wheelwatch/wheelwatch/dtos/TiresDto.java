package com.wheelwatch.wheelwatch.dtos;

import com.wheelwatch.wheelwatch.entities.Tires;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TiresDto implements Serializable {
    private Long id;
    private Integer diameter;
    private Double width;
    private Integer aspectRatio;
    private String tireType;
    private String brand;
    private String model;
    private Double price;

    public TiresDto(Tires tires){
        if(tires.getId() != null){
            this.id = tires.getId();
        }
        if(tires.getDiameter() != null){
            this.diameter = tires.getDiameter();
        }
        if(tires.getWidth() != null){
            this.width = tires.getWidth();
        }
        if(tires.getAspectRatio() != null){
            this.aspectRatio = tires.getAspectRatio();
        }
        if(tires.getTireType() != null){
            this.tireType = tires.getTireType();
        }
        if(tires.getBrand() != null){
            this.brand = tires.getBrand();
        }
        if(tires.getModel() != null){
            this.model = tires.getModel();
        }
        if(tires.getPrice() != null){
            this.price = tires.getPrice();
        }
    }
}
