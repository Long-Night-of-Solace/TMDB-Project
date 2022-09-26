package com.tmdbproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tmdbproject.model.Movie;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByTitle(String title);
}
