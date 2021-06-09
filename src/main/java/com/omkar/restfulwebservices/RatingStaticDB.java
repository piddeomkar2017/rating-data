package com.omkar.restfulwebservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public class RatingStaticDB {

	private static List<Rating> li = new ArrayList();
	static
	{
		li.add(new Rating("1000", 4));
		li.add(new Rating("3000", 5));
	}
	
	public Rating getRatingByMovieId(String movieId)
	{
		for(Rating r : li)
		{
			if(r.getMovieId().equals(movieId))
			{
				return r;
			}
		}
		return new Rating("Not Found",0);
	}
	public List<Rating> getAll()
	{
		return li;
	}
	public void addRating(Rating rating)
	{
		li.add(rating);
	}
	public void deleteById(String movieId) {
		// TODO Auto-generated method stub
		for(Rating r : li)
		{
			if(r.getMovieId().equals(movieId))
			{
				li.remove(r);break;
			}
		}
		
	}
	
}
