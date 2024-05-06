package com.capstone.landlordmodule.service;

import java.util.List;

import com.capstone.landlordmodule.entity.Landlord;

public interface ILandlordService {

	Landlord addLandlord(Landlord landlord);

	void deleteLandlordById(int landlordId);

	Landlord viewLandlordById(int landlordId);

	List<Landlord> viewAllLandlords();

}
