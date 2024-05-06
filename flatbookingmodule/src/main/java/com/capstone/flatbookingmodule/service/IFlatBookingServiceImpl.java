package com.capstone.flatbookingmodule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.flatbookingmodule.entity.FlatBooking;
import com.capstone.flatbookingmodule.exception.FlatBookingNotFoundException;
import com.capstone.flatbookingmodule.repository.IFlatBookingRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class IFlatBookingServiceImpl implements IFlatBookingService {

    @Autowired
    private IFlatBookingRepository flatBookingRepository;

    @Override
    public FlatBooking saveFlatBooking(FlatBooking flatBooking) {
        flatBooking.setBookingDate(LocalDate.now());
        flatBooking.setBookingStatus("pending");
        flatBooking.setBookingFromDate(LocalDate.of(2024, 05, 06));
        flatBooking.setBookingToDate(LocalDate.of(2025, 07, 17));

        flatBookingRepository.save(flatBooking);
        return flatBooking;
    }

    @Override
    public FlatBooking viewBookingDetailsById(int bookingId) {
        Optional<FlatBooking> optionalBooking = flatBookingRepository.findById(bookingId);
        if (optionalBooking.isEmpty()) {
            throw new FlatBookingNotFoundException("Flat booking does not exist with id" + bookingId);
        }

        FlatBooking fbooking = optionalBooking.get();
        return fbooking;
    }

    @Override
    public List<FlatBooking> viewAllBooking() {
        List<FlatBooking> fBookingList = flatBookingRepository.findAll();
        return fBookingList;
    }

    @Override
    public void acceptBookingById(int bookingId) {
        Optional<FlatBooking> optionalBooking = flatBookingRepository.findById(bookingId);
        if (optionalBooking.isEmpty()) {
            throw new FlatBookingNotFoundException("Flat booking does not exist with id" + bookingId);
        }
        FlatBooking flatBooking = optionalBooking.get();
        flatBooking.setBookingStatus("flatbooking accepted");
        flatBookingRepository.save(flatBooking);
    }

    @Override
    public void denyBookingById(int bookingId) {
        Optional<FlatBooking> optionalBooking = flatBookingRepository.findById(bookingId);
        if (optionalBooking.isEmpty()) {
            throw new FlatBookingNotFoundException("Flat booking does not exist with id" + bookingId);
        }
        FlatBooking flatBooking = optionalBooking.get();
        flatBooking.setBookingStatus("flatbooking denied");
        flatBookingRepository.save(flatBooking);
        
    }
	@Override
	public String viewBookingStatusById(int bookingId) {
		 Optional<FlatBooking> optionalBooking = flatBookingRepository.findById(bookingId);
		    if (optionalBooking.isEmpty()) {
		        throw new FlatBookingNotFoundException("Flat booking does not exist with id" + bookingId);
		    }
		    FlatBooking flatBooking = optionalBooking.get();
		    return flatBooking.getBookingStatus();
	}
}