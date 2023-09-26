package com.apps.preetham.api.theatres.service;

import java.util.List;

import com.apps.preetham.api.theatres.entity.TheatreSeats;

public interface SeatService {

	List<TheatreSeats> getSeatsForShowtime(Long theatreId, Long showtimeId);

}