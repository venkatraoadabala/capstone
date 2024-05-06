package com.capstone.tenantmodule.service;

import java.util.List;

import com.capstone.tenantmodule.entity.Tenant;

public interface ITenantService {
	
	Tenant addTenant(Tenant tenant);

	void deleteTenant(int tenantId);

	List<Tenant> viewAllTenants();
	
	Tenant viewTenantById(int tenantId);

}
