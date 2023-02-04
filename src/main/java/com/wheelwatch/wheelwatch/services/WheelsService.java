package com.wheelwatch.wheelwatch.services;

import com.wheelwatch.wheelwatch.dtos.WheelsDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface WheelsService {
    //delete by id
    @Transactional
    void deleteWheelById(Long wheelId);

    //get all wheels by id
    Optional<WheelsDto> getWheelsById(Long wheelId);

    //get all wheels
    List<WheelsDto> getAllWheels();
}
