package com.apps.preetham.api.theatres.io.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.preetham.api.theatres.service.ShowService;
import com.apps.preetham.api.theatres.ui.model.ShowRequestModel;

@RestController
@RequestMapping("/theatres/{theatreId}/movies/{movieId}/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping
    public ResponseEntity<Void> createShows(@PathVariable Long theatreId, @PathVariable Long movieId, @RequestBody ShowRequestModel request) {
        showService.createShows(theatreId, movieId, request.getFromDate(), request.getToDate(), request.getShowTimes());
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateShows(@PathVariable Long theatreId, @PathVariable Long movieId, @RequestBody ShowRequestModel request) {
        showService.updateShows(theatreId, movieId, request.getFromDate(), request.getToDate(), request.getNewShowTimes());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteShows(@PathVariable Long theatreId, @PathVariable Long movieId, @RequestBody ShowRequestModel request) {
        showService.deleteShows(theatreId, movieId, request.getFromDate(), request.getToDate());
        return ResponseEntity.ok().build();
    }
}
