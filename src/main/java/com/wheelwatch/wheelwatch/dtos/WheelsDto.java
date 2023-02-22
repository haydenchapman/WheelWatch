package com.wheelwatch.wheelwatch.dtos;

import com.wheelwatch.wheelwatch.entities.Wheels;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WheelsDto implements Serializable {
    private Long id;
    private Integer diameter;
    private Double width;
    private Float offset;
    private String brand;
    private String model;
    private String material;
    private String finish;
    private String boltPattern;
    private String imgUrl;

    public WheelsDto(Wheels wheels){
        if(wheels.getId() != null){
            this.id = wheels.getId();
        }
        if(wheels.getDiameter() != null){
            this.diameter = wheels.getDiameter();
        }
        if(wheels.getWidth() != null){
            this.width = wheels.getWidth();
        }
        if(wheels.getOffset() != null){
            this.offset = wheels.getOffset();
        }
        if(wheels.getBrand() != null){
            this.brand = wheels.getBrand();
        }
        if(wheels.getModel() != null){
            this.model = wheels.getModel();
        }
        if(wheels.getMaterial() != null){
            this.material = wheels.getMaterial();
        }
        if(wheels.getFinish() != null){
            this.finish = wheels.getFinish();
        }
        if (wheels.getBoltPattern() != null){
            this.boltPattern = wheels.getBoltPattern();
        }
        if (wheels.getImgUrl() != null){
            this.imgUrl = wheels.getImgUrl();
        }
    }
}
