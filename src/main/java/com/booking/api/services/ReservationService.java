package com.booking.api.services;

import com.booking.api.exceptions.BookingException;
import com.booking.api.jsons.CreateReservationRest;
import com.booking.api.jsons.ReservationRest;

public interface ReservationService {
	
	ReservationRest getReservation(Long reservationId) throws BookingException;
	String createReservation(CreateReservationRest CreateReservationRest) throws BookingException;
	 

}
