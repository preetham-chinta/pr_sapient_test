package com.apps.preetham.api.users.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.apps.preetham.api.users.ui.model.TheatreResponseModel;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "theatre-ws")
public interface TheatreServiceClient {

	@GetMapping("/users/{id}/theatres")
	@Retry(name="theatre-ws")
	@CircuitBreaker(name="theatre-ws", fallbackMethod="getTheatresFallback")
	public List<TheatreResponseModel> getTheatres(@PathVariable String id);
	
	default List<TheatreResponseModel> getTheatresFallback(String id, Throwable exception) {
		System.out.println("Param = " + id);
		System.out.println("Exception class=" + exception.getClass().getName());
		System.out.println("Exception took place: " + exception.getMessage());
		return new ArrayList<>();
	}
}



