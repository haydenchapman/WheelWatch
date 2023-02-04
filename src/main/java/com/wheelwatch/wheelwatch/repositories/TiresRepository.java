package com.wheelwatch.wheelwatch.repositories;

import com.wheelwatch.wheelwatch.entities.Tires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiresRepository extends JpaRepository <Tires, Long> {
}
