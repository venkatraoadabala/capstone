package com.capstone.landlordmodule.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.capstone.landlordmodule.model.FlatBooking;


@FeignClient(name = "FLATBOOKINGMODULE")
public interface IFlatBookingConsumer {
    
    @PostMapping("/booking/acceptbooking/{id}")
    FlatBooking acceptBooking(@PathVariable("id") int bookingId);
    
    @PostMapping("/booking/denybooking/{id}")
    FlatBooking denyBooking(@PathVariable("id") int bookingId);
    
}
