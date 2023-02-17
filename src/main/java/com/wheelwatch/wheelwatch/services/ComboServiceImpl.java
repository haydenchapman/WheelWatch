package com.wheelwatch.wheelwatch.services;

import com.wheelwatch.wheelwatch.dtos.ComboDto;
import com.wheelwatch.wheelwatch.entities.Combo;
import com.wheelwatch.wheelwatch.entities.Tires;
import com.wheelwatch.wheelwatch.entities.Wheels;
import com.wheelwatch.wheelwatch.repositories.ComboRepository;
import com.wheelwatch.wheelwatch.repositories.TiresRepository;
import com.wheelwatch.wheelwatch.repositories.UserRepository;
import com.wheelwatch.wheelwatch.repositories.WheelsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComboServiceImpl implements ComboService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ComboRepository comboRepository;
    @Autowired
    private TiresRepository tiresRepository;
    @Autowired
    private WheelsRepository wheelsRepository;

    //SHOW TO ROBERT
    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    public ComboDto createCombo(ComboDto comboDto) {
        return null;
    }

    @Override
    public ComboDto createCombo(Long tireId, Long wheelId) {
        return null;
    }

    //SHOW TO ROBERT!!

    @Transactional
    public ComboDto createCombo(Tires tires, Wheels wheels) {
        Combo combo = new Combo();
        combo.setTires(tires);
        combo.setWheels(wheels);
        entityManager.persist(combo);
        Combo savedCombo = comboRepository.save(combo);
        return new ComboDto(savedCombo);
    }
}
