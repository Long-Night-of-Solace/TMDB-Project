//package com.tmdbproject.config;
//
//import com.tmdbproject.model.Movie;
//import com.tmdbproject.repository.MovieRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//
//@Configuration
//
//public class MovieConfig {
//    @Bean
//    CommandLineRunner movieconfig(MovieRepository movieRepository){
//        return args -> {
//            Movie movie1=new Movie("movie1", "2009","True");
//            Movie movie2=new Movie("movie2", "2023","False");
//            Movie movie3=new Movie("movie3", "2005","True");
//            Movie movie4=new Movie("movie4", "2012","True");
//            Movie movie5=new Movie("movie5", "2027","False");
//            movieRepository.saveAll(Arrays.asList(movie1,movie2,movie3,movie4,movie5));
//        };
//    }
//
//}
