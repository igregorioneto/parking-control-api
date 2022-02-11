package com.api.parkingcontrol.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dto.ParkingSpotDto;
import com.api.parkingcontrol.model.ParkingSpotModel;
import com.api.parkingcontrol.services.CarService;
import com.api.parkingcontrol.services.ParkingSpotService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking")
public class ParkingSpotController {

	@Autowired
	private ParkingSpotService service;
	
	@Autowired
	private CarService carService;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid ParkingSpotDto parking) {
		var parkingModel = new ParkingSpotModel();
		BeanUtils.copyProperties(parking, parkingModel);
		var carModel = carService.findById(parking.getCar_id());
		parkingModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		parkingModel.setCar(carModel.get());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(parkingModel));
	}
	
}
