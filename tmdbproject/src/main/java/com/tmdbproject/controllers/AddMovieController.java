package com.tmdbproject.controllers;

import com.tmdbproject.model.Movie;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/tmdb")
public class AddMovieController {

    @GetMapping("/searchMovie")
    @ResponseBody
    public String searchMovieDbApi(@RequestParam String query)
    {
        RestTemplate restTemplate=new RestTemplate();
                String apiUrl="https://api.themoviedb.org/3/search/movie?api_key=778b2d8ad1c79636bce968762d1d8363&&language=en-US&page=1&include_adult=false&query=" + query;
        return restTemplate.getForEntity(apiUrl,String.class).getBody();
    }
    @GetMapping("/getUpcomingMovies")
    @ResponseBody
    public void getMovieFromTmdb()
    {
        TmdbMovies tmdbMovies=new TmdbApi("778b2d8ad1c79636bce968762d1d8363").getMovies();
        List<Movie> list=tmdbMovies.getUpcoming("en",1,"US").getResults().stream().map(
                movie -> {
                    Movie moviem=new Movie();
                    moviem.setTitle(movie.getTitle());
                    moviem.setRelease_date(movie.getReleaseDate());
                    return moviem;
                }
        ).collect(Collectors.toList());

    }
}
