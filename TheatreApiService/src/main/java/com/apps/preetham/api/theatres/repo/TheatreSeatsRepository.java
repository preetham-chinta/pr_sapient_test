package com.apps.preetham.api.theatres.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apps.preetham.api.theatres.entity.TheatreSeats;


public interface TheatreSeatsRepository extends JpaRepository<TheatreSeats, Long> {
	List<TheatreSeats> findByTheatreId(Long theatreId);
	List<TheatreSeats> findByIdIn(List<Long> ids);
	List<TheatreSeats> findByTheatreIdAndRowIn(Long theatreId, List<String> rows);
	List<TheatreSeats> findByTheatreIdAndSeatTypeIn(Long theatreId, List<String> seatTypes);

}