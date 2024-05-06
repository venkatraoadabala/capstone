package com.capstone.flatbookingmodule.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.flatbookingmodule.entity.FlatBooking;
import com.capstone.flatbookingmodule.model.Flat;
import com.capstone.flatbookingmodule.service.IFlatBookingService;
import com.capstone.flatbookingmodule.service.IFlatServiceConsumer;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/booking")
public class IFlatBookingController {

	@Autowired
	private IFlatBookingService fbookingService;
	
	@Autowired
	private IFlatServiceConsumer flatService;

	@PostMapping("/requestbooking")
	public ResponseEntity<FlatBooking> requestflatBooking(@Valid @RequestBody FlatBooking flatBooking) {
        FlatBooking newFBooking = fbookingService.saveFlatBooking(flatBooking);
		return new ResponseEntity<>(newFBooking, HttpStatus.CREATED);
	}

	@GetMapping("/viewbookingdetails/{id}")
	public ResponseEntity<FlatBooking> viewBookingDetails(@PathVariable("id") int bookingId) {
		FlatBooking fbooking = fbookingService.viewBookingDetailsById(bookingId);
		return new ResponseEntity<>(fbooking, HttpStatus.OK);
	}

	@GetMapping("/all")

	public List<FlatBooking> viewAllBookings() {

		List<FlatBooking> fBookingList = fbookingService.viewAllBooking();
		return fBookingList;
	}
	@PostMapping("/acceptbooking/{id}")
	public ResponseEntity<Void> acceptBooking(@PathVariable("id") int bookingId) {
		fbookingService.acceptBookingById(bookingId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/denybooking/{id}")
	public ResponseEntity<Void> denyBooking(@PathVariable("id") int bookingId) {
		fbookingService.denyBookingById(bookingId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/flat/flatdetails/{flatid}")
	public ResponseEntity<Flat> getFlatDetailsById(@PathVariable("flatid") int flatId) {
		Flat flat = flatService.viewFlatById(flatId);
		return new ResponseEntity<>(flat, HttpStatus.OK);
	}
	
	@GetMapping("/status/{id}")
	public ResponseEntity<String> viewBookingStatus(@PathVariable("id") int bookingId) {
	    String bookingStatus = fbookingService.viewBookingStatusById(bookingId);
	    return new ResponseEntity<>(bookingStatus, HttpStatus.OK);
	}
}
