package com.apps.preetham.api.theatres.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.preetham.api.theatres.entity.Movie;
import com.apps.preetham.api.theatres.entity.Show;
import com.apps.preetham.api.theatres.entity.Showtime;
import com.apps.preetham.api.theatres.entity.Theatre;
import com.apps.preetham.api.theatres.repo.ShowRepository;
import com.apps.preetham.api.theatres.repo.ShowtimeRepository;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowtimeRepository showTimeRepository;

    @Override
	public void createShows(Long theatreId, Long movieId, LocalDate fromDate, LocalDate toDate, List<LocalTime> showTimes) {
        Theatre theatre = new Theatre();
        theatre.setId(theatreId);
        Movie movie = new Movie();
        movie.setId(movieId);

        List<Show> shows = new ArrayList<>();
        for (LocalDate date = fromDate; !date.isAfter(toDate); date = date.plusDays(1)) {
            Show show = new Show();
            show.setTheatre(theatre);
            show.setMovie(movie);
            show.setShowDate(date);
            shows.add(show);
        }
        showRepository.saveAll(shows);

        for (Show show : shows) {
            for (LocalTime time : showTimes) {
                Showtime showTime = new Showtime();
                showTime.setShow(show);
                showTime.setStartTime(time);
                showTime.setEndTime(time.plusHours(2)); // Assuming 2 hours for simplicity
                showTimeRepository.save(showTime);
            }
        }
    }
    
    @Override
	public void updateShows(Long theatreId, Long movieId, LocalDate fromDate, LocalDate toDate, List<LocalTime> newShowTimes) {
        List<Show> shows = showRepository.findByTheatreIdAndMovieIdAndShowDateBetween(theatreId, movieId, fromDate, toDate);
        for (Show show : shows) {
            List<Showtime> existingShowTimes = showTimeRepository.findByShowId(show.getId());
            Show persist_show = new Show();
            show.setId(show.getId());
            showTimeRepository.deleteAll(existingShowTimes);
            for (LocalTime time : newShowTimes) {
                Showtime showTime = new Showtime();
                showTime.setShow(persist_show);
                showTime.setStartTime(time);
                showTime.setEndTime(time.plusHours(2)); // Assuming 2 hours for simplicity
                showTimeRepository.save(showTime);
            }
        }
    }
    
    @Override
	public void deleteShows(Long theatreId, Long movieId, LocalDate fromDate, LocalDate toDate) {
        List<Show> shows = showRepository.findByTheatreIdAndMovieIdAndShowDateBetween(theatreId, movieId, fromDate, toDate);
        for (Show show : shows) {
            List<Showtime> showTimes = showTimeRepository.findByShowId(show.getId());
            showTimeRepository.deleteAll(showTimes);
        }
        showRepository.deleteAll(shows);
    }
}
