package com.jpa.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jpa.enums.RatingName;

@Entity
@Table(name="ratings")
public class Rating {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RATING_ID")
	@OneToMany(mappedBy ="ratings", fetch = FetchType.EAGER)
	private int id;
	
	private RatingName ratingName;
	
	private String description;

	public Rating() {
	}

	public Rating(RatingName ratingName, String description) {
		this.ratingName = ratingName;
		this.description = description;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RatingName getRatingName() {
		return ratingName;
	}

	public void setRatingName(RatingName ratingName) {
		this.ratingName = ratingName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Ratings [id=" + id + ", ratingName=" + ratingName + ", description=" + description + "]";
	}
	
		
		

}
