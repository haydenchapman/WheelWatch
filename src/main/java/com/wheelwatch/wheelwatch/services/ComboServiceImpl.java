package com.wheelwatch.wheelwatch.services;

import com.wheelwatch.wheelwatch.dtos.ComboDto;
import com.wheelwatch.wheelwatch.entities.Combo;
import com.wheelwatch.wheelwatch.repositories.ComboRepository;
import com.wheelwatch.wheelwatch.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComboServiceImpl implements ComboService {

    private UserRepository userRepository;
    private ComboRepository comboRepository;

    @Override
    public void deleteComboById(Long comboId){
        Optional<Combo> comboOptional = comboRepository.findById(comboId);
        comboOptional.ifPresent(combo -> comboRepository.delete(combo));
    }

    @Override
    public List<ComboDto> getAllCombos() {
        List<Combo> comboList = comboRepository.findAll();
        return comboList.stream().map(combo -> new ComboDto(combo)).collect(Collectors.toList());
    }

    @Override
    public Optional<ComboDto> getComboById(Long comboId){
        Optional<Combo> comboOptional = comboRepository.findById(comboId);
        if(comboOptional.isPresent()){
            return Optional.of(new ComboDto(comboOptional.get()));
        }
        return Optional.empty();
    }
}
