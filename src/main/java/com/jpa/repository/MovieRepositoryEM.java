package com.jpa.repository;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.repository.model.Movie;

@Repository
@Transactional
public class MovieRepositoryEM {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Movie save(Movie movie) {
		entityManager.persist(movie);
		return (movie);
	}
	
	public Movie findById(long id) {
		return entityManager.find(Movie.class, id);
	}
	
	public List<Movie> findByName(String name){
		return entityManager
				.createNamedQuery("findByName",Movie.class)
				.setParameter("name", name)
				.setMaxResults(10)
				.getResultList();
	}
	

}
