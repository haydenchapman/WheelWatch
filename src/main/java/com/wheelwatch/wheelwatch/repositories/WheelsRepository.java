package com.wheelwatch.wheelwatch.repositories;

import com.wheelwatch.wheelwatch.entities.User;
import com.wheelwatch.wheelwatch.entities.Wheels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelsRepository extends JpaRepository<Wheels, Long> {

}
