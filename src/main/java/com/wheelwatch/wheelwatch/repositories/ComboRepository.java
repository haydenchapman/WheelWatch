package com.wheelwatch.wheelwatch.repositories;

import com.wheelwatch.wheelwatch.dtos.ComboDto;
import com.wheelwatch.wheelwatch.entities.Combo;
import com.wheelwatch.wheelwatch.entities.Tires;
import com.wheelwatch.wheelwatch.entities.Wheels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComboRepository extends JpaRepository<Combo, Long> {
    Combo save(Combo combo);
}
