package com.jpa;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.enums.RatingName;
import com.jpa.repository.MovieRepository;
import com.jpa.repository.MovieRepositoryEM;
import com.jpa.repository.RatingRepository;
import com.jpa.repository.RatingRepositoryEM;
import com.jpa.repository.model.Movie;
import com.jpa.repository.model.Rating;


@SpringBootApplication
public class App implements CommandLineRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	@Autowired
	private MovieRepositoryEM movieRepositoryEM;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private RatingRepositoryEM ratingRepositoryEM;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	public static void main (String[] args) {
		SpringApplication.run(App.class,args);
	}
	
	@Override
	public void run (String...strings) throws Exception{
		fillRatingTable();
		new Timer().schedule(insertMovieByEntityManagerTask(),100,2000);		
	}
	
	private TimerTask insertMovieByEntityManagerTask() {
		return new TimerTask() {
			@Override
			public void run() {
				Random rand= new Random();
				Movie movie = new Movie(UUID.randomUUID().toString(),90,rand.nextInt(6)+1);
				movieRepositoryEM.save(movie);
				LOGGER.info("Saved: {}", movie);
			}
		};
	}
	
	private void fillRatingTable() {
		for (int index=0;index<5; index++){
			Rating rating = new Rating(RatingName.BAD,"No good");
			ratingRepositoryEM.save(rating);
		}
	}
}
