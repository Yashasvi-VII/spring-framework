package com.yashasvi.movieApi.repositories;

import com.yashasvi.movieApi.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer>{
}
