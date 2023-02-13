package com.wheelwatch.wheelwatch.dtos;

import com.wheelwatch.wheelwatch.entities.Combo;
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

    public ComboDto(Combo combo){
        if (combo.getId() != null){
            this.id = combo.getId();
        }
    }
}
