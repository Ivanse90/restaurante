package com.booking.api.services;

import com.booking.api.exceptions.BookingException;

public interface CancelReservationService {
	public String deleteReservation(String locator) throws BookingException;

}
