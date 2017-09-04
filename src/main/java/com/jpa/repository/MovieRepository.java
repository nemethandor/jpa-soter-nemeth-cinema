package com.jpa.repository;

import java.util.List;

import com.jpa.repository.model.Movie;

public interface MovieRepository {

	List<Movie> findByName(String name);

}
