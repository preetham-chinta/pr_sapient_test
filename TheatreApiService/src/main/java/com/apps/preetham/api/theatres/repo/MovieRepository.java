package com.apps.preetham.api.theatres.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apps.preetham.api.theatres.entity.Movie;


public interface MovieRepository extends JpaRepository<Movie, Long> {
}
