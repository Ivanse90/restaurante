package com.booking.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.api.entities.repositories.ReservationRepository;
import com.booking.api.exceptions.BookingException;
import com.booking.api.exceptions.InternalServerError;
import com.booking.api.exceptions.NotFoundException;
import com.booking.api.services.CancelReservationService;


@Service
public class CancelReservationServiceImpl implements CancelReservationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CancelReservationServiceImpl.class);
	
	@Autowired
	private ReservationRepository reservationRepository;

	public String deleteReservation(String locator) throws BookingException {

		reservationRepository.findByLocator(locator)
				.orElseThrow(() -> new NotFoundException("LOCATOR_NOT_FOUND", "LOCATOR_NOT_FOUND"));

		try {
			reservationRepository.deleteByLocator(locator);

		} catch (Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR",e);
			throw new InternalServerError("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");

		}

		return "LOCATOR_DELETED";
	}

}
