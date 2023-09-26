package com.apps.preetham.api.theatres.io.controllers;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.preetham.api.theatres.data.TheatreEntity;
import com.apps.preetham.api.theatres.service.TheatresService;
import com.apps.preetham.api.theatres.ui.model.SeatAllocationRequest;
import com.apps.preetham.api.theatres.ui.model.TheatreResponseModel;


@RestController
@RequestMapping
public class TheatresController {

	@Autowired
	TheatresService theatresService;


	Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping( value="/users/{id}/theatres", produces = { MediaType.APPLICATION_JSON_VALUE
			//, MediaType.APPLICATION_XML_VALUE,
	       })
	public List<TheatreResponseModel> userTheatres(@PathVariable String id) {
		List<TheatreResponseModel> returnValue = new ArrayList<>();
		List<TheatreEntity> theatresEntities = theatresService.getTheatres(id);
		if (theatresEntities == null || theatresEntities.isEmpty()) {
			return returnValue;
		}
		Type listType = new TypeToken<List<TheatreResponseModel>>() {
		}.getType();
		returnValue = new ModelMapper().map(theatresEntities, listType);
		logger.info("Returning " + returnValue.size() + " theatres");
		return returnValue;
	}

	@PostMapping("/{theatreId}/showtimes/{showtimeId}/allocate-seats")
    public ResponseEntity<String> allocateSeatsForShowtime(@PathVariable Long theatreId, @PathVariable Long showtimeId, @RequestBody SeatAllocationRequest request) {
		theatresService.allocateSeatsForShowtime(theatreId, showtimeId, request);
        return ResponseEntity.ok("Seats updated successfully");
    }
	
}
