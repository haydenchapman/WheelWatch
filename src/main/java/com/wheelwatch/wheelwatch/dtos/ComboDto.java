package com.wheelwatch.wheelwatch.dtos;

import com.wheelwatch.wheelwatch.entities.Combo;
import com.wheelwatch.wheelwatch.entities.Tires;
import com.wheelwatch.wheelwatch.entities.Wheels;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComboDto implements Serializable {
    private Long id;
    private UserDto userDto;
    private Wheels wheels;
    private Tires tires;

    public ComboDto(Combo combo){
        if (combo.getId() != null){
            this.id = combo.getId();
        }
    }
}
