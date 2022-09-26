package com.tmdbproject.controllers;

import com.tmdbproject.model.Movie;
import com.tmdbproject.model.QMovie;
import com.tmdbproject.service.MovieService;
import com.querydsl.jpa.impl.JPAQuery;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import org.apache.commons.io.IOUtils;
import org.noggit.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;

@RestController
@RequestMapping(path = "/MovieCatalog")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/showMoviesBetween/{x}/{y}")
    public List<Movie> showMoviesBetweenXY (@PathVariable Integer x, @PathVariable Integer y) {
        List<Movie> movieList = new ArrayList<>();
        List<Movie> movieList2 = movieService.getMovieListForController();

        for (Movie movie : movieList2) {
            if (x < Integer.parseInt(movie.getRelease_date()) && Integer.parseInt(movie.getRelease_date()) < y) {
                movieList.add(movie);
            }
        }

        return movieList;
    }
        @GetMapping("/search-{name}")
        public List<Movie>  showMoviesWithName (@PathVariable String name) {
            return movieService.getJpaQueryFactory().selectFrom(QMovie.movie).where(QMovie.movie.title.contains(name)).fetch();
        }

        @GetMapping("/orderByTitleAsc")
        public List<Movie> orderMoviesByTitleAsc () {
            return movieService.getJpaQueryFactory().selectFrom(QMovie.movie).orderBy(QMovie.movie.title.asc()).fetch();
        }

        @GetMapping("/orderByTitleDesc")
        public List<Movie> orderMoviesByTitleDesc () {
            return movieService.getJpaQueryFactory().selectFrom(QMovie.movie).orderBy(QMovie.movie.title.desc()).fetch();
        }

        @PostMapping("/addMovie")
        public Movie addMovie(@RequestBody Movie movie) {
            return movieService.saveMovie(movie);
        }

        @PostMapping("/addMovies")
        public List<Movie> addMovies(@RequestBody List<Movie> movies) {
            return movieService.saveMovies(movies);
        }

        @GetMapping("/movies")
        public List<Movie> findAllMovies() {
            return movieService.getMovies();
        }

        @GetMapping("/movie-{id}")
        public Movie findMovieById(@PathVariable Integer id) {
            return movieService.getMovieById(id);
        }

        @GetMapping("/movie/{title}")
        public Movie findMovieByTitle(@PathVariable String title) {
            return movieService.getMovieByTitle(title);
        }

        @PutMapping("/update")
        public Movie updateMovie(@RequestBody Movie movie) {
            return movieService.updateMovie(movie);
        }

        @DeleteMapping("/delete/{id}")
        public String deleteMovie(@PathVariable Integer id) {
            return movieService.deleteMovie(id);
        }

//        @GetMapping("/populateDB")
//        public void populatedb() throws IOException {
//        URL url=new URL("https://api.themoviedb.org/3/discover/movie?api_key=778b2d8ad1c79636bce968762d1d8363");
////            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
////            conn.setRequestMethod("GET");
////            conn.connect();
//            JSONObject json = new JSONObject(IOUtils.toString(new URL("https://api.themoviedb.org/3/discover/movie?api_key=778b2d8ad1c79636bce968762d1d8363"), Charset.forName("UTF-8")));
//            System.out.println(json);
//        }
//        @GetMapping("/hello")
//    public void hello(){
//            Movie movie1=new Movie("movie1", "2009");
//            Movie movie2=new Movie("movie2", "2023");
//            Movie movie3=new Movie("movie3", "2005");
//            Movie movie4=new Movie("movie4", "2012");
//            Movie movie5=new Movie("movie5", "2027","False");
//            movieService.saveMovies(Arrays.asList(movie1,movie2,movie3,movie4,movie5));
//        }

    @GetMapping("/getMovies")
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
        movieService.saveMovies(list);
    }


}
