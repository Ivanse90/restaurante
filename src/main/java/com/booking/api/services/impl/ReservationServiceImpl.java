 package com.booking.api.services.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.api.entities.Reservation;
import com.booking.api.entities.Restaurant;
import com.booking.api.entities.Turn;
import com.booking.api.entities.repositories.ReservationRepository;
import com.booking.api.entities.repositories.RestaurantRepository;
import com.booking.api.entities.repositories.TurnRepository;
import com.booking.api.exceptions.BookingException;
import com.booking.api.exceptions.InternalServerError;
import com.booking.api.exceptions.NotFoundException;
import com.booking.api.jsons.CreateReservationRest;
import com.booking.api.jsons.ReservationRest;
import com.booking.api.services.ReservationService;


@Service
public class ReservationServiceImpl implements ReservationService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private TurnRepository turnRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;

	public ReservationRest getReservation(Long reservationId) throws BookingException {
		////todo
		return null;
	}

	public String createReservation(CreateReservationRest createReservationRest) throws BookingException {

		final Restaurant restaurantId = restaurantRepository.findById(createReservationRest.getRestaurantid())
				.orElseThrow(() -> new NotFoundException("RESTAURANT_NOT_FOUND","RESTAURANT_NOT_FOUND"));
		final Turn turnId =  turnRepository.findById(createReservationRest.getTurnId())
				.orElseThrow(() -> new NotFoundException("TURN_NOT_FOUND","TURN_NOT_FOUND"));
		String locator = generateLocator(restaurantId, createReservationRest);
		
		final Reservation reservation = new Reservation();

		reservation.setLocator(locator);
		reservation.setPerson(createReservationRest.getPerson());
		reservation.setDate(createReservationRest.getDate());
		reservation.setRestaurant(restaurantId);
		reservation.setTurn(turnId.getName());
		
		
		try {
			reservationRepository.save(reservation);
			
		} catch (final Exception e){
			LOGGER.error("INTERNAL_SERVER_ERROR",e);
			throw new InternalServerError("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
			
		}
		return locator;
	}

	private String generateLocator(Restaurant restaurantId, CreateReservationRest createReservationRest)
			throws BookingException {

		return restaurantId.getName() + createReservationRest.getTurnId();

	}

}
