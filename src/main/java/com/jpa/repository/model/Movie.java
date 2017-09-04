package com.jpa.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOVIE_ID")
	private Long id;

	private String name;
	private int lengthMinutes;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RATING_ID")
	private int ratingId;

	public Movie() {
	}

	public Movie(String name, int lengthMinutes, int ratingId) {
		this.name = name;
		this.lengthMinutes = lengthMinutes;
		this.ratingId = ratingId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLengthMinutes() {
		return lengthMinutes;
	}

	public void setLengthMinutes(int lengthMinutes) {
		this.lengthMinutes = lengthMinutes;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", name=" + name + ", lengthMinutes=" + lengthMinutes + ", ratingId=" + ratingId
				+ "]";
	}

}
