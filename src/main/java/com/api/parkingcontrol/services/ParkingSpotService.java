package com.api.parkingcontrol.services;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.api.parkingcontrol.model.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotService {
	
	@Autowired
	private ParkingSpotRepository repository;
	
	@Transactional
	public ParkingSpotModel save(ParkingSpotModel parkingSpot) {
		return repository.save(parkingSpot);
	}
	
	public List<ParkingSpotModel> findAll() {
		return repository.findAll();
	}
	
	public ParkingSpotModel findById(UUID id) {
		return repository.findById(id).get();
	}
	
	

}
