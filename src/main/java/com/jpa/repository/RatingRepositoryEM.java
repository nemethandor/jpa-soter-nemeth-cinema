package com.jpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.repository.model.Rating;

@Repository
@Transactional
public class RatingRepositoryEM {

	@PersistenceContext	
	private EntityManager entityManager;
	
	public Rating save(Rating rating) {
		entityManager.persist(rating);
		return rating;
	}
		
}
