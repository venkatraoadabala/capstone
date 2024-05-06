package com.capstone.landlordmodule.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="landlord_tbl")
public class Landlord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int landlordId;
    private String landlordFirstName;
    private String landlordLastName;
    private int landlordAge;
    private String mobileNo;
    
    public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getLandlordId() {
		return landlordId;
	}
	public void setLandlordId(int landlordId) {
		this.landlordId = landlordId;
	}
	public int getLandlordAge() {
		return landlordAge;
	}
	public void setLandlordAge(int landlordAge) {
		this.landlordAge = landlordAge;
	}
	public String getLandlordFirstName() {
		return landlordFirstName;
	}
	public void setLandlordFirstName(String landlordFirstName) {
		this.landlordFirstName = landlordFirstName;
	}
	public String getLandlordLastName() {
		return landlordLastName;
	}
	public void setLandlordLastName(String landlordLastName) {
		this.landlordLastName = landlordLastName;
	}
	
}
