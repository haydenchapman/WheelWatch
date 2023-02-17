package com.wheelwatch.wheelwatch.services;

import com.wheelwatch.wheelwatch.dtos.ComboDto;
import com.wheelwatch.wheelwatch.dtos.TiresDto;

import java.util.List;
import java.util.Optional;

public interface ComboService {
    void deleteComboById(Long comboId);

    List<ComboDto> getAllCombos();

    Optional<ComboDto> getComboById(Long comboId);

    ComboDto createCombo(ComboDto comboDto);

    ComboDto createCombo(Long tireId, Long wheelId);
}
