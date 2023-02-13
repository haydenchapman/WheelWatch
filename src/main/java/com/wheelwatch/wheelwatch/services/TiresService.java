package com.wheelwatch.wheelwatch.services;

import com.wheelwatch.wheelwatch.dtos.TiresDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface TiresService {
    //delete
    @Transactional
    void deleteTireById(Long tireId);

    Optional<TiresDto> getTiresById(Long tireId);

    List<TiresDto> getAllTires();
}
