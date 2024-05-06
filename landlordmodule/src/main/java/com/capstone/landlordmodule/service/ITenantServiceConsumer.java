package com.capstone.landlordmodule.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.landlordmodule.model.Tenant;

@FeignClient(name = "TENANTMODULE")
public interface ITenantServiceConsumer {
	
	@GetMapping("/tenant/viewtenant/{tenantId}")
    Tenant getTenantDetailsById(@PathVariable("tenantId") int tenantId);

}
