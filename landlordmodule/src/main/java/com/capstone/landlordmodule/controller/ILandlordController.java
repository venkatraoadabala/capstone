package com.capstone.landlordmodule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.landlordmodule.entity.Landlord;
import com.capstone.landlordmodule.model.Flat;
import com.capstone.landlordmodule.model.FlatBooking;
import com.capstone.landlordmodule.model.Tenant;
import com.capstone.landlordmodule.service.IFlatBookingConsumer;
import com.capstone.landlordmodule.service.IFlatServiceConsumer;
import com.capstone.landlordmodule.service.ILandlordService;
import com.capstone.landlordmodule.service.ITenantServiceConsumer;


@RestController
@RequestMapping("/landlord")
public class ILandlordController {
	@Autowired
	private ILandlordService landlordService;
	
	@Autowired
	private IFlatBookingConsumer flatBookingService;
	
	@Autowired
	private IFlatServiceConsumer flatService;
	
	@Autowired
	ITenantServiceConsumer tenantService;
	
	@GetMapping("/all")
	public List<Landlord> fetchAllLandlords() {
		List<Landlord> landlords = landlordService.viewAllLandlords();
		return landlords;
	}
	@GetMapping("/viewlandlord/{id}")
	public ResponseEntity<Landlord> fetchLandlordDetails(@PathVariable("id") int landlordId) {
		Landlord landlord = landlordService.viewLandlordById(landlordId);
		return new ResponseEntity<>(landlord, HttpStatus.OK);
	}
	@PostMapping("/save")
	public ResponseEntity<Landlord> addLandlord(@RequestBody Landlord landlord) {
		landlordService.addLandlord(landlord);
		ResponseEntity<Landlord> responseEntity = new ResponseEntity<>(landlord, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLandlord(@PathVariable("id") int landlordId) {
		landlordService.deleteLandlordById(landlordId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	@PostMapping("/booking/acceptbooking/{id}")
	public ResponseEntity<FlatBooking> acceptBooking(@PathVariable("id") int bookingId) {
		flatBookingService.acceptBooking(bookingId);
		ResponseEntity<FlatBooking> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	@PostMapping("/booking/denybooking/{id}")
	public ResponseEntity<FlatBooking> denyBooking(@PathVariable("id") int bookingId) {
		flatBookingService.denyBooking(bookingId);
		ResponseEntity<FlatBooking> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/tenant/viewtenant/{tenantid}")
	public ResponseEntity<Tenant> getTenantDetails(@PathVariable("tenantid") int tenantId) {
		Tenant tenant = tenantService.getTenantDetailsById(tenantId);
		return new ResponseEntity<>(tenant, HttpStatus.OK);
	}
	@PostMapping("/flat/save")
	public ResponseEntity<Flat> saveFlat(@RequestBody Flat flat) {
		flatService.saveFlat(flat);
		ResponseEntity<Flat> responseEntity = new ResponseEntity<>(flat, HttpStatus.CREATED);
		return responseEntity;
	}
	@DeleteMapping("/flat/delete/{flatid}")
	public ResponseEntity<Flat> deleteFlatById(@PathVariable("flatid")int flatId) {
		flatService.deleteFlatById(flatId);
		ResponseEntity<Flat> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;

	}
}
