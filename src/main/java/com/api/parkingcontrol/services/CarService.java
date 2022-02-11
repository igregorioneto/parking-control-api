package com.api.parkingcontrol.services;

import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.parkingcontrol.model.CarModel;
import com.api.parkingcontrol.repositories.CarRepository;

@Service
public class CarService {
//	Outra forma para se aplicar
	final CarRepository repository;
	
	public CarService(CarRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public CarModel save(CarModel car) {
		return repository.save(car);
	}
	
	public Optional<CarModel> findById(UUID id) {
		return repository.findById(id);
	}

}
