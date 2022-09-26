package com.tmdbproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.solr.client.solrj.beans.Field;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tmdbprojectapplication")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Field
    private Integer id;

    @Field
    @Column(name = "title")
    @JsonProperty("title")
    private String title;

    @Field
    @Column(name = "release_date")
    @JsonProperty("release_date")
    private String release_date;

//    @Field
//    @Column(name = "released")
//    @JsonProperty("released")
//    private String released;

//    @Field
//    @Column(name = "plot")
//    @JsonProperty("plot")
//    private String plot;
//
//    @Field
//    @Column(name = "rated")
//    @JsonProperty("rated")
//    private String rated;
//
//    @Field
//    @Column(name = "genre")
//    @JsonProperty("genre")
//    private String genre;
//
//    @Field
//    @Column(name = "imdbRating")
//    @JsonProperty("imdbRating")
//    private String imdbRating;
//
//    @Field
//    @Column(name = "actors")
//    @JsonProperty("actors")
//    private String actors;
//
//    @Field
//    @Column(name = "writer")
//    @JsonProperty("writer")
//    private String writer;
//
//    @Field
//    @Column(name = "director")
//    @JsonProperty("director")
//    private String director;

    public Movie(
                 String title,
                 String release_date
//                 String released
//                 String plot,
//                 String rated,
//                 String genre,
//                 String imdbRating,
//                 String actors,
//                 String writer,
//                 String director
                    )
                    {
        this.title = title;
        this.release_date = release_date;
//        this.released = released;
//        this.plot = plot;
//        this.rated = rated;
//        this.genre = genre;
//        this.imdbRating = imdbRating;
//        this.actors = actors;
//        this.writer = writer;
//        this.director = director;
    }

         public Movie() {
        }

        public Integer getId () {
            return id;
        }

//        public void setId (Integer id){
//            this.id = id;
//        }

        public String getTitle () {
            return title;
        }

        public void setTitle (String title){
            this.title = title;
        }

        public String getRelease_date () {
            return release_date;
        }

        public void setRelease_date (String release_date){
            this.release_date = release_date;
        }

//        public String getReleased () {
//            return released;
//        }
//
//        public void setReleased (String released){
//            this.released = released;
//        }

//        public String getPlot () {
//            return plot;
//        }
//
//        public void setPlot (String plot){
//            this.plot = plot;
//        }
//
//        public String getRated () {
//            return rated;
//        }
//
//        public void setRated (String rated){
//            this.rated = rated;
//        }
//
//        public String getGenre () {
//            return genre;
//        }
//
//        public void setGenre (String genre){
//            this.genre = genre;
//        }
//
//        public String getImdbRating () {
//            return imdbRating;
//        }
//
//        public void setImdbRating (String imdbRating){
//            this.imdbRating = imdbRating;
//        }
//
//        public String getActors () {
//            return actors;
//        }
//
//        public void setActors (String actors){
//            this.actors = actors;
//        }
//
//        public String getWriter () {
//            return writer;
//        }
//
//        public void setWriter (String writer){
//            this.writer = writer;
//        }
//
//        public String getDirector () {
//            return director;
//        }
//
//        public void setDirector (String director){
//            this.director = director;
//        }

        @Override
        public String toString () {
            return "Movie{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", release_date=" + release_date +
//                    ", released='" + released + '\'' +
//                    ", plot='" + plot + '\'' +
//                    ", rated='" + rated + '\'' +
//                    ", genre='" + genre + '\'' +
//                    ", imdbRating=" + imdbRating +
//                    ", actors='" + actors + '\'' +
//                    ", writer='" + writer + '\'' +
//                    ", director='" + director + '\'' +
                    '}';
        }
}
