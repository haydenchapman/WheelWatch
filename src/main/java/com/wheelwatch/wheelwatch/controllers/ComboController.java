package com.wheelwatch.wheelwatch.controllers;

import com.wheelwatch.wheelwatch.dtos.ComboDto;
import com.wheelwatch.wheelwatch.services.ComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/combo" )
public class ComboController {

    @Autowired
    ComboService comboService;

    @GetMapping("/comboId")
    public Optional<ComboDto> getComboById(@PathVariable Long comboId){
        return comboService.getComboById(comboId);
    }

    @GetMapping
    public List<ComboDto> getAllCombos(){
        return comboService.getAllCombos();
    }
}
