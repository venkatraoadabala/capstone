package com.capstone.tenantmodule.exception;

public class TenantNotFoundException extends RuntimeException {

	public TenantNotFoundException() {

	}

	public TenantNotFoundException(String msg) {
		super(msg);
	}

}
