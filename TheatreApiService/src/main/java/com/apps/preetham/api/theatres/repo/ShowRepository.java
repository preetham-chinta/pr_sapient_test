package com.apps.preetham.api.theatres.repo;
 
import java.time.LocalDate; 
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apps.preetham.api.theatres.entity.Show;


public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByTheatreIdAndMovieIdAndShowDateBetween(Long theatreId, Long movieId, LocalDate fromDate, LocalDate toDate);
}

