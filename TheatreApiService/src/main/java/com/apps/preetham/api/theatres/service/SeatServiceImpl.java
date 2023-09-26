package com.apps.preetham.api.theatres.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.preetham.api.theatres.entity.TheatreSeats;
import com.apps.preetham.api.theatres.repo.TheatreSeatsRepository;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private TheatreSeatsRepository theatreSeatsRepository;

    @Override
	public List<TheatreSeats> getSeatsForShowtime(Long theatreId, Long showtimeId) {
    	return theatreSeatsRepository.findByTheatreId(theatreId);
    }
}
