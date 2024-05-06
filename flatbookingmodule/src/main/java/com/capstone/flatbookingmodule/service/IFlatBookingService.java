package com.capstone.flatbookingmodule.service;

import java.util.List;

import com.capstone.flatbookingmodule.entity.FlatBooking;
public interface IFlatBookingService {

	FlatBooking saveFlatBooking(FlatBooking flatBooking);
    
	FlatBooking viewBookingDetailsById(int bookingId);
    
    List<FlatBooking> viewAllBooking();
    
	void acceptBookingById(int bookingId);

    void denyBookingById(int bookingId);
    
    String viewBookingStatusById(int bookingId);
	
}
