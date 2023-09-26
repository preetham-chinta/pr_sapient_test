package com.apps.preetham.api.theatres.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apps.preetham.api.theatres.entity.SeatBooking;


public interface SeatBookingRepository extends JpaRepository<SeatBooking, Long> {
    List<SeatBooking> findByShowtimeId(Long showtimeId);
}
