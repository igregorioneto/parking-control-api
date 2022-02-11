package com.api.parkingcontrol.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.parkingcontrol.model.CarModel;

public interface CarRepository extends JpaRepository<CarModel, UUID> {

}
