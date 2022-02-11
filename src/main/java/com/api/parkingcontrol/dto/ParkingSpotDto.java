package com.api.parkingcontrol.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class ParkingSpotDto {

	@NotBlank
    private String parkingSpotNumber;
	@NotBlank
    private String responsibleName;
    @NotBlank
    private String apartment;
    @NotBlank
    private String block;
    @NotBlank
    private UUID car_id;
    
	public String getParkingSpotNumber() {
		return parkingSpotNumber;
	}
	public void setParkingSpotNumber(String parkingSpotNumber) {
		this.parkingSpotNumber = parkingSpotNumber;
	}
	public String getResponsibleName() {
		return responsibleName;
	}
	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}
	public String getApartment() {
		return apartment;
	}
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public UUID getCar_id() {
		return car_id;
	}
	public void setCar_id(UUID car_id) {
		this.car_id = car_id;
	}
	
}
