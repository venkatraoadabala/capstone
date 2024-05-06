package com.capstone.flatbookingmodule.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.flatbookingmodule.entity.FlatBooking;
import com.capstone.flatbookingmodule.exception.FlatBookingNotFoundException;
import com.capstone.flatbookingmodule.repository.IFlatBookingRepository;

@SpringBootTest(properties = "eureka.client.enabled=false")
public class IFlatBooingServiceTest {
	@InjectMocks
	private IFlatBookingServiceImpl flatBookingService;
	@Mock
	private IFlatBookingRepository flatBookingRepository;

	@Test
	public void requestFlatBooking() {

		FlatBooking flatBooking = new FlatBooking();

		flatBooking.setBookingId(1);
		flatBooking.setBookingDate(LocalDate.of(2023, 07, 05));
		flatBooking.setBookingFromDate(LocalDate.of(2023, 07, 06));
		flatBooking.setBookingToDate(LocalDate.of(2023, 07, 25));

		when(flatBookingRepository.save(flatBooking)).thenReturn(flatBooking);

		FlatBooking addedflatBooking = flatBookingService.saveFlatBooking(flatBooking);

		verify(flatBookingRepository, times(1)).save(flatBooking);
		assertEquals(flatBooking, addedflatBooking);
	}

	@Test
	public void viewBookingDetailsById() {
		FlatBooking flatBooking = new FlatBooking();
		flatBooking.setBookingId(1);
		flatBooking.setBookingDate(LocalDate.of(2023, 07, 05));
		flatBooking.setBookingFromDate(LocalDate.of(2023, 07, 06));
		flatBooking.setBookingToDate(LocalDate.of(2023, 07, 25));

		when(flatBookingRepository.findById(1)).thenReturn(Optional.of(flatBooking));
		FlatBooking actualObj = flatBookingService.viewBookingDetailsById(1);
		assertEquals(LocalDate.of(2023, 07, 05), actualObj.getBookingDate());
	}

	@Test
	public void viewBookingByIdException() {

		when(flatBookingRepository.findById(200))
				.thenThrow(new FlatBookingNotFoundException("Landlord is not existing with id:200"));
		assertThrows(FlatBookingNotFoundException.class, () -> flatBookingService.viewBookingDetailsById(200));
	}

	@Test
	public void testviewAllBooking() {

		FlatBooking flatBooking = new FlatBooking();

		flatBooking.setBookingId(1);
		flatBooking.setBookingDate(LocalDate.of(2023, 07, 05));
		flatBooking.setBookingFromDate(LocalDate.of(2023, 07, 06));
		flatBooking.setBookingToDate(LocalDate.of(2023, 07, 25));
		FlatBooking flatBooking1 = new FlatBooking();

		flatBooking1.setBookingId(2);
		flatBooking1.setBookingDate(LocalDate.of(2023, 07, 07));
		flatBooking1.setBookingFromDate(LocalDate.of(2023, 07, 21));
		flatBooking1.setBookingToDate(LocalDate.of(2023, 07, 29));

		List<FlatBooking> flatBookings = new ArrayList<>();
		flatBookings.add(flatBooking);
		flatBookings.add(flatBooking);
		when(flatBookingRepository.findAll()).thenReturn(flatBookings);
		List<FlatBooking> flatBookingList = flatBookingService.viewAllBooking();
		assertEquals(2, flatBookingList.size());

	}

}
