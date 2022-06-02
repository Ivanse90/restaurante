package com.booking.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.booking.api.exceptions.BookingException;
import com.booking.api.jsons.CreateReservationRest;
import com.booking.api.jsons.ReservationRest;
import com.booking.api.responses.BookingResponse;
import com.booking.api.services.ReservationService;

@RestController
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "reservation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<String> createReservation(@RequestBody CreateReservationRest createReservationRest)
			throws BookingException {

		return new BookingResponse<>("SUCCES", String.valueOf(HttpStatus.OK), "OK",
				reservationService.createReservation(createReservationRest));
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "reservation" + "/{" + "reservationtId"
			+ "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<ReservationRest> getReservationById(Long reservationtId) throws BookingException {
		return new BookingResponse<>("SUCCES", String.valueOf(HttpStatus.OK), "OK",
				reservationService.getReservation(reservationtId));
	}

}
