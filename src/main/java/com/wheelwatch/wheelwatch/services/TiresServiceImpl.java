package com.wheelwatch.wheelwatch.services;

import com.wheelwatch.wheelwatch.dtos.TiresDto;
import com.wheelwatch.wheelwatch.entities.Tires;
import com.wheelwatch.wheelwatch.repositories.TiresRepository;
import com.wheelwatch.wheelwatch.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TiresServiceImpl implements TiresService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TiresRepository tiresRepository;

    @Transactional
    public void deleteTireById(Long tireId){
        Optional<Tires> tiresOptional = tiresRepository.findById(tireId);
        tiresOptional.ifPresent(tires -> tiresRepository.delete(tires));
    }

    public Optional<TiresDto> getTiresById(Long tireId){
        Optional<Tires> tiresOptional = tiresRepository.findById(tireId);
        if(tiresOptional.isPresent()){
            return Optional.of(new TiresDto(tiresOptional.get()));
        }
        return Optional.empty();
    }

    public List<TiresDto> getAllTires(){
        List<Tires> tiresList = tiresRepository.findAll();
        return tiresList.stream().map(tires -> new TiresDto(tires)).collect(Collectors.toList());
    }
}
