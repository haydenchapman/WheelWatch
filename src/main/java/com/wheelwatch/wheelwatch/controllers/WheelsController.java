package com.wheelwatch.wheelwatch.controllers;

import com.wheelwatch.wheelwatch.dtos.WheelsDto;
import com.wheelwatch.wheelwatch.services.WheelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/wheels")
public class WheelsController {
    @Autowired
    WheelsService wheelsService;

    //get all wheels by userId
    @GetMapping("/user/userId")
    public Optional<WheelsDto> getWheelsByUserId(@PathVariable Long userId){
        return wheelsService.getWheelsById(userId);
    }

    //get wheel by wheelId
//    @GetMapping("/wheels/wheelId")
//    public Optional<WheelsDto> getWheelsById(@PathVariable Long wheelId){
//        return wheelsService.getWheelsById(wheelId);
//    }

    @GetMapping
    public List<WheelsDto> getAllWheels(){
        return wheelsService.getAllWheels();
    }
}
