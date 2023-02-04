package com.wheelwatch.wheelwatch.services;

import com.wheelwatch.wheelwatch.dtos.WheelsDto;
import com.wheelwatch.wheelwatch.entities.Wheels;
import com.wheelwatch.wheelwatch.repositories.UserRepository;
import com.wheelwatch.wheelwatch.repositories.WheelsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WheelsServiceImpl implements WheelsService {
    private UserRepository userRepository;
    private WheelsRepository wheelsRepository;

    //delete by id
    @Override
    @Transactional
    public void deleteWheelById(Long wheelId){
        Optional<Wheels> wheelsOptional = wheelsRepository.findById(wheelId);
        wheelsOptional.ifPresent(wheels -> wheelsRepository.delete(wheels));
    }

    //get all wheels by id
    @Override
    public Optional<WheelsDto> getWheelsById(Long wheelId){
        Optional<Wheels> wheelsOptional = wheelsRepository.findById(wheelId);
           if(wheelsOptional.isPresent()){
               return Optional.of(new WheelsDto(wheelsOptional.get()));
           }
           return Optional.empty();
    }
    //get all wheels
    @Override
    public List<WheelsDto> getAllWheels(){
        List<Wheels> wheelsList = wheelsRepository.findAll();
        return wheelsList.stream().map(wheels -> new WheelsDto(wheels)).collect(Collectors.toList());
    }
}
