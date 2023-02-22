package com.wheelwatch.wheelwatch.controllers;

import com.wheelwatch.wheelwatch.dtos.ComboDto;
import com.wheelwatch.wheelwatch.entities.Combo;
import com.wheelwatch.wheelwatch.entities.Tires;
import com.wheelwatch.wheelwatch.entities.Wheels;
import com.wheelwatch.wheelwatch.services.ComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/combo" )
public class ComboController {

    @Autowired
    ComboService comboService;

    @GetMapping("/combo")
    public ModelAndView showCombo() {
        Combo combo = new Combo();
        combo.setTires(new Tires());
        combo.setWheels(new Wheels());
        ModelAndView mav = new ModelAndView("combo");
        mav.addObject("combo", combo);
        return mav;
    }


    @GetMapping("/comboId")
    public Optional<ComboDto> getComboById(@PathVariable Long comboId){
        return comboService.getComboById(comboId);
    }

    @GetMapping
    public List<ComboDto> getAllCombos(){
        return comboService.getAllCombos();
    }

    @PostMapping("/combo")
    public void createCombo(Tires tires, Wheels wheels){
        Combo combo = new Combo();
    }

}
