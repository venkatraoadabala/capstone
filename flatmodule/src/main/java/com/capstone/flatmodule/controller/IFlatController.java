package com.capstone.flatmodule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.flatmodule.entity.Flat;
import com.capstone.flatmodule.service.IFlatService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/flat")
public class IFlatController {
	
	@Autowired
	private IFlatService flatService;
	
	@PostMapping("/save")
	public ResponseEntity<Flat> saveFlat(@Valid @RequestBody Flat flat) {
		flatService.addFlat(flat);
		ResponseEntity<Flat> responseEntity = new ResponseEntity<>(flat,HttpStatus.CREATED);
		return responseEntity;
	}
	
	@DeleteMapping("/delete/{flatid}")
	public ResponseEntity<Void> deleteFlatById(@PathVariable("flatid")int flatId){
		flatService.deleteFlatById(flatId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/flatdetails/{flatid}")
	public ResponseEntity<Flat> viewflatDetailsById(@PathVariable("flatid") int flatId){
		Flat flat = flatService.viewFlatById(flatId);
		return new ResponseEntity<>(flat,HttpStatus.OK);
	}	
	
	@GetMapping("/all")
	public List<Flat> viewAllFlats(){
		List<Flat> flats = flatService.viewAllFlats();
		return flats;
	}

}