package com.wheelwatch.wheelwatch.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

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
    //SHOW TO ROBERT!!!
    //wheelRelationship

    @ManyToOne(targetEntity = Wheels.class)
    @JoinColumn(name = "wheel_id")
    private Long wheelId;

    @JoinColumn(name = "brand")
    private String wheelBrand;

    @JoinColumn(name = "boltpattern")
    private String wheelBoltPattern;

    @JoinColumn(name = "diameter")
    private Integer wheelDiameter;

    @JoinColumn(name = "finish")
    private String wheelFinish;

    @JoinColumn(name = "material")
    private String wheelMaterial;

    @JoinColumn(name = "model")
    private String wheelModel;

    @JoinColumn(name = "wheel_offset")
    private Float wheelOffset;

    @JoinColumn(name = "width")
    private Integer wheelWidth;


    //tireRelationships
    @ManyToOne(targetEntity = Tires.class)
    @JoinColumn(name = "tire_id", referencedColumnName = "id")
    private Long tireId;

    @JoinColumn(name = "brand")
    private String tireBrand;

    @Column(name = "model")
    private String tireModel;

    @Column(name = "diameter")
    private Integer tireDiameter;

    @Column(name = "width")
    private Double tire_Width;

    @Column(name = "aspectRatio")
    private Integer tireAspectRatio;

    @Column(name = "tire_type")
    private String tireType;

    @Column(name = "price")
    private Double tirePrice;

    //Combo Creation
    public static Combo createCombo(Wheels wheels, Tires tires){
        Combo combo = new Combo();

        //tires
        combo.setTireId(tires.getId());
        combo.setTireBrand(tires.getBrand());
        combo.setTireModel(tires.getModel());
        combo.setTireDiameter(tires.getDiameter());
        combo.setTireAspectRatio(tires.getAspectRatio());
        combo.setTire_Width(tires.getWidth());
        combo.setTireType(tires.getTireType());
        combo.setTirePrice(tires.getPrice());

        //wheels
        combo.setWheelId(wheels.getId());
        combo.setWheelBrand(combo.wheelBrand);
        combo.setWheelModel(combo.wheelModel);

        return new Combo();
    }

    public void setTires(Tires tires) {
    }

    public void setWheels(Wheels wheels){

    }
}
