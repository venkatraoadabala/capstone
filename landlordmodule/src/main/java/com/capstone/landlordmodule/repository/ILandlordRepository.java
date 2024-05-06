package com.capstone.landlordmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.landlordmodule.entity.Landlord;

public interface ILandlordRepository extends JpaRepository<Landlord, Integer> {
    
	Landlord findByLandlordId(int landlordId);
	
}
