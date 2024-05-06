package com.capstone.landlordmodule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.landlordmodule.entity.Landlord;
import com.capstone.landlordmodule.exception.LandlordNotFoundException;
import com.capstone.landlordmodule.repository.ILandlordRepository;

@Service
public class ILandlordServiceImpl implements ILandlordService {

	@Autowired
	private ILandlordRepository landlordRepository;

	@Override
	public Landlord addLandlord(Landlord landlord) {
		landlordRepository.save(landlord);
		return landlord;
	}

	@Override
	public void deleteLandlordById(int landlordId) {
		Optional<Landlord> optionalLandlord = landlordRepository.findById(landlordId);
		if (optionalLandlord.isEmpty()) {
			throw new LandlordNotFoundException("Landlord with id " + landlordId + "does not exist");
		}
		Landlord landlord = optionalLandlord.get();
		landlordRepository.delete(landlord);

	}

	@Override
	public Landlord viewLandlordById(int landlordId) {
		Optional<Landlord> optionalLandlord = landlordRepository.findById(landlordId);
		if (optionalLandlord.isEmpty()) {
			throw new LandlordNotFoundException("Landlord with id " + landlordId + "does not exist");
		}
		Landlord landlord = optionalLandlord.get();
		return landlord;
	}

	@Override
	public List<Landlord> viewAllLandlords() {
		List<Landlord> landlords = landlordRepository.findAll();
		return landlords;
	}

}