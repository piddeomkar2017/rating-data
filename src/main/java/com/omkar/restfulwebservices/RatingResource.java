package com.omkar.restfulwebservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/ratingdata")
public class RatingResource {

	@Autowired
	private RatingStaticDB db;
	
	@GetMapping("/{userId}/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId)
	{
		return db.getRatingByMovieId(movieId);
	}
	
	@GetMapping("/{userId}")
	public UserRating getAllRating(@PathVariable("userId") String userId)
	{
		//System.out.print(userId+": ");
		UserRating ur = new UserRating();
		List<Rating> temp = db.getAll();
		ur.setUserRating(temp);
		return ur; 
	}
	@PostMapping("/{userId}/")
	public void addRating(@RequestBody Rating rating )
	{
		db.addRating(rating);
		System.out.println("to add info "+rating.getMovieId()+" "+rating.getRating());
	}
	@DeleteMapping("/{movieId}")
	public void deleteRating(@PathVariable("movieId") String movieId)
	{
		db.deleteById(movieId);
	}
	
}
