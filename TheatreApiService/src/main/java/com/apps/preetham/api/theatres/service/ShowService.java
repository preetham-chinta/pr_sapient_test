package com.apps.preetham.api.theatres.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ShowService {

	void createShows(Long theatreId, Long movieId, LocalDate fromDate, LocalDate toDate, List<LocalTime> showTimes);

	void updateShows(Long theatreId, Long movieId, LocalDate fromDate, LocalDate toDate, List<LocalTime> newShowTimes);

	void deleteShows(Long theatreId, Long movieId, LocalDate fromDate, LocalDate toDate);

}