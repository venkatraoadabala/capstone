package com.capstone.tenantmodule.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capstone.tenantmodule.model.FlatBooking;

@FeignClient(name = "FLATBOOKINGMODULE")
public interface IFlatBookingConsumer {
	
	@PostMapping("/booking/requestbooking")
	FlatBooking requestflatBooking(@RequestBody FlatBooking flatBooking);
	
	@GetMapping("/booking/status/{id}")
	String viewBookingStatusById(@PathVariable("id") int bookingId)	;

}
