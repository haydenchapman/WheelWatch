package com.wheelwatch.wheelwatch.services;

import com.wheelwatch.wheelwatch.dtos.ComboDto;
import com.wheelwatch.wheelwatch.entities.Combo;
import com.wheelwatch.wheelwatch.repositories.ComboRepository;
import com.wheelwatch.wheelwatch.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComboServiceImpl implements ComboService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ComboRepository comboRepository;

    @Transactional
    public void deleteComboById(Long comboId){
        Optional<Combo> comboOptional = comboRepository.findById(comboId);
        comboOptional.ifPresent(combo -> comboRepository.delete(combo));
    }

    public List<ComboDto> getAllCombos() {
        List<Combo> comboList = comboRepository.findAll();
        return comboList.stream().map(combo -> new ComboDto(combo)).collect(Collectors.toList());
    }

    public Optional<ComboDto> getComboById(Long comboId){
        Optional<Combo> comboOptional = comboRepository.findById(comboId);
        if(comboOptional.isPresent()){
            return Optional.of(new ComboDto(comboOptional.get()));
        }
        return Optional.empty();
    }
}
