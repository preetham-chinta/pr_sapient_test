package com.apps.preetham.api.theatres.service;


import java.util.List;

import com.apps.preetham.api.theatres.data.TheatreEntity;
import com.apps.preetham.api.theatres.entity.TheatreSeats;
import com.apps.preetham.api.theatres.ui.model.SeatAllocationRequest;

public interface TheatresService {
	
    List<TheatreEntity> getTheatres(String userId);
	List<TheatreSeats> getSeatsForShowtime(Long theatreId, Long showtimeId);
	void allocateSeatsForShowtime(Long theatreId, Long showtimeId, SeatAllocationRequest request);
}
