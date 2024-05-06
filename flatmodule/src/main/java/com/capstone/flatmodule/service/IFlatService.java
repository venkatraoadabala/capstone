package com.capstone.flatmodule.service;

import java.util.List;

import com.capstone.flatmodule.entity.Flat;


public interface IFlatService {

	Flat addFlat(Flat flat);

	void deleteFlatById(int flatId);

	Flat viewFlatById(int flatId);

	List<Flat> viewAllFlats();
	
}