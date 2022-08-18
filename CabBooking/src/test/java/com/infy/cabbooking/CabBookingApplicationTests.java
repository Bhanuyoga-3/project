package com.infy.cabbooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.cabbooking.dto.BookingDTO;
import com.infy.cabbooking.dto.CabDTO;
import com.infy.cabbooking.entity.Booking;
import com.infy.cabbooking.entity.Cab;
import com.infy.cabbooking.exception.CabBookingException;
import com.infy.cabbooking.repository.BookingRepository;
import com.infy.cabbooking.repository.CabRepository;
import com.infy.cabbooking.service.CabBookingService;
import com.infy.cabbooking.service.CabBookingServiceImpl;

@SpringBootTest
public class CabBookingApplicationTests {

	
	@Mock
	private CabRepository cabRepository;
	

	@Mock
	private BookingRepository bookingRepository;
	
	@InjectMocks
	private CabBookingService cabBookingService = new CabBookingServiceImpl();
	
    @Test
	public void bookCabInvalidCabNoTest() throws Exception{
		BookingDTO bookingDTO = new BookingDTO();
		bookingDTO.setCustomerName("Robert");
		bookingDTO.setBookingId(1001);
		bookingDTO.setPhoneNo(9867542341L);
		bookingDTO.setBookingType("Personal");
		CabDTO cabDTO = new CabDTO();
		cabDTO.setCabNo(451678);
		cabDTO.setDriverPhoneNo(9947835654L);
		cabDTO.setModelName("Toyota");
		cabDTO.setAvailability("Yes");
		bookingDTO.setCabDTO(cabDTO);
        CabDTO cab = new CabDTO();
		cab.setCabNo(159721);
		cab.setDriverPhoneNo(9947835654L);
		cab.setAvailability("Yes");
		cab.setModelName("Toyota");
		Mockito.<Optional<Cab>>when(cabRepository.findById(cabDTO.getCabNo())).thenReturn(Optional.empty());
		CabBookingException cbe = Assertions.assertThrows(CabBookingException.class,()->cabBookingService.bookCab(bookingDTO));
		Assertions.assertEquals("Service.CAB_NOT_FOUND", cbe.getMessage());
	}
@Test
	public void getDetailsByBookingTypeNoDetailsFound() throws Exception {
		BookingDTO bookingDTO = new BookingDTO();
		bookingDTO.setCustomerName("Robert");
		bookingDTO.setBookingId(1001);
		bookingDTO.setPhoneNo(9867542341L);
		bookingDTO.setBookingType("Shared");
		CabDTO cabDTO = new CabDTO();
		cabDTO.setDriverPhoneNo(9947835654L);
		cabDTO.setModelName("Toyota");
		cabDTO.setAvailability("Yes");
		bookingDTO.setCabDTO(cabDTO);
		List<Booking> bookings = new ArrayList<>();
        Booking b = new Booking();
		b.setCustomerName("Robert");
		b.setBookingId(1001);
		b.setPhoneNo(9947835654L);
		b.setBookingType("Share");
		Cab cab = new Cab();
		cab.setDriverPhoneNo(9947835654L);
		cab.setAvailability("Yes");
		cab.setModelName("Toyota");
		b.setCab(cab);
		bookings.add(b);
		BookingDTO booking1 = new BookingDTO();
		booking1.setCustomerName("Robert");
		booking1.setBookingId(1001);
		booking1.setPhoneNo(9867542341L);
		b.setBookingType("Share");

        CabDTO cab1 = new CabDTO();
		cab1.setDriverPhoneNo(9947835654L);
		cab1.setAvailability("Yes");
		cab1.setModelName("Toyota");
		booking1.setCabDTO(cab1);
		Mockito.<Optional<Cab>>when(cabRepository.findById(cabDTO.getCabNo())).thenReturn(Optional.empty());
		CabBookingException cbe = Assertions.assertThrows(CabBookingException.class,()->cabBookingService.bookCab(bookingDTO));
		Assertions.assertEquals("Service.CAB_NOT_FOUND", cbe.getMessage());

	}
	

}