package com.capstone.flatmodule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.flatmodule.entity.Flat;
import com.capstone.flatmodule.exception.FlatNotFoundException;
import com.capstone.flatmodule.repository.IFlatRepository;

@Service
public class IFlatServiceImpl implements IFlatService {

	@Autowired
	private IFlatRepository flatRepository;

	@Override
	public Flat addFlat(Flat flat) {
		flatRepository.save(flat);
		return flat;

	}

	@Override
	public void deleteFlatById(int flatId) {
		Optional<Flat> optionalFlat = flatRepository.findById(flatId);
		if (optionalFlat.isEmpty()) {
			throw new FlatNotFoundException("Flatnot existing with id: " + flatId);

		}
		Flat flat = optionalFlat.get();
		flatRepository.delete(flat);

	}

	@Override
	public Flat viewFlatById(int flatId) {
		Optional<Flat> optionalFlat = flatRepository.findById(flatId);
		if (optionalFlat.isEmpty()) {
			throw new FlatNotFoundException("Flat not existing with id: " + flatId);

		}
		Flat flat = optionalFlat.get();
		return flat;

	}

	@Override
	public List<Flat> viewAllFlats() {
		List<Flat> flats = flatRepository.findAll();
		return flats;
	}

}
