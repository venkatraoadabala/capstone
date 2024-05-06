package com.capstone.landlordmodule.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capstone.landlordmodule.model.Flat;

@FeignClient(name = "FLATMODULE")
public interface IFlatServiceConsumer {
	@PostMapping("/flat/save")
    Flat saveFlat(@RequestBody Flat flat);
	
	@DeleteMapping("/flat/delete/{flatid}")
	void deleteFlatById(@PathVariable("flatid")int flatId);
}
