package com.capstone.tenantmodule.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.capstone.tenantmodule.model.Flat;

@FeignClient(name="FLATMODULE")
public interface IFlatServiceConsumer {
	
	@GetMapping("/flat/all")
	List<Flat> viewAllFlats();

}
