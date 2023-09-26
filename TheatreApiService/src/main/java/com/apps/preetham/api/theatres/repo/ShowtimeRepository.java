package com.apps.preetham.api.theatres.repo;

import java.util.List;  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apps.preetham.api.theatres.entity.Showtime;


public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
    List<Showtime> findByShowId(Long showId);
    void deleteByShowId(Long showId);
}
