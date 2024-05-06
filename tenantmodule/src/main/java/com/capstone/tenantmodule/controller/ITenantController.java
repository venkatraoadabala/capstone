package com.capstone.tenantmodule.controller;

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


import com.capstone.tenantmodule.entity.Tenant;
import com.capstone.tenantmodule.model.Flat;
import com.capstone.tenantmodule.model.FlatBooking;
import com.capstone.tenantmodule.service.IFlatBookingConsumer;
import com.capstone.tenantmodule.service.IFlatServiceConsumer;
import com.capstone.tenantmodule.service.ITenantService;


@RestController
@RequestMapping("/tenant")
public class ITenantController {
	
	@Autowired
    private ITenantService tenantService;
	
	@Autowired
	private IFlatBookingConsumer flatBookingService;
	
	
	@Autowired
	private IFlatServiceConsumer flatService;


    @PostMapping("/save")
    public ResponseEntity<Tenant> addTenant(@RequestBody Tenant tenant) {
    	tenantService.addTenant(tenant);
		ResponseEntity<Tenant> responseEntity = new ResponseEntity<>(tenant,HttpStatus.CREATED);
		return responseEntity;
	}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTenant(@PathVariable("id") int tenantId) {
    	tenantService.deleteTenant(tenantId);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}

    @GetMapping("/all")
    public List<Tenant> viewAllTenants() {
        List<Tenant> tenants=tenantService.viewAllTenants();
        return tenants;
    }
    @GetMapping("/viewtenant/{id}")
    public ResponseEntity<Tenant> getTenantById(@PathVariable("id") int tenantId) {
        Tenant tenant= tenantService.viewTenantById(tenantId);
        return new ResponseEntity<>(tenant,HttpStatus.OK);
    }
    @GetMapping("/flat/all")
    public List<Flat> viewAllFlats() {
        List<Flat> flats=flatService.viewAllFlats();
        return flats;
}
    @GetMapping("/booking/status/{id}")
	public ResponseEntity<String> viewBookingStatus(@PathVariable("id") int bookingId) {
	    String bookingStatus = flatBookingService.viewBookingStatusById(bookingId);
	    return new ResponseEntity<>(bookingStatus, HttpStatus.OK);
	}
    @PostMapping("/booking/requestbooking")
    public ResponseEntity<FlatBooking>requestflatBooking(@RequestBody FlatBooking flatBooking){
    	 FlatBooking newFBooking = flatBookingService.requestflatBooking(flatBooking);
 		return new ResponseEntity<>(newFBooking, HttpStatus.CREATED);
 	}
    	
}