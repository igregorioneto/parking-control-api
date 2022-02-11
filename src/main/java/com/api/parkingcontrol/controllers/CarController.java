package com.api.parkingcontrol.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dto.CarDto;
import com.api.parkingcontrol.model.CarModel;
import com.api.parkingcontrol.services.CarService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/car")
public class CarController {

	final CarService service;
	
	public CarController(CarService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid CarDto car) {
		var carModel = new CarModel();
		BeanUtils.copyProperties(car, carModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(carModel));
	}
}
