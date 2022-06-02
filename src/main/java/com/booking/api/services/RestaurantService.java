package com.booking.api.services;

import java.util.List;

import com.booking.api.exceptions.BookingException;
import com.booking.api.jsons.RestaurantRest;

public interface RestaurantService {
	
	RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;
	
	public List<RestaurantRest> getRestaurants() throws BookingException;
	

}
