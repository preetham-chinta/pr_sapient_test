package com.apps.preetham.api.theatres.io.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.apps.preetham.api.theatres.entity.TheatreSeats;
import com.apps.preetham.api.theatres.service.SeatService;

@RestController
public class SeatController {
	
	@Autowired
	private SeatService seatService;
	
	@GetMapping("/{theatreId}/showtimes/{showTimeId}/seats")
	public ResponseEntity<List<TheatreSeats>> getSeatsForShowtime(@PathVariable Long theatreId,
			@PathVariable Long showTimeId) {
		List<TheatreSeats> seats = seatService.getSeatsForShowtime(theatreId, showTimeId);
		return ResponseEntity.ok(seats);
	}

}
