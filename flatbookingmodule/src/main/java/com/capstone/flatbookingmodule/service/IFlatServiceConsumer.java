package com.capstone.flatbookingmodule.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.flatbookingmodule.model.Flat;



@FeignClient(name="FLATMODULE")
public interface IFlatServiceConsumer {
	
	@GetMapping("/flat/flatdetails/{flatid}")
	Flat viewFlatById(@PathVariable("flatid") int flatId);
	
}
