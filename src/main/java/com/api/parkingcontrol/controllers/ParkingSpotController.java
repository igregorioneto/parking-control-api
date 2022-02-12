package com.api.parkingcontrol.controllers;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dto.ParkingSpotDto;
import com.api.parkingcontrol.model.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking")
public class ParkingSpotController {

	@Autowired
	private ParkingSpotService service;
	
	@PostMapping
	public ResponseEntity<ParkingSpotModel> save(@RequestBody @Valid ParkingSpotDto parking) {
		var parkingModel = new ParkingSpotModel();
		BeanUtils.copyProperties(parking, parkingModel);
		parkingModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(parkingModel));
	}
	
	@GetMapping
	public ResponseEntity<List<ParkingSpotModel>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ParkingSpotModel> findById(@PathVariable(value = "id") UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}
	
}
