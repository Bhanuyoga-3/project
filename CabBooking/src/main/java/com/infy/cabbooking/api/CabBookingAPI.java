package com.infy.cabbooking.api;

import java.util.List;

//import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.cabbooking.dto.BookingDTO;
import com.infy.cabbooking.exception.CabBookingException;
import com.infy.cabbooking.service.CabBookingService;
@RestController
@RequestMapping(value="api")

public class CabBookingAPI
{   @Autowired
    private CabBookingService cabBookingService;
    @Autowired
    private Environment env;
    
   //http:localhost:8765/cabBookings/Shared
    @GetMapping("details/{bookingType}")
    public ResponseEntity<List<BookingDTO>> getDetailsByBookingType(@PathVariable String bookingType) throws CabBookingException
    {
    	List<BookingDTO> bookingDTOList=cabBookingService.getDetailsByBookingType(bookingType);
    	return new ResponseEntity<>(bookingDTOList,HttpStatus.OK);
    	
    }
    //http:localhost:8765/cabbookings/booked
    @PostMapping("/booked")
    public ResponseEntity<String> bookCab(@RequestBody BookingDTO bookingDTO) throws CabBookingException
    {
        cabBookingService.bookCab(bookingDTO);
        String message = env.getProperty("API.BOOKING_SUCCESS");
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

}
    
