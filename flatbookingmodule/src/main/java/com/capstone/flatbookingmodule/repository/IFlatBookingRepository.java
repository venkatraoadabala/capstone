package com.capstone.flatbookingmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.flatbookingmodule.entity.FlatBooking;

public interface IFlatBookingRepository extends JpaRepository<FlatBooking,Integer>{

}