package com.capstone.landlordmodule.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.landlordmodule.entity.Landlord;
import com.capstone.landlordmodule.exception.LandlordNotFoundException;
import com.capstone.landlordmodule.repository.ILandlordRepository;

@SpringBootTest(properties = "eureka.client.enabled=false")
public class ILandlordServiceTest {

	@InjectMocks
	private ILandlordServiceImpl landlordService;

	@Mock
	private ILandlordRepository landlordRepository;

	@Test
	public void testAddLandlord() {
		Landlord landlord = new Landlord();
		landlord.setLandlordFirstName("Venkat");
		landlord.setLandlordAge(22);
		landlord.setMobileNo("9133134411");

		when(landlordRepository.save(landlord)).thenReturn(landlord);

		Landlord addedLandlord = landlordService.addLandlord(landlord);

		verify(landlordRepository, times(1)).save(landlord);
		assertEquals(landlord, addedLandlord);
		assertEquals("Venkat", addedLandlord.getLandlordFirstName());
		assertEquals(22, addedLandlord.getLandlordAge());
		assertEquals("9133134411", addedLandlord.getMobileNo());
	}

	@Test
	void testDeleteLandlordById() {
		Landlord landlord = new Landlord();
		landlord.setLandlordId(111);
		landlord.setLandlordFirstName("Venkat");
		landlord.setLandlordLastName("Adabala");
		landlord.setLandlordAge(22);
		landlord.setMobileNo("9133134411");

		when(landlordRepository.findById(111)).thenReturn(Optional.of(landlord));
		doNothing().when(landlordRepository).delete(landlord);

		landlordService.deleteLandlordById(111);
		;
		verify(landlordRepository, times(1)).findById(111);
		verify(landlordRepository, times(1)).delete(landlord);

	}

	@Test
	void testDeleteLandlordByIdWithException() {
		Landlord landlord = new Landlord();
		landlord.setLandlordId(111);
		landlord.setLandlordFirstName("Venkat");
		landlord.setLandlordLastName("Adabala");
		landlord.setLandlordAge(22);
		landlord.setMobileNo("9133134411");

		when(landlordRepository.findById(111))
				.thenThrow(new LandlordNotFoundException("landlord is not existing with id:111"));
		assertThrows(LandlordNotFoundException.class, () -> landlordService.deleteLandlordById(111));
		verify(landlordRepository, times(0)).delete(landlord);

	}

	@Test
	public void testviewLandlordById() {
		Landlord landlord = new Landlord();
		landlord.setLandlordId(111);
		landlord.setLandlordFirstName("Venkat");
		landlord.setLandlordLastName("Adabala");
		landlord.setLandlordAge(22);
		landlord.setMobileNo("9133134411");

		when(landlordRepository.findById(111)).thenReturn(Optional.of(landlord));
		Landlord actualObj = landlordService.viewLandlordById(111);
		assertEquals("Venkat", actualObj.getLandlordFirstName());
	}

	@Test
	public void testViewLandlordByIdWithException() {
     	when(landlordRepository.findById(200))
				.thenThrow(new LandlordNotFoundException("Landlord is not existing with id:200"));
		assertThrows(LandlordNotFoundException.class, () -> landlordService.viewLandlordById(200));
	}

	@Test
	public void testViewAllLandlords() {
		Landlord landlord = new Landlord();
		landlord.setLandlordId(111);
		landlord.setLandlordFirstName("Venkat");
		landlord.setLandlordLastName("Adabala");
		landlord.setLandlordAge(21);
		landlord.setMobileNo("9133134411");

		Landlord landlord1 = new Landlord();
		landlord1.setLandlordId(222);
		landlord1.setLandlordFirstName("Mani");
		landlord.setLandlordLastName("Achanta");
		landlord1.setLandlordAge(23);
		landlord1.setMobileNo("9705731779");

		List<Landlord> landlords = new ArrayList<>();
		landlords.add(landlord);
		landlords.add(landlord1);
		when(landlordRepository.findAll()).thenReturn(landlords);
		List<Landlord> landlordList = landlordService.viewAllLandlords();
		assertEquals(2, landlordList.size());

	}
}
